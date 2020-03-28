package com.bw.movie.api.service.user;

import com.bw.movie.api.Api;
import com.bw.movie.entity.user.LoginEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * ProjectName: MyTV
 * PackageName: com.bw.movie.api.service
 * ClassName:   LoginService
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/26 20:37
 */
public interface RegisterService {

    @POST(Api.REGISTER_URL)
    @FormUrlEncoded
    Observable<LoginEntity> getRegisterData(@Field("nickName") String nickName, @Field("email") String email, @Field("pwd") String pwd, @Field("code") String code);

    @POST(Api.SEND_OUT_EMAIL_CODE_URL)
    @FormUrlEncoded
    Observable<LoginEntity> getsendOutEmailCodeData(@Field("email") String email);
}
