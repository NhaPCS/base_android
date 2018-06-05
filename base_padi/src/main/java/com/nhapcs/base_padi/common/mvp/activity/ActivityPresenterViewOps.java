package com.nhapcs.base_padi.common.mvp.activity;


import com.nhapcs.base_padi.common.mvp.BasePresenterOps;

/**
 * Created by Nha Nha on 6/27/2017.
 */

public interface ActivityPresenterViewOps extends BasePresenterOps {
    void onPause();
    void onResume();
}
