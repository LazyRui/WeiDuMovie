package com.bw.movie;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.base_mvp.BasePresenter;
import com.bw.movie.view.fragment.mainactivity_fragment.AccountFragmnet;
import com.bw.movie.view.fragment.mainactivity_fragment.CinemaFragment;
import com.bw.movie.view.fragment.mainactivity_fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.iv_cinema)
    ImageView ivCinema;
    @BindView(R.id.tv_cinema)
    TextView tvCinema;
    @BindView(R.id.ll_cinema)
    LinearLayout llCinema;
    @BindView(R.id.iv_account)
    ImageView ivAccount;
    @BindView(R.id.tv_account)
    TextView tvAccount;
    @BindView(R.id.ll_account)
    LinearLayout llAccount;
    private List<Fragment> mFragments;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mFragments = new ArrayList<>();

        mFragments.add(new HomeFragment());
        mFragments.add(new CinemaFragment());
        mFragments.add(new AccountFragmnet());


        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:

                        llHome.setBackgroundResource(R.drawable.home_shape);
                        tvHome.setVisibility(View.VISIBLE);

                        ivCinema.setImageResource(R.drawable.cinema_normal);
                        llCinema.setBackgroundResource(0);
                        tvCinema.setVisibility(View.GONE);

                        ivAccount.setImageResource(R.drawable.account_normal);
                        llAccount.setBackgroundResource(0);
                        tvAccount.setVisibility(View.GONE);

                        break;
                    case 1:
                        llHome.setBackgroundResource(0);
                        tvHome.setVisibility(View.GONE);

                        ivCinema.setImageResource(R.drawable.cinema_selected);
                        llCinema.setBackgroundResource(R.drawable.home_shape);
                        tvCinema.setVisibility(View.VISIBLE);

                        ivAccount.setImageResource(R.drawable.account_normal);
                        llAccount.setBackgroundResource(0);
                        tvAccount.setVisibility(View.GONE);

                        break;
                    case 2:

                        llHome.setBackgroundResource(0);
                        tvHome.setVisibility(View.GONE);

                        ivCinema.setImageResource(R.drawable.cinema_normal);
                        llCinema.setBackgroundResource(0);
                        tvCinema.setVisibility(View.GONE);

                        ivAccount.setImageResource(R.drawable.account_selected);
                        llAccount.setBackgroundResource(R.drawable.home_shape);
                        tvAccount.setVisibility(View.VISIBLE);

                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected BasePresenter initPrenseter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.ll_home, R.id.ll_cinema, R.id.ll_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                vp.setCurrentItem(0);
                break;
            case R.id.ll_cinema:
                vp.setCurrentItem(1);
                break;
            case R.id.ll_account:
                vp.setCurrentItem(2);
                break;
        }
    }
}

