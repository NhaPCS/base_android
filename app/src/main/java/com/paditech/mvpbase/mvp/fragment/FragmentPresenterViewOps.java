package com.paditech.mvpbase.mvp.fragment;


import com.paditech.mvpbase.mvp.BasePresenterOps;

/**
 * This class define base common behavior for presenter of Activity
 * <p/>
 * NOTE:
 * All behavior must be define on presenterImpl class that extended from this class
 */
public interface FragmentPresenterViewOps extends BasePresenterOps {
    void onPause();

    void onResume();

    void onResumeVisible();
}
