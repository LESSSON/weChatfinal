//package com.example.fmx.webchat_demo;
//
//import android.content.Context;
//import android.support.annotation.LayoutRes;
//import android.support.annotation.NonNull;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AdapterChatMsg extends ArrayAdapter<ChatMsg> {
//
//    private LayoutInflater inflater;
//    private List<ChatMsg> chatMsgs = new ArrayList<ChatMsg>();
//    public AdapterChatMsg(@NonNull Context context, @LayoutRes int resource, List<ChatMsg> chatMsgs){
//        super(context,resource);
//        this.inflater = LayoutInflater.from(context);
//        this.chatMsgs = chatMsgs;
//    }
//
//    @Override
//    public int getCount(){
//        return chatMsgs.size();
//    }
//
//    @NonNull
//    @Override
//    public ChatMsg getItem(int position){
//        return chatMsgs.get(position);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @NonNull View converView, @NonNull ViewGroup parent){
//        ChatMsg msg = getItem(position);
//        View view;
//        ViewHolder viewHolder;
//
//        if(converView == null){
////            assert  msg != null;
//            if(msg.isMyInfo()){
//                view = inflater.inflate(R.layout.chat_me,parent,false);
//            }else {
//                view = inflater.inflate(R.layout.chat_other,parent,false);
//            }
//            viewHolder = new ViewHolder();
//            viewHolder.icon = (ImageView) view.findViewById(R.id.icon);
//            viewHolder.username = (TextView)view.findViewById(R.id.left_msg);
//            viewHolder.content = (TextView) view.findViewById(R.id.content);
//
//            view.setTag(viewHolder);
//        }else{
//            view = converView;
//            viewHolder = (ViewHolder) view.getTag();
//        }
//        viewHolder.icon.setImageResource(chatMsgs.get(position).getIconID());
//        viewHolder.username.setText(chatMsgs.get(position).getUsername());
//        viewHolder.content.setText(chatMsgs.get(position).getContent());
//        return view;
//    }
//
//    private class ViewHolder{
//        ImageView icon;
//        TextView username;
//        TextView content;
//
//    }
//
//}
