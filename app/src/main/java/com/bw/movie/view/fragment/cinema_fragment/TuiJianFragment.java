package com.bw.movie.view.fragment.cinema_fragment;

import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.yingyuan_adapter.RecommendCinemaAdapter;
import com.bw.movie.api.service.ApiService;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.base_mvp.BasePresenter;
import com.bw.movie.entity.movie.ReleaseMovieEntity;
import com.bw.movie.entity.yingyuan.RecommendEntity;
import com.bw.movie.utils.RretrofitUtils;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: TuiJianMovie
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/4/1 19:01
 */
public class TuiJianFragment extends BaseFragment {
    @BindView(R.id.rv_recommendCinema)
    RecyclerView rvRecommendCinema;

    @Override
    protected int layoutId() {
        return R.layout.fragment_tuijian;
    }

    @Override
    protected void initData() {



    }

    @Override
    protected void initView(View view) {
        rvRecommendCinema.setLayoutManager(new LinearLayoutManager(getActivity()));

        loadData();

    }


    @Override
    protected BasePresenter initPresenter() {
        return null;
    }



    private void loadData() {
        RretrofitUtils.getInstance().createService(ApiService.class)
                .getRecommendCinemas(0, 0, 1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RecommendEntity>() {
                    @Override
                    public void accept(RecommendEntity recommendEntity) throws Exception {
                        if (recommendEntity != null) {
                            //Toast.makeText(getActivity(), ""+recommendEntity.getMessage(), Toast.LENGTH_SHORT).show();

                            RecommendCinemaAdapter recommendCinemaAdapter = new RecommendCinemaAdapter(getContext(), recommendEntity.getResult());
                            rvRecommendCinema.setAdapter(recommendCinemaAdapter);

                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
