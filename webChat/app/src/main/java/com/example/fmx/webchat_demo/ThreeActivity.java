package com.example.fmx.webchat_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThreeActivity extends Activity {
    public ThreeActivity() {
        // Required empty public constructor
    }

    private Button item_weixin;
    private Button item_tongxunlu;
    private Button item_faxian;
    private Button item_me;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        //获取button值;
        item_weixin = (Button) findViewById(R.id.item_weixin);
        item_tongxunlu = (Button) findViewById(R.id.item_tongxunlu);
        item_faxian = (Button) findViewById(R.id.item_faxian);
        item_me = (Button) findViewById(R.id.item_me);

        //给weixin按钮添加点击事件
        item_weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThreeActivity.this,OneActivity.class);
                startActivity(intent);
            }
        });

        //给tongxunlu按钮添加点击事件
        item_tongxunlu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThreeActivity.this,TwoActivity.class);
                startActivity(intent);
            }
        });

        //给faxian按钮添加点击事件
        item_faxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThreeActivity.this,ThreeActivity.class);
                startActivity(intent);
            }
        });

        //给me按钮添加点击事件
        item_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThreeActivity.this,FourthActivity.class);
                startActivity(intent);
            }
        });
    }
}
