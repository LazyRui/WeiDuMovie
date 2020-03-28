package com.bw.movie.view.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.MainActivity;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.user.LoginContract;
import com.bw.movie.entity.user.LoginEntity;
import com.bw.movie.presenter.user.LoginPresenter;
import com.bw.movie.utils.EncryptUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.IView {

    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_pwd)
    EditText etPassword;
    @BindView(R.id.but_login)
    Button butLogin;
    @BindView(R.id.but_go_register)
    TextView butGoRegister;
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.but_update_pwd)
    Button butUpdatePwd;


    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
        //WRuiTao@1314520.
        //隐藏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //退出
        ivFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //修改密码
        butUpdatePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(LoginActivity.this,));
            }
        });
        //密码的显示隐藏

      /*  ivHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransformationMethod transformationMethod = etPassword.getTransformationMethod();
                if (transformationMethod == HideReturnsTransformationMethod.getInstance()) {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }

                Editable text = etPassword.getText();
                if (text != null) {
                    Selection.setSelection(text, text.length());
                }
            }
        });*/
    }

    @Override
    protected LoginPresenter initPrenseter() {
        return new LoginPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.but_login)
    public void butLogin(View view) {
        String email = etEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            return;
        }
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            return;
        }

        mPresenter.getLoginData(email, EncryptUtil.encrypt(password));

        Log.e("xxx", "=================" + EncryptUtil.encrypt(password));

    }

    @Override
    public void success(LoginEntity loginEntity) {
        if (loginEntity != null) {
            String message = loginEntity.getMessage();
            if (message.equals("1001")) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

                EventBus.getDefault().postSticky(loginEntity);

                finish();

            }
        }
    }

    @Override
    public void failure(Throwable throwable) {

    }


    @OnClick(R.id.but_go_register)
    public void onViewClicked() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

}
