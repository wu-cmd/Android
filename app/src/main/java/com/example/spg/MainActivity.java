package com.example.spg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import module.login.register;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout =(LinearLayout)findViewById(R.id.img_lay);
        linearLayout.setSystemUiVisibility(View.INVISIBLE);  //设置不可见
        //延迟加载主页面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, register.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();

            }
        }, 2000);
    }
}