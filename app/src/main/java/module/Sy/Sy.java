package module.Sy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.spg.R;

import java.util.ArrayList;
import java.util.List;

public class Sy extends Fragment {
    private ViewPager viewPager;
    private List<Integer> mData = new ArrayList<>();//步骤3创建集合保存
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        initView();//步骤1
        initData();//步骤2-1
        View square =  inflater.inflate (R.layout.activity_sy2,container,false);
        viewPager =square.findViewById(R.id.vierpage);
        viewPager.setAdapter(mPagerAdapter);
        return square;
    }
//        创建图片数据步骤2-1
    private void initData() {
        //步骤3-2保存到集合
        mData.add(R.mipmap.bluebanner);
        mData.add(R.mipmap.redbanner);
        //    步骤3-3更新操作
        mPagerAdapter.notifyDataSetChanged();
//        viewPager.setCurrentItem(Integer.MAX_VALUE / 2+1);
    }
//    获取bannner框步骤1-1
//    private void initView() {
//         viewPager =(ViewPager)getView().findViewById(R.id.vierpage);
////         设置适配器步骤2-2
//        viewPager.setAdapter(mPagerAdapter);
//    }
//    创建适配器是（内部类创建方法）步骤2-3
    private PagerAdapter mPagerAdapter = new PagerAdapter() {
    private static final String ATG = "Sy";

    @Override
    public int getCount() {
        //    步骤3-2返回集合里面的数量,要变成无线循环就不能用mData.size();
//        Log.d(ATG, "中文中文Intrger.max_value"+Integer.MAX_VALUE);
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull  View view, @NonNull Object object) {
        return view == object;
    }


    //步骤3-4，写界面
    @NonNull
    @Override
    public Object instantiateItem(@NonNull  ViewGroup container, int position) {
//      3-5  载入xml布局
      View item = LayoutInflater.from(container.getContext()).inflate(R.layout.item_pager,container,false);
        ImageView iv = item.findViewById(R.id.cover);
//   步骤3-6     设置数据
        int reaoPosition = position % mData.size();
//        无限循环
        iv.setImageResource(mData.get(reaoPosition));
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
};

}
