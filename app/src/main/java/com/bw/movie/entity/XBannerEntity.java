package com.bw.movie.entity;

import com.stx.xhb.androidx.entity.SimpleBannerInfo;

/**
 * ProjectName: MyTV
 * PackageName: com.bw.movie.entity
 * ClassName:   XBannerEntity
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/27 20:21
 */
public class XBannerEntity extends SimpleBannerInfo {
     private int souse;

    public int getSouse() {
        return souse;
    }

    public void setSouse(int souse) {
        this.souse = souse;
    }

    @Override
    public Object getXBannerUrl() {
        return null;
    }
}
