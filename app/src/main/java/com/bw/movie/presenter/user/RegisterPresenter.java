package com.bw.movie.presenter.user;

import com.bw.movie.base.base_mvp.BasePresenter;
import com.bw.movie.contract.user.LoginContract;
import com.bw.movie.contract.user.RegisterContract;
import com.bw.movie.entity.user.LoginEntity;
import com.bw.movie.model.user.RegisterModel;

/**
 * ProjectName: MyTV
 * PackageName: com.bw.movie.presenter.user
 * ClassName:   LoginPresenter
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/26 20:46
 */
public class RegisterPresenter extends BasePresenter<RegisterModel, RegisterContract.IView> implements RegisterContract.IPresenter {
    @Override
    protected RegisterModel initModel() {
        return new RegisterModel();
    }

    @Override
    public void getRegisterData(String nickName, String email, String pwd, String code) {
        mModel.getRegisterData(nickName, email, pwd, code, new RegisterContract.IModel.RegisterDataCallBack() {
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

    @Override
    public void getSendOutEmailCodeData(String email) {
        mModel.getSendOutEmailCodeData(email, new RegisterContract.IModel.RegisterDataCallBack() {
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
