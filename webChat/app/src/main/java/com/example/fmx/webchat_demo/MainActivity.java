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
    public static String URL_PATH = "192.168.20.168";
    public static int SOCKET_PORT = 50000;
    private static ClientThread clientThread;
    public static Socket socket_user ;
    public OutputStream os;
    private String username;
    private String userpass;
    //    private ListView chatLv;
//    private EditText myMsg;
//    private Button btnSend;
//    private Button btnReturn;
//    private static List<ChatMsg> chatMsgList;
//    private static AdapterChatMsg adapterChatMsgList;
//    private String chatObj;

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
//        LogServer(Main_Log.Mynames,Main_Log.Mypassword);

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
//
//        try {
//            socket_user = new Socket(URL_PATH, SOCKET_PORT);
//            os = socket_user.getOutputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Log.i("socket","socket is  " + socket_user);
//        final OutputStream os;
//        try {
//            os = socket_user.getOutputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            os = socket_user.getOutputStream();
//            Log.i("oss","os is " + os);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Log.i("username",username);
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
//        try {
//            os.write(liu.getBytes("utf-8"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        os.flush();
//        try {
//            os.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        new Thread(new ClientThread()).start();
//        clientThread = new ClientThread();
//        Log.i("xianchen1","xianchen1 is "+clientThread);//客户端启动ClientThread线程，读取来自服务器的数据
//        clientThread.start();
//        Log.i("xianchen2","xianchen2 is "+clientThread);

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

//                new Thread(){
////                    @Override
////                    public void run() {
////                        try {
//////                    MainActivity.SendChat(duimianderen + "/" + content);
////                            Log.i("ooo","socket_user is "+socket_user );
////                            OutputStream os2 = socket_user.getOutputStream();
////                            Log.i("os123","os is "+os2);
////                            String liu = content + "\n";
////                            Log.i("liuuu", "liu is " + liu);
////                            os2.write(liu.getBytes("utf-8"));
////                            os2.flush();
////                            os2.close();
////                            Log.i("socket111" , "socket_name is " + socket_user);
////                        } catch (IOException e) {
////                            e.printStackTrace();
////                        }
////                    }
////                }.start();

                try {
//                    MainActivity.SendChat(duimianderen + "/" + content);

//                    OutputStream os2 = socket_user.getOutputStream();
//                    Log.i("os123","os is "+os2);
                    String liu = duimianderen +"/" + content + "\n";

                    os.write(liu.getBytes("utf-8"));
//                    os2.flush();
//                    os2.close();
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
//        Msg msg2 = new Msg("Fine, thank you, and you?", Msg.TYPE_SEND);
//        msgList.add(msg2);
//        Msg msg3 = new Msg("I am fine, too!", Msg.TYPE_RECEIVED);
//        msgList.add(msg3);
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

    public  static void SendChat(String content) throws IOException {
//        Socket socket123 = new Socket(URL_PATH, SOCKET_PORT);
//        Log.i("socket123","socket123 is  "+socket123);

        OutputStream os = socket_user.getOutputStream();
        Log.i("os123","os is "+os);
        String liu = content + "\n";
        Log.i("liu", "liu is " + liu);
        os.write(liu.getBytes("utf-8"));
        os.flush();
        os.close();

    }

//    public static void LogServer(String s,String p) {
//        try {
//            socket_user = new Socket(URL_PATH, SOCKET_PORT);
//            Log.i("socket","socket is  " + socket_user);
//            OutputStream os = socket_user.getOutputStream();
//            String liu = s + p + "\n";
//            os.write(liu.getBytes("utf-8"));
//            os.flush();
//            os.close();
//            clientThread = new ClientThread();//客户端启动ClientThread线程，读取来自服务器的数据
//            clientThread.start();

//            InputStream is = socket_user.getInputStream();
//            is.close();
//            bufferedReader = new BufferedReader(new InputStreamReader(socket_user.getInputStream()));
//            while ((content = bufferedReader.readLine()) != null) {
//                f = content.toString();
//                Log.i("ffff","f is " + f);
//                if (f == "1") {
//                    try {

//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }else{
//                    clientThread = new ClientThread();//客户端启动ClientThread线程，读取来自服务器的数据
//                    clientThread.start();
//                    Toast.makeText(Main_Log.this, "登录失败", Toast.LENGTH_SHORT).show();
//
//                }

//        } catch (UnsupportedEncodingException e1) {
//            e1.printStackTrace();
//        } catch (UnknownHostException e1) {
//            e1.printStackTrace();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//    } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}




