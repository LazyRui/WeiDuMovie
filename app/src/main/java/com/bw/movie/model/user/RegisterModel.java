package com.bw.movie.model.user;

import com.bw.movie.api.service.user.LoginService;
import com.bw.movie.api.service.user.RegisterService;
import com.bw.movie.contract.user.LoginContract;
import com.bw.movie.contract.user.RegisterContract;
import com.bw.movie.entity.user.LoginEntity;
import com.bw.movie.utils.RretrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * ProjectName: MyTV
 * PackageName: com.bw.movie.model.user
 * ClassName:   LoginModel
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/26 20:42
 */
public class RegisterModel implements RegisterContract.IModel {

    @Override
    public void getRegisterData(String nickName, String email, String pwd, String code, RegisterDataCallBack loginDataCallBack) {
        RretrofitUtils.getInstance().createService(RegisterService.class)
                .getRegisterData(nickName,email,pwd,code)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<LoginEntity>() {
                    @Override
                    public void accept(LoginEntity loginEntity) throws Exception {
                        if (loginDataCallBack != null) {
                            loginDataCallBack.success(loginEntity);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (loginDataCallBack != null) {
                            loginDataCallBack.failure(throwable);
                        }
                    }
                });
    }

    @Override
    public void getSendOutEmailCodeData(String email, RegisterDataCallBack loginDataCallBack) {
        RretrofitUtils.getInstance().createService(RegisterService.class)
                .getsendOutEmailCodeData(email)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<LoginEntity>() {
                    @Override
                    public void accept(LoginEntity loginEntity) throws Exception {
                        if (loginDataCallBack != null) {
                            loginDataCallBack.success(loginEntity);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (loginDataCallBack != null) {
                            loginDataCallBack.failure(throwable);
                        }
                    }
                });
    }

}
