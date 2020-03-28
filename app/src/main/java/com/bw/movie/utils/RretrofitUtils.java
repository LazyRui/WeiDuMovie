package com.bw.movie.utils;

import com.bw.movie.api.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ProjectName: WuRuitao20200224
 * PackageName: com.bawei.wuruitao.utils
 * ClassName:   RretrofitUtils
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/2/24_13:15
 */
public class RretrofitUtils {
    private static RretrofitUtils mRetrofitUtils;
    private final Retrofit retrofit;

    private RretrofitUtils() {

      /*  HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
*/
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())        //	设置日志拦截器，打印常见日志信息。
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RretrofitUtils getInstance() {
        if (mRetrofitUtils == null) {
            synchronized (RretrofitUtils.class) {
                if (mRetrofitUtils == null) {
                    mRetrofitUtils = new RretrofitUtils();
                }
            }
        }
        return mRetrofitUtils;
    }

    public <T> T createService(Class<T> tClass) {
        return retrofit.create(tClass);
    }
}
