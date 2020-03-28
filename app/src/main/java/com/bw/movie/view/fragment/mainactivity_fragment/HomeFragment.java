package com.bw.movie.view.fragment.mainactivity_fragment;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;
import com.bw.movie.adapter.dianying_adapter.ComingSoonMovieAdapter;
import com.bw.movie.adapter.dianying_adapter.HotMovieAdapter;
import com.bw.movie.adapter.dianying_adapter.ReleaseMovieAdapter;
import com.bw.movie.api.service.ApiService;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.base_mvp.BasePresenter;
import com.bw.movie.entity.movie.BananerEntity;
import com.bw.movie.entity.movie.ComingSoonMovieEntity;
import com.bw.movie.entity.movie.HotMovie;
import com.bw.movie.entity.movie.ReleaseMovieEntity;
import com.bw.movie.utils.RretrofitUtils;
import com.stx.xhb.androidx.XBanner;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: HomeFragment
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/3/23 17:48
 */
public class HomeFragment extends BaseFragment {
    @BindView(R.id.home_banner)
    XBanner homeBanner;
    @BindView(R.id.tv_h_a)
    TextView tvHA;
    @BindView(R.id.tv_h_b)
    TextView tvHB;
    @BindView(R.id.rv_release_movie)
    RecyclerView rvReleaseMovie;
    @BindView(R.id.rv_ComingSoon_movie)
    RecyclerView rvComingSoonMovie;
    @BindView(R.id.rv_hot_movie)
    RecyclerView rvHotMovie;


    @BindView(R.id.iv_image_url)
    ImageView ivImageUrl;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_score)
    TextView tvScore;

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;

    }

    @Override
    protected void initData() {
        /**
         * xbanner数据
         */
        xbannerData();

        /**
         * 正在热映
         */
        releaseMovieList();

        /**
         * 即将上映
         */
        comingSoonMovieList();

        /**
         * 热门电影数据
         */
        hotMovieList();
    }


    @Override
    protected void initView(View view) {
        rvReleaseMovie.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        rvComingSoonMovie.setLayoutManager(new LinearLayoutManager(getContext()));


    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    /**
     * xbanner数据
     */
    private void xbannerData() {
        RretrofitUtils.getInstance().createService(ApiService.class)
                .getBannerData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BananerEntity>() {
                    @SuppressLint("CheckResult")
                    @Override
                    public void accept(BananerEntity bananerEntity) throws Exception {
                        if (bananerEntity != null) {

                            tvHB.setText("/" + bananerEntity.getResult().size());

                            homeBanner.setBannerData(bananerEntity.getResult());

                            homeBanner.loadImage(new XBanner.XBannerAdapter() {
                                @Override
                                public void loadBanner(XBanner banner, Object model, View view, int position) {
                                    if (position == 0) {
                                        tvHA.setText("5");
                                    } else {
                                        tvHA.setText("" + position);
                                    }
                                    ImageView imageView = (ImageView) view;
                                    String imageUrl = bananerEntity.getResult().get(position).getImageUrl();
                                    Glide.with(getContext()).load(imageUrl).into(imageView);

                                }
                            });

                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    /**
     * 正在热映
     */
    private void releaseMovieList() {
        RretrofitUtils.getInstance().createService(ApiService.class)
                .getReleaseMovieData(1, 6)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ReleaseMovieEntity>() {
                    @Override
                    public void accept(ReleaseMovieEntity releaseMovieEntity) throws Exception {
                        if (releaseMovieEntity != null) {
                            // Toast.makeText(getContext(), releaseMovieEntity.getMessage(), Toast.LENGTH_SHORT).show();
                            ReleaseMovieAdapter releaseMovieAdapter = new ReleaseMovieAdapter(getContext(), releaseMovieEntity.getResult());
                            rvReleaseMovie.setAdapter(releaseMovieAdapter);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    /**
     * 即将上映
     */
    private void comingSoonMovieList() {
        RretrofitUtils.getInstance().createService(ApiService.class)
                .getComingSoonMovieData(1, 6)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ComingSoonMovieEntity>() {
                    @Override
                    public void accept(ComingSoonMovieEntity comingSoonMovieEntity) throws Exception {
                        if (comingSoonMovieEntity != null) {
                            ComingSoonMovieAdapter comingSoonMovieAdapter = new ComingSoonMovieAdapter(getContext(), comingSoonMovieEntity.getResult());
                            rvComingSoonMovie.setAdapter(comingSoonMovieAdapter);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    /**
     * 热门电影数据
     */
    private void hotMovieList() {
        RretrofitUtils.getInstance().createService(ApiService.class)
                .getHotMovieData(1, 6)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HotMovie>() {
                    @Override
                    public void accept(HotMovie hotMovie) throws Exception {
                        if (hotMovie != null) {



                            Glide.with(getContext()).load(hotMovie.getResult().get(0).getImageUrl())
                                    .apply(new RequestOptions().optionalTransform(new RoundedCorners(8)))
                                    .into(ivImageUrl);
                            tvName.setText(hotMovie.getResult().get(0).getName());
                            tvScore.setText(hotMovie.getResult().get(0).getScore()+"分");






                            rvHotMovie.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

                            HotMovieAdapter hotMovieAdapter = new HotMovieAdapter(getContext(), hotMovie.getResult());


                            rvHotMovie.setAdapter(hotMovieAdapter);


                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

}
