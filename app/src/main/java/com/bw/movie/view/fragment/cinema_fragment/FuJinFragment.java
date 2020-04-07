package com.bw.movie.view.fragment.cinema_fragment;

import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.yingyuan_adapter.FindNearbyCinemasAdapter;
import com.bw.movie.api.service.ApiService;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.base_mvp.BasePresenter;
import com.bw.movie.entity.yingyuan.FindNearbyCinemasEntity;
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
public class FuJinFragment extends BaseFragment {
    @BindView(R.id.rv_recommendCinema)
    RecyclerView rvNearCinemas;

    @Override
    protected int layoutId() {
        return R.layout.fragment_tuijian;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

        rvNearCinemas.setLayoutManager(new LinearLayoutManager(getActivity()));
        loadData();

    }

    private void loadData() {
        RretrofitUtils.getInstance().createService(ApiService.class)
                .getFindNearbyCinemasEntity(0, 0, "116.30551391385724", "40.04571807462411", 1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FindNearbyCinemasEntity>() {
                    @Override
                    public void accept(FindNearbyCinemasEntity findNearbyCinemasEntity) throws Exception {
                        if (findNearbyCinemasEntity != null) {
                            //Toast.makeText(getActivity(), ""+findNearbyCinemasEntity.getMessage(), Toast.LENGTH_SHORT).show();
                            FindNearbyCinemasAdapter findNearbyCinemasAdapter = new FindNearbyCinemasAdapter(getContext(), findNearbyCinemasEntity.getResult());
                            rvNearCinemas.setAdapter(findNearbyCinemasAdapter);

                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
