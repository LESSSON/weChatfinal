package com.example.fmx.webchat_demo;

import android.app.Service;
import android.os.Bundle;
import android.os.Message;
import android.os.strictmode.CleartextNetworkViolation;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;

public class ClientThread implements Runnable {
    private BufferedReader bufferedReader;
//    public String URL_PATH = "192.168.20.168";
//    public int SOCKET_PORT = 50000;

    private static Socket socket321;

    public void run(){
        try{
            Log.i("qaz","qaz");
//            socket321 = new Socket(URL_PATH,SOCKET_PORT);
            bufferedReader = new BufferedReader(new InputStreamReader(MainActivity.socket_user.getInputStream()));
            Log.i("buffer123","buffer is " + bufferedReader );
            String content = null;
            while((content = bufferedReader.readLine()) != null){
                Bundle bundle = new Bundle();
                bundle.putString("info",content);
                Log.i("bundle123","bundle is "+bundle);
                Message msg = new Message();
                msg.setData(bundle);        //将数据封装到Message对象中
                MainActivity.handler.sendMessage(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
