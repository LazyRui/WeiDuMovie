package com.bw.movie.api.service;

import com.bw.movie.api.Api;
import com.bw.movie.entity.movie.BananerEntity;
import com.bw.movie.entity.movie.BranchMovieEntity;
import com.bw.movie.entity.movie.ComingSoonMovieEntity;
import com.bw.movie.entity.movie.HotMovie;
import com.bw.movie.entity.movie.ReleaseMovieEntity;
import com.bw.movie.entity.yingyuan.FindNearbyCinemasEntity;
import com.bw.movie.entity.yingyuan.RecommendEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * ProjectName: MyTV
 * PackageName: com.bw.movie.api.service
 * ClassName:   ApiService
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/3/20 10:37
 */
public interface ApiService {

    @GET(Api.BASE_XBANNER)
    Observable<BananerEntity> getBannerData();

    @GET(Api.BASE_SHOWING)
    Observable<ReleaseMovieEntity> getReleaseMovieData(@Query("page") int page, @Query("count") int count);

    @GET(Api.BASE_JJSHOW)
    Observable<ComingSoonMovieEntity> getComingSoonMovieData(@Query("page") int page, @Query("count") int count);

    @GET(Api.BASE_HOTSHOW)
    Observable<HotMovie> getHotMovieData(@Query("page") int page, @Query("count") int count);

    @GET(Api.BASE_SOUSUO)
    Observable<BranchMovieEntity> getBranchData(@Query("keyword") String keyword, @Query("page") int page, @Query("count") int count);

    @GET(Api.BASE_RECOMMEND)
    Observable<RecommendEntity> getRecommendCinemas(@Header("userId") int userId, @Header("sessionId") int sessionId, @Query("page") int page, @Query("count") int count);

    @GET(Api.BASE_RECOMMEND)
    Observable<FindNearbyCinemasEntity> getFindNearbyCinemasEntity(@Header("userId") int userId, @Header("sessionId") int sessionId,
                                                                   @Query("longitude") String longitude, @Query("latitude") String latitude,
                                                                   @Query("page") int page, @Query("count") int count);


}
