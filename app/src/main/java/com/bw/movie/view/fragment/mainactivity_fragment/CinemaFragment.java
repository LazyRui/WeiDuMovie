package com.bw.movie.view.fragment.mainactivity_fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.base_mvp.BasePresenter;
import com.bw.movie.view.fragment.cinema_fragment.AddressFragment;
import com.bw.movie.view.fragment.cinema_fragment.FuJinFragment;
import com.bw.movie.view.fragment.cinema_fragment.TuiJianFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ClassName: CinemaFragment
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/3/23 17:49
 */
public class CinemaFragment extends BaseFragment {
    @BindView(R.id.iv_address)
    ImageView ivAddress;
    @BindView(R.id.iv_branch)
    ImageView ivBranch;
    @BindView(R.id.ta_tatatata)
    TabLayout taTatatata;
    @BindView(R.id.vp)
    ViewPager vp;

    private List<Fragment> mFragments = new ArrayList<>();
    private String[] a = {"推荐影院","附近影院","Address"};

    @Override
    protected int layoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        mFragments.add(new TuiJianFragment());
        mFragments.add(new FuJinFragment());
        mFragments.add(new AddressFragment());

        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return a[position];
            }
        });

        taTatatata.setupWithViewPager(vp);

/*
        taTatatata.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                
                if (position==0){

                    Toast.makeText(getContext(), "123", Toast.LENGTH_SHORT).show();
                    
                }
                

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
