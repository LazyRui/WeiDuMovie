package com.bw.movie.contract.user;

import com.bw.movie.base.base_mvp.IBaseModel;
import com.bw.movie.base.base_mvp.IBaseView;
import com.bw.movie.entity.user.LoginEntity;

/**
 * ProjectName: MyTV
 * PackageName: com.bw.movie.contract.user
 * ClassName:   LoginContract
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/26 20:26
 */
public interface LoginContract {

    interface IModel extends IBaseModel {
        void getLoginData(String email, String pwd, LoginDataCallBack loginDataCallBack);

        interface LoginDataCallBack {
            void success(LoginEntity loginEntity);

            void failure(Throwable throwable);
        }


    }

    interface IView extends IBaseView {
        void success(LoginEntity loginEntity);

        void failure(Throwable throwable);
    }

    interface IPresenter {
        void getLoginData(String email, String pwd);
    }

}
