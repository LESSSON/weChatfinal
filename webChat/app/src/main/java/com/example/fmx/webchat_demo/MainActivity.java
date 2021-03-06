package com.example.fmx.webchat_demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    private static ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;
    public static String duimianderen;
    public static String URL_PATH = "192.168.1.106";
    public static int SOCKET_PORT = 50000;
    private static ClientThread clientThread;
    public static Socket socket_user ;
    public OutputStream os;
    private String username;
    private String userpass;


    private static List<Msg> msgList = new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.chat_view);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        userpass = intent.getStringExtra("password");

        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    socket_user = new Socket(URL_PATH, SOCKET_PORT);
                    os = socket_user.getOutputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final String liu = Main_Log.Mynames+ Main_Log.Mypassword+ "\n";

        new Thread(){
            @Override
            public void run() {
                try {
                    os.write(liu.getBytes("utf-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();


        new Thread(new ClientThread()).start();


        initMsgs();
        adapter = new MsgAdapter(MainActivity.this, R.layout.chat_item, msgList);
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgListView = (ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String content = inputText.getText().toString();



                try {
                    String liu = duimianderen +"/" + content + "\n";
                    os.write(liu.getBytes("utf-8"));
                    Log.i("socket111" , "socket_name is " + socket_user);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");

                }
            }
        });
    }

    private void initMsgs() {
        Msg msg1 = new Msg("开始聊天吧！", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
    }

    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            String content = bundle.getString("info");

            String[] m = content.split("/");
//            if(m[1] == duimianderen) {
            Msg msg2 = new Msg(m[1], 0);

            MainActivity.msgList.add(msg2);
            MsgAdapter adapter1 = null;
            adapter1 = (MsgAdapter) MainActivity.msgListView.getAdapter();
            adapter1.notifyDataSetChanged();
//            }
        }
    };




}




