package com.bw.movie.base.base_mvp;

import java.lang.ref.WeakReference;

/**
 * ProjectName: MyTV
 * PackageName: com.bw.movie.base
 * ClassName:   IBasePresenter
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/26 20:18
 */
public abstract class BasePresenter<M extends IBaseModel, V extends IBaseView> {
    protected M mModel;
    private WeakReference<V> mWeakReference;

    /**
     *
     */
    public BasePresenter() {
        mModel = initModel();
    }

    protected abstract M initModel();

    /**
     * @param v
     */
    public void attach(V v) {
        mWeakReference = new WeakReference<>(v);
    }

    /**
     *
     */
    public void detach() {
        if (mWeakReference != null) {
            mWeakReference.clear();
            mWeakReference = null;
        }
    }

    /**
     *
     * @return
     */
    public V getView() {
        if (mWeakReference != null) {
            return mWeakReference.get();
        }
        return null;
    }
}
