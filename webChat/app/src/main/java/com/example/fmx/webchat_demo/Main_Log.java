package com.example.fmx.webchat_demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main_Log extends AppCompatActivity {
    private Button but_log_in;
    public static Socket socket_user = null;
    public String URL_PATH = "192.168.20.168";
    public int SOCKET_PORT = 50000;
    private ClientThread clientThread;
    public static String Mynames,Mypassword;
    private static EditText user_name;
    private static EditText password;
//    public static OutputStream os = null;
//    private static String content;
//    private BufferedReader bufferedReader = null;
    private static String f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //实现登陆操作;
        but_log_in = (Button) findViewById(R.id.log_in);
        user_name = (EditText) findViewById(R.id.et_usertel);
        password = (EditText) findViewById(R.id.et_password) ;

        //给but_log_in添加点击事件
        but_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mynames = user_name.getText().toString()+"/";
                Mypassword = password.getText().toString();
//                LogServer(Mynames,Mypassword);
                Intent intent = new Intent(Main_Log.this, OneActivity.class);
                intent.putExtra("username",Mynames);
                intent.putExtra("password",Mypassword);
                startActivity(intent);

            }
        });
    }

//    public void LogServer(String s,String p) {
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
//
//
//            } catch (UnsupportedEncodingException e1) {
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