package com.paditech.mvpbase.mvp.activity;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.paditech.mvpbase.base.BaseDialog;
import com.paditech.mvpbase.mvp.BaseViewOps;

/**
 * This class contain all common behavior for Activity in this App
 */
public interface ActivityViewOps extends BaseViewOps {
    /**
     * @return context of View
     */
    Context getActivityContext();

    /**
     * @return context of Application
     */
    Context getApplicationContext();

    void showProgressbar();

    void hideProgressbar();

    void showAlertDialog(String msg);

    void showAlertDialog(String msg, BaseDialog.OnPositiveClickListener cancelListener);

    void showConfirmDialog(String msg, BaseDialog.OnPositiveClickListener positiveListener, BaseDialog.OnNegativeClickListener negativeListener);

    void showConfirmDialog(String msg, String positive, String negative, BaseDialog.OnPositiveClickListener positiveListener, BaseDialog.OnNegativeClickListener negativeListener);

    void showToast(String msg);

    void replaceFragment(Fragment fragment, int layout, boolean addBackStack);

    void replaceFragment(Fragment fragment, boolean addBackStack);

    void replaceFragment(FragmentManager manager, Fragment fragment, int layout, boolean addBackStack);

    void replaceFragment(FragmentManager manager, Fragment fragment, boolean addBackStack, int enter, int exit, int popEnter, int popExit);

    void replaceFragment(FragmentManager manager, Fragment fragment, int res, boolean addBackStack, int enter, int exit, int popEnter, int popExit);

    void replaceFragment(FragmentManager manager, Fragment fragment, int res, boolean addBackStack, View shareElement, String transitionName);
}

