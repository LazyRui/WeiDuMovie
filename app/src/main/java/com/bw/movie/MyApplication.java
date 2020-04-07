package com.bw.movie;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @ClassName: MyApplicition
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/4/7 14:48
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
