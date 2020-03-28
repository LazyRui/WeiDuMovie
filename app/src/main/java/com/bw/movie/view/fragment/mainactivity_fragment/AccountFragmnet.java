package com.bw.movie.view.fragment.mainactivity_fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.base_mvp.BasePresenter;
import com.bw.movie.entity.user.LoginEntity;
import com.bw.movie.view.activity.LoginActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * @ClassName: AccountFragmnet
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/3/23 17:50
 */
public class AccountFragmnet extends BaseFragment {
    @BindView(R.id.to_login)
    ImageView toLogin;
    @BindView(R.id.iv_image_account)
    ImageView ivImageAccount;
    @BindView(R.id.tv_name)
    TextView tvName;

    @Override
    protected int layoutId() {
        return R.layout.fragment_account;
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initView(View view) {
        EventBus.getDefault().register(this);
        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void loginData(LoginEntity loginEntity) {
        if (loginEntity != null) {
            Glide.with(getActivity()).load(loginEntity.getResult().getUserInfo().getHeadPic())
                    .circleCrop()
                    .into(ivImageAccount);
            tvName.setText(loginEntity.getResult().getUserInfo().getNickName());

        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);

    }
}
