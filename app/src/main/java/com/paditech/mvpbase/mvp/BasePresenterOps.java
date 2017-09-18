package com.paditech.mvpbase.mvp;

/**
 * This interface will contain BasePresenter operation with access permitted to View
 */
public interface BasePresenterOps {
    void onCreate();
    void onDestroy();
    void onRelease();
}
