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
public interface RegisterContract {

    interface IModel extends IBaseModel {
        void getRegisterData(String nickName, String email, String pwd, String code, RegisterDataCallBack loginDataCallBack);

        void getSendOutEmailCodeData(String email, RegisterDataCallBack loginDataCallBack);

        interface RegisterDataCallBack {
            void success(LoginEntity loginEntity);

            void failure(Throwable throwable);
        }


    }

    interface IView extends IBaseView {
        void success(LoginEntity loginEntity);

        void failure(Throwable throwable);
    }

    interface IPresenter {
        void getRegisterData(String nickName, String email, String pwd, String code);

        void getSendOutEmailCodeData(String email);
    }

}
