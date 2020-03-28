package com.bw.movie.api;

/**
 * ProjectName: MyTV
 * PackageName: com.bw.movie.api
 * ClassName:   Api
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/26 20:28
 */
public class Api {
    public static final String BASE_URL = "http://mobile.bwstudent.com/";
    public static final String LOGIN_URL = "movieApi/user/v2/login";
    public static final String REGISTER_URL = "movieApi/user/v2/register";
    public static final String SEND_OUT_EMAIL_CODE_URL = "movieApi/user/v2/sendOutEmailCode";


    //首页xbanner
    public static final String BASE_XBANNER = "movieApi/tool/v2/banner";
    //正在上映
    public static final String BASE_SHOWING = "movieApi/movie/v2/findReleaseMovieList";
    //即将上映
    public static final String BASE_JJSHOW = "movieApi/movie/v2/findComingSoonMovieList";
    //re上映
    public static final String BASE_HOTSHOW = "movieApi/movie/v2/findHotMovieList";
    //推荐影院
    public static final String BASE_RECOMMEND = "movieApi/cinema/v1/findRecommendCinemas";
    //附近影院
    public static final String BASE_NEARMOVIE = "movieApi/cinema/v1/findRecommendCinemas";
    //查询电影详情
    public static final String BASE_MOVIEID = "movieApi/movie/v2/findMoviesDetail";
    //影院评价
    public static final String BASE_TALK_CINEMA = "movieApi/cinema/v1/verify/cinemaComment";
    //电影评价
    public static final String BASE_TALK_MOVIE = "movieApi/movie/v1/verify/movieComment";
    //模糊查询
    public static final String BASE_SOUSUO = "movieApi/movie/v2/findMovieByKeyword";
    //关注电影  get  uid sid movieid
    public static final String BASE_FOLLOW = "movieApi/movie/v1/verify/followMovie";
    //取消关注电影  get  uid sid movieid
    public static final String BASE_CANCELFOLLOW = "movieApi/movie/v1/verify/cancelFollowMovie";
    //预约 post uid sid movieid
    public static final String BASE_RESERVE = "movieApi/movie/v2/verify/reserve";
}
