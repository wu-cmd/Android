package module.Sy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.spg.R;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZViewHolder;

public class Sy extends Fragment {
protected MZBannerView mMZBanner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate (R.layout.activity_sy2,container,false);
        mMZBanner = (MZBannerView) view.findViewById(R.id.banner);

        // 设置数据
        mMZBanner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });

        public class BannerViewHolder implements MZViewHolder<Integer> {
            private ImageView mImageView;
            @Override
            public View createView(Context context) {
                // 返回页面布局
                View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
                mImageView = (ImageView) view.findViewById(R.id.banner_image);
                return view;
            }

            @Override
            public void onBind(Context context, int position, Integer data) {
                // 数据绑定
                mImageView.setImageResource(data);
            }
        }
    }
}
