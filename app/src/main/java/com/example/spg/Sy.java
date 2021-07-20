package com.example.spg;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Sy extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg_tab_bar;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private RadioButton rb_3;

    //Fragment Object
    private Fragment1 fg1;
    private Fragment2 fg2;
    private Fragment3 fg3;
    private FragmentManager fManager;
//    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sy);
        fManager = getSupportFragmentManager();
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rg_tab_bar.setOnCheckedChangeListener(this);
        //获取第一个单选按钮，并设置其为选中状态
        rb_1 = (RadioButton) findViewById(R.id.rbb_1);
        rb_2 = (RadioButton) findViewById(R.id.rbb_2);
        rb_3 = (RadioButton) findViewById(R.id.rbb_3);
        rb_1.setChecked(true);
        initView();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (checkedId){
            case R.id.rbb_1:
                if(fg1 == null){
                    fg1 = new Fragment1();
                    fTransaction.add(R.id.ly_content,fg1, "Fragment1");
                }else{
                    fTransaction.show(fg1);
                }
                break;
            case R.id.rbb_2:
                if(fg2 == null){
                    fg2 = new Fragment2();
                    fTransaction.add(R.id.ly_content,fg2, "Fragment2");
                }else{
                    fTransaction.show(fg2);
                }
                break;
            case R.id.rbb_3:
                if(fg3 == null){
                    fg3 = new Fragment3();
                    fTransaction.add(R.id.ly_content,fg3, "Fragment3");
                }else{
                    fTransaction.show(fg3);
                }
                break;
        }
        fTransaction.commit();
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
//        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg3 != null)fragmentTransaction.hide(fg3);
    }

    private void initView() {
        //定义底部标签图片大小和位置
        Drawable drawable_news = getResources().getDrawable(R.drawable.qq);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_news.setBounds(0, 0, 40, 40);
        //设置图片在文字的哪个方向
        rb_1.setCompoundDrawables(null, drawable_news, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_live = getResources().getDrawable(R.drawable.pp);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_live.setBounds(0, 0, 40, 40);
        //设置图片在文字的哪个方向
        rb_2.setCompoundDrawables(null, drawable_live, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_tuijian = getResources().getDrawable(R.drawable.oo);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_tuijian.setBounds(0, 0, 40, 40);
        //设置图片在文字的哪个方向
        rb_3.setCompoundDrawables(null, drawable_tuijian, null, null);


    }


}