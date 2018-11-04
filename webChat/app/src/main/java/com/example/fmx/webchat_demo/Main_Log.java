package com.example.fmx.webchat_demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.Socket;

public class Main_Log extends AppCompatActivity {
    private Button but_log_in;
    public static Socket socket_user = null;
    public String URL_PATH = "192.168.1.106";
    public int SOCKET_PORT = 50000;
    private ClientThread clientThread;
    public static String Mynames,Mypassword;
    private static EditText user_name;
    private static EditText password;
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


}