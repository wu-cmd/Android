package com.example.spg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import module.Fenlei.Feilei;
import module.Gwc.Gwc;
import module.Mine.Mine;
import module.Sy.Sy;

public class Tabbarmain extends AppCompatActivity implements View.OnClickListener {
    private Sy sy;
    private Feilei feilei;
    private Gwc gwc;
    private Mine mine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbarmain);
    }
    private void initData() {
        //初始化4个fragment
        sy     =   new Sy();
        feilei = new Feilei();
        gwc    = new Gwc();
        mine   = new Mine();

//创建第一个fragment使其显示        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, messageFragment).commit();
    }
    //UI组件初始化与事件绑定
    private void bindViews() {

        RadioButton rbTab1 = findViewById(R.id.rb_weChat);
        RadioButton rbTab2 = findViewById(R.id.rb_contact);
        RadioButton rbTab3 = findViewById(R.id.rb_discover);
        RadioButton rbTab4 = findViewById(R.id.rb_mine);

        //默认第一个选中
        rbTab1.setChecked(true);

        //添加点击事件
        rbTab1.setOnClickListener(this);
        rbTab2.setOnClickListener(this);
        rbTab3.setOnClickListener(this);
        rbTab4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //通过点击事件，切换fragment：git
        if (v.getId() == R.id.rb_weChat) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, sy).commit();

        } else if (v.getId() == R.id.rb_contact) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, feilei).commit();


        }else  if (v.getId() == R.id.rb_discover){

            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, gwc).commit();

        }else  if (v.getId() == R.id.rb_mine){

            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, mine).commit();
        }

    }
}