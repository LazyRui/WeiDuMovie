package com.bw.movie.view.activity;

import android.os.Bundle;
import android.renderscript.Byte3;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.dianying_adapter.BranchMovieAdapter;
import com.bw.movie.api.service.ApiService;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.base_mvp.BasePresenter;
import com.bw.movie.entity.movie.BranchMovieEntity;
import com.bw.movie.utils.RretrofitUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class BranchActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.et_branch)
    EditText etBranch;
    @BindView(R.id.rv_branch)
    RecyclerView rvBranch;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        rvBranch.setLayoutManager(new LinearLayoutManager(this));
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        etBranch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String bran = etBranch.getText().toString();

                if (TextUtils.isEmpty(bran)) {

                } else {

                    RretrofitUtils.getInstance().createService(ApiService.class)
                            .getBranchData(bran, 1, 5)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<BranchMovieEntity>() {
                                @Override
                                public void accept(BranchMovieEntity branchMovieEntity) throws Exception {
                                    if (branchMovieEntity != null) {

                                        if (branchMovieEntity.getResult().size() > 0) {

                                            BranchMovieAdapter branchMovieAdapter = new BranchMovieAdapter(BranchActivity.this, branchMovieEntity.getResult());
                                            rvBranch.setAdapter(branchMovieAdapter);
                                        }else {
                                            Toast.makeText(BranchActivity.this, "暂无此电影……", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {

                                }
                            });
                }

            }
        });
    }

    @Override
    protected BasePresenter initPrenseter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_branch;
    }


}
