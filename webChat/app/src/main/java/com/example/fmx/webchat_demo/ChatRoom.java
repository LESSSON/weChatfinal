package com.example.fmx.webchat_demo;//package com.example.fmx.webchat_demo;

//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//
//import java.io.IOException;
//import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.List;
//
//    public class ChatRoom extends AppCompatActivity {
//        private ListView chatLv;
//        private EditText myMsg;
//        private Button btnSend;
//        private Button btnReturn;
//        private static List<ChatMsg> chatMsgList;
//        private static AdapterChatMsg adapterChatMsgList;
//        private String chatObj;
//        public static String duimianderen;
//
//
//    @Override
//    protected void onCreate(@NonNull Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
////        getSupportActionBar().hide();
//        setContentView(R.layout.we_chat);
//
//        btnSend = (Button) findViewById(R.id.btnSend);
//        btnReturn = (Button) findViewById(R.id.stbReturn);
//        chatLv = (ListView) findViewById(R.id.lvChat);
//        myMsg = (EditText) findViewById(R.id.editMes);
//        chatMsgList = new ArrayList<>();
//        adapterChatMsgList = new AdapterChatMsg(this,R.layout.we_chat,chatMsgList);
//        chatLv.setAdapter(adapterChatMsgList);
//
//        btnSend.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                String content = myMsg.getText().toString();
//                if(!content.isEmpty()){
//                    ChatMsg msgac = new ChatMsg();
//                    msgac.setContent(content);
//                    msgac.setUsername(Main_Log.Mynames);
//                    msgac.setIconID(R.drawable.main_button_3);
//                    msgac.setMyInfo(true);
////                    msgac.setChatObj(chatObj);
//                    chatMsgList.add(msgac);
//                    myMsg.setText("");
//                    try {
//                        SendChat(content);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        });
//
//    }

//


//    public static Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg){
//            Bundle bundle = msg.getData();
//            String content = bundle.getString("info");
//            String[] m =  content.split("/");
//            if(m[1] == duimianderen) {
//                ChatMsg msg2 = new ChatMsg();
//                msg2.setContent(m[1]);
//                msg2.setUsername(m[0]);
//                msg2.setIconID(R.drawable.main_button_3);
//                msg2.setMyInfo(false);
////            msg.setChatObj(chatObj);
//                ChatRoom.chatMsgList.add(msg2);
//            }
//            或许需要刷新
//            ChatMsg msg = new ChatMsg();
//
//            MyContent.setContent(content);  //保存聊天记录
//            MyAdapter adapter2 = null;
//            adapter2 =(MyAdapter) lv.getAdapter();
//            adapter2.setSelectedItem(position);
//            lv.setAdapter(adapter2);
//        }
//    };
//
//    public static void SendChat(String content) throws IOException {
//
//        //获取本客户端的Socket对应的输出流，以便向其发送消息
//        PrintStream printStream = new PrintStream(Main_Log.socket_user.getOutputStream());
//        //向该输出流中写入要发送到内容
//        printStream.println(content);
//    }
//
//}
