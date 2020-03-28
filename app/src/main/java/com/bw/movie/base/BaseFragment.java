package com.bw.movie.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.movie.base.base_mvp.BasePresenter;
import com.bw.movie.base.base_mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ProjectName: MyTV
 * PackageName: com.bw.movie.base
 * ClassName:   BaseFragment
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/26 20:34
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment  implements IBaseView {
    protected P mPresenter;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),layoutId(),null);
        bind = ButterKnife.bind(this, view);
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        initView(view);
        return view;
    }

    protected abstract int layoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract P initPresenter();


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }

        if (mPresenter != null) {
            mPresenter.detach();
        }
    }
}
