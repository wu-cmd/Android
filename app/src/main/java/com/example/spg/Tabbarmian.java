package com.example.spg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import module.Fenlei.Feilei;
import module.Gwc.Gwc;
import module.Mine.Mine;
import module.Sy.Sy;
public class Tabbarmian extends AppCompatActivity implements View.OnClickListener {
    protected LinearLayout mMenuMain;
    protected LinearLayout mMenuMe;
    protected LinearLayout mMenuFind;
    protected LinearLayout mMenugwc;
    //定义Fragment
    protected Sy sy = new Sy();
    protected Feilei feilei= new Feilei();
    protected Mine mine = new Mine ();
    protected Gwc gwc = new Gwc();
    protected ImageView iv_home;
    protected ImageView iv_fq;
    protected ImageView iv_gwc;
    protected ImageView iv_mine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbarmain);
        initView();
        //获取管理类
        this.getSupportFragmentManager ()
                .beginTransaction ()
                .add (R.id.container_content,sy)   //增加容器里面的fragment
                .add (R.id.container_content,mine)
                .hide (mine)               //隐藏
                .add (R.id.container_content,feilei)
                .hide (feilei)   //隐藏
                .add (R.id.container_content,gwc)
                .hide (gwc)   //隐藏
                .commit ();  //提交
        iv_home.setSelected(true);

    }
    //初始化
    private void initView() {
        mMenuMain = this.findViewById(R.id.menu_main);
        mMenuFind = this.findViewById(R.id.menu_find);
        mMenuMe = this.findViewById(R.id.menu_me);
        mMenugwc = this.findViewById(R.id.gwc);
        iv_home = findViewById(R.id.iv_home);
        iv_fq = findViewById(R.id.iv_fq);
        iv_gwc = findViewById(R.id.iv_gwc);
        iv_mine = findViewById(R.id.iv_mine);
        mMenuMain.setOnClickListener(this);
        mMenuMe.setOnClickListener(this);
        mMenuFind.setOnClickListener(this);
        mMenugwc.setOnClickListener(this);
    }
        @Override
        public void onClick(View v) {
            switch (v.getId ()){
                case R.id.menu_main:
                    this.getSupportFragmentManager ()
                            .beginTransaction ()
                            .show (sy)
                            .hide (mine)               //隐藏
                            .hide (feilei)
                            .hide (gwc)//隐藏
                            .commit ();
                    iv_home.setSelected(true);
                    iv_fq.setSelected(false);
                    iv_gwc.setSelected(false);
                    iv_mine.setSelected(false);
                    break;
                case R.id.menu_find:
                    this.getSupportFragmentManager ()
                            .beginTransaction ()
                            .show (feilei)
                            .hide (sy)
                            .hide (mine)
                            .hide (gwc)//隐藏
                            .commit ();
                    iv_home.setSelected(false);
                    iv_fq.setSelected(true);
                    iv_gwc.setSelected(false);
                    iv_mine.setSelected(false);
                    break;
                case R.id.menu_me:
                    this.getSupportFragmentManager ()
                            .beginTransaction ()
                            .show (mine)
                            .hide (sy)
                            .hide (feilei)   //隐藏
                            .hide (gwc)//隐藏
                            .commit ();
                    iv_home.setSelected(false);
                    iv_fq.setSelected(false);
                    iv_gwc.setSelected(false);
                    iv_mine.setSelected(true);
                    break;
                case R.id.gwc:
                    this.getSupportFragmentManager ()
                            .beginTransaction ()
                            .show (gwc)
                            .hide (sy)
                            .hide (feilei)   //隐藏
                            .hide (mine)   //隐藏
                            .commit ();
                    iv_home.setSelected(false);
                    iv_fq.setSelected(false);
                    iv_gwc.setSelected(true);
                    iv_mine.setSelected(false);
                    break;
            }

    }

}