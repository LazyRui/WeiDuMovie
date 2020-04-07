package com.bw.movie.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.user.RegisterContract;
import com.bw.movie.entity.user.LoginEntity;
import com.bw.movie.presenter.user.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.IView {


    @BindView(R.id.et_nick_name)
    EditText etNickName;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_email_code)
    EditText etEmailCode;
    @BindView(R.id.but_cik)
    Button btuCik;
    @BindView(R.id.et_pwd)
    EditText etPassword;
    @BindView(R.id.but_register)
    Button butRegister;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_to_login)
    TextView tvToLogin;

    private int tag = 1;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //隐藏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        btuCik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = 1;

                mPresenter.getSendOutEmailCodeData(etEmail.getText().toString());

            }
        });

        butRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = 2;
                if (TextUtils.isEmpty(etEmailCode.getText().toString())) {

                    mPresenter.getRegisterData(etNickName.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString(), etEmailCode.getText().toString());
                }
            }
        });


    }

    @Override
    protected RegisterPresenter initPrenseter() {
        return new RegisterPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_register;
    }


    @Override
    public void success(LoginEntity loginEntity) {
        if (loginEntity != null) {
            if (tag == 1) {
                Toast.makeText(this, loginEntity.getMessage(), Toast.LENGTH_SHORT).show();

            }

            if (tag == 2) {


                if (loginEntity.getStatus().equals("0000")) {

                    Toast.makeText(this, loginEntity.getMessage(), Toast.LENGTH_SHORT).show();

                    finish();
                } else {

                    Toast.makeText(this, loginEntity.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void failure(Throwable throwable) {

    }



    @OnClick({R.id.iv_back, R.id.tv_to_login})
    public void onViewClicked(View view) {


        finish();
        /*switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.tv_to_login:
                break;
        }*/
    }
}
