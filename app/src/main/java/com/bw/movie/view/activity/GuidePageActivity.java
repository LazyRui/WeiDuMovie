package com.bw.movie.view.activity;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.bw.movie.MainActivity;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.base_mvp.BasePresenter;
import com.bw.movie.entity.XBannerEntity;
import com.stx.xhb.androidx.XBanner;

import java.util.ArrayList;

import butterknife.BindView;

public class GuidePageActivity extends BaseActivity {


    @BindView(R.id.xx_banner)
    XBanner xxBanner;
    private ArrayList<XBannerEntity> imageList;
    private SharedPreferences.Editor edit;
    private SharedPreferences guide_page;


    @Override
    protected void initData() {

        imageList = new ArrayList<>();

        XBannerEntity xBannerEntity = new XBannerEntity();
        XBannerEntity xBannerEntity1 = new XBannerEntity();
        XBannerEntity xBannerEntity2 = new XBannerEntity();
        XBannerEntity xBannerEntity3 = new XBannerEntity();

        xBannerEntity.setSouse(R.drawable.guide_one);
        xBannerEntity1.setSouse(R.drawable.guide_two);
        xBannerEntity2.setSouse(R.drawable.guide_three);
        xBannerEntity3.setSouse(R.drawable.guide_four);

        imageList.add(xBannerEntity);
        imageList.add(xBannerEntity1);
        imageList.add(xBannerEntity2);
        imageList.add(xBannerEntity3);

        if (guide_page.getBoolean("guide", false)) {
            startActivity(new Intent(GuidePageActivity.this, MainActivity.class));
            finish();
        } else {


            xxBanner.setBannerData(imageList);

            xxBanner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    XBannerEntity xBannerEntity4 = imageList.get(position);
                    ImageView imageView = (ImageView) view;
                    imageView.setImageResource(xBannerEntity4.getSouse());


                }
            });
            xxBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    // Log.e("xxx",position+"==============");
                    if (position == imageList.size() - 1) {
                        if (edit != null) {
                            edit.putBoolean("guide", true);
                            edit.commit();
                        }
                        startActivity(new Intent(GuidePageActivity.this, MainActivity.class));
                        finish();
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

        }

    }

    @Override
    protected void initView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        guide_page = getSharedPreferences("guide_page", Service.MODE_PRIVATE);

        edit = guide_page.edit();


    }

    @Override
    protected BasePresenter initPrenseter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_guide_page;
    }


}
