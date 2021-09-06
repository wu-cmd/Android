package com.example.spg.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.spg.R;

public class SobLooperp extends LinearLayout {
    public SobLooperp(Context context) {
        this(context,null);
    }

    public SobLooperp(Context context, @Nullable AttributeSet attrs) {
       this(context, attrs,0);
    }

    public SobLooperp(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        looper_pager xml  填充到这里面来
        LayoutInflater.from(context).inflate(R.layout.looper_pager,this,true);
    }
}
