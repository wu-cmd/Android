package com.example.spg.views;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import com.example.spg.R;

import java.util.ArrayList;
import java.util.List;

public class Supermain extends AppCompatActivity {
    private SobLooperp sobLooperp;
                    //    泛型
    private List<Pageritem> mData = new ArrayList<>();//步骤3创建集合保存
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.super_main);
        initData();
        ininView();

    }
    private void initData() {
        mData.add(new Pageritem("第一张图片",R.mipmap.bluebanner));
        mData.add(new Pageritem("第二张图片",R.mipmap.redbanner));

    }
    private void ininView() {
        sobLooperp = this.findViewById(R.id.sob_looper_pager);
        sobLooperp.setData(new PagerAdapter() {
            @Override
            public int getCount() {
                return mData.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
//      3-5  载入xml布局
                View item = LayoutInflater.from(container.getContext()).inflate(R.layout.item_pager,container,false);
                ImageView iv = item.findViewById(R.id.cover);
//   步骤3-6     设置数据
                int reaoPosition = position % mData.size();
//        无限循环
                iv.setImageResource(mData.get(reaoPosition).getPicResId());
                if (iv.getParent() instanceof ViewGroup){
                    ((ViewGroup) iv.getParent()).removeView(iv);
                }
                //   步骤3-7     添加到container里面去
                container.addView(iv);
                return  iv;
            }

            @Override
            public void destroyItem(@NonNull  ViewGroup container, int position, @NonNull  Object object) {
//        销毁不然会占用内存
                container.removeView((View)object);
            }
        }, new SobLooperp.BindTitleListener() {
            @Override
            public String getTitle(int position) {
                return mData.get(position).getTitle();
            }
        });
    }
}
