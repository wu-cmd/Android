package com.example.spg.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.spg.R;

public class SobLooperp extends LinearLayout {
    private ViewPager mviewPager;
    private TextView textView;
    private LinearLayout pointContainer;
    private BindTitleListener TitleSetListener = null;

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
//        等价于
//        View item = LayoutInflater.from(context).inflate(R.layout.looper_pager,this,false);
//        addView(item);
        init();  //获取三个控件，并且设置适配器获取数据
        initEvent();  //设置轮播滑动监听然后修改标题文字                     
        
    }

    private void initEvent() {
            mviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                                    切换的回调
            }

            @Override
            public void onPageSelected(int position) {
                //切换停下来得回调
//                停下来后设置标题
                if (TitleSetListener != null ){
                      textView.setText(TitleSetListener.getTitle(position));
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //状态得改变
            }
        });
    }
//    定义接口获取标题 ，给外部实现
public  interface BindTitleListener{
        String getTitle(int position);
}

    private void init() {
        initView();
    }
//    设置方法外面提供数据
public void setData(PagerAdapter innerAdapter, BindTitleListener listener) {
        this.TitleSetListener = listener;
         mviewPager.setAdapter(innerAdapter);
    }
//    获取三个 }                          控件之后设置相关数据方法
    private void initView() {
         mviewPager = this.findViewById(R.id.looper_pager_vp);
//         接数据得话需要适配器

         textView = this.findViewById(R.id.looper_title_vp);
         pointContainer = this.findViewById(R.id.looper_point_container_iv);
    }
}
