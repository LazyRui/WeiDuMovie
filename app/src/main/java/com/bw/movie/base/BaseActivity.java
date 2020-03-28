package com.bw.movie.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.movie.base.base_mvp.BasePresenter;
import com.bw.movie.base.base_mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ProjectName: MyTV
 * PackageName: com.bw.movie.base
 * ClassName:   BaseActivity
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/26 20:31
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    protected P mPresenter;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        //
        setContentView(layoutId());
        //
        bind = ButterKnife.bind(this);
        //
        mPresenter = initPrenseter();
        //
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        //
        initView();
        //
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPrenseter();

    protected abstract int layoutId();

    /**
     *
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //
        if (bind != null) {
            bind.unbind();
        }
        //
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }
}
