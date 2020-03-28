package com.bw.movie.view.activity;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.base_mvp.BasePresenter;
/**
 * ProjectName: MyTV
 * PackageName: com.bw.movie
 * ClassName:   StartPageActivity
 * Description: 启动页
 * Author: LazyRui
 * CreateDate: 2020/2/26 20:28
 */
public class StartPageActivity extends BaseActivity {


    Handler handler = new Handler(){
        int time = 0;
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){

                if (time==3){
                    startActivity(new Intent(StartPageActivity.this,GuidePageActivity.class));
                    finish();
                }else {

                    time++;
                    handler.sendEmptyMessageDelayed(0,1000);
                }


            }

        }
    };


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //状态栏透明化
        /*getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);*/

        //隐藏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        handler.sendEmptyMessageDelayed(0,1000);

    }

    @Override
    protected BasePresenter initPrenseter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_start_page;
    }
}
