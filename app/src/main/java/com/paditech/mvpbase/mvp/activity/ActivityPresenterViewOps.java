package com.paditech.mvpbase.mvp.activity;

import com.paditech.mvpbase.mvp.BasePresenterOps;

/**
 * Created by Nha Nha on 6/27/2017.
 */

public interface ActivityPresenterViewOps extends BasePresenterOps {
    void onPause();
    void onResume();
}
