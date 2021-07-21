package com.example.spg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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

    @Override
    public void onClick(View v) {
        //通过点击事件，切换fragment：
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