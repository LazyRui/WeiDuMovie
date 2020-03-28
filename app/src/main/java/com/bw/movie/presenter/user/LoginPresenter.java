package com.bw.movie.presenter.user;

import com.bw.movie.base.base_mvp.BasePresenter;
import com.bw.movie.contract.user.LoginContract;
import com.bw.movie.entity.user.LoginEntity;
import com.bw.movie.model.user.LoginModel;

/**
 * ProjectName: MyTV
 * PackageName: com.bw.movie.presenter.user
 * ClassName:   LoginPresenter
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/26 20:46
 */
public class LoginPresenter extends BasePresenter<LoginModel, LoginContract.IView> implements LoginContract.IPresenter {
    @Override
    protected LoginModel initModel() {
        return new LoginModel();
    }

    @Override
    public void getLoginData(String email, String pwd) {
        mModel.getLoginData(email, pwd, new LoginContract.IModel.LoginDataCallBack() {
            @Override
            public void success(LoginEntity loginEntity) {
                getView().success(loginEntity);
            }

            @Override
            public void failure(Throwable throwable) {
                getView().failure(throwable);
            }
        });
    }
}
