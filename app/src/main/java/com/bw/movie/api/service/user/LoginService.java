package com.bw.movie.api.service.user;

import com.bw.movie.entity.user.LoginEntity;
import com.bw.movie.api.Api;

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
public interface LoginService {

    @POST(Api.LOGIN_URL)
    @FormUrlEncoded
    Observable<LoginEntity> getLoginData(@Field("email") String email, @Field("pwd") String pwd);
}
