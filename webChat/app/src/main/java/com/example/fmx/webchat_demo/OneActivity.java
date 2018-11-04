package com.example.fmx.webchat_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;




public class OneActivity extends AppCompatActivity {

    public OneActivity() {
        // Required empty public constructor
    }

    private static ListView lv = null;
    private List<String>stringList = new ArrayList<String>();
    private static String duimian;

//    private List<String> stringList;
    private static ArrayAdapter lvAdapter;

    private Button item_weixin;
    private Button item_tongxunlu;
    private Button item_faxian;
    private Button item_me;
    private String username,userpass;


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        lv =(ListView) findViewById(R.id.list_view_one);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        userpass = intent.getStringExtra("password");

        stringList = new ArrayList<String>();
        stringList.add("fmx");
        stringList.add("zxl");
        stringList.add("zc");
        stringList.add("ll");
        ArrayAdapter<String> lvAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,stringList);
        lv.setAdapter(lvAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(OneActivity.this, stringList.get(i).toString(), Toast.LENGTH_SHORT).show();
                //在界面跳转前准备好数据
                duimian =(String) stringList.get(i);
                Log.i("duimian","duimianshi" + duimian);
                MainActivity.duimianderen = duimian;


                //界面跳转
                Intent intent1 = new Intent(OneActivity.this,com.example.fmx.webchat_demo.MainActivity.class);
                intent1.putExtra("username",username);
                intent1.putExtra("password",userpass);
                startActivity(intent1);
            }
        });

//
//        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(OneActivity.this, "long click:" + stringList.get(i).toString(), Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });

//        stringList = new ArrayList<String>();
//        initData();


//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(OneActivity.this, stringList.get(i).toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

//
//        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(OneActivity.this, "long click:" + stringList.get(i).toString(), Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });


        //获取button值;
        item_weixin = (Button) findViewById(R.id.item_weixin);
        item_tongxunlu = (Button) findViewById(R.id.item_tongxunlu);
        item_faxian = (Button) findViewById(R.id.item_faxian);
        item_me = (Button) findViewById(R.id.item_me);

        //给weixin按钮添加点击事件
        item_weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OneActivity.this,OneActivity.class);
                startActivity(intent);
            }
        });

        //给tongxunlu按钮添加点击事件
        item_tongxunlu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OneActivity.this,TwoActivity.class);
                startActivity(intent);
            }
        });

        //给faxian按钮添加点击事件
        item_faxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OneActivity.this,ThreeActivity.class);
                startActivity(intent);
            }
        });

        //给me按钮添加点击事件
        item_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OneActivity.this,FourthActivity.class);
                startActivity(intent);
            }
        });
    }

//    private void initData() {
//        stringList = new ArrayList<String>();
//        for (int i = 0; i < 20; i++) {
//            stringList.add(String.valueOf(i));
//        }
//        ArrayAdapter<String> lvAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringList);
//        lv.setAdapter(lvAdapter);
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(OneActivity.this, stringList.get(i).toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(OneActivity.this, "long click:" + stringList.get(i).toString(), Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//    }

}
