package com.nhapcs.base_padi.common.mvvm;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.nhapcs.base_padi.common.base.BaseApplication;
import com.nhapcs.base_padi.common.base.BaseDialog;

/**
 * Created by nhapcs on 6/9/18.
 */
public interface Navigator {
    void onLoading();
    void onLoadDone();
    void showLoading();
    void hideLoading();
    void showAlertDialog(String msg);
    void showAlertDialog(boolean hasTitle, String msg);

    void showAlertDialog(boolean hasTitle, String msg, BaseDialog.OnPositiveClickListener cancelListener);

    void showAlertDialog(String msg, BaseDialog.OnPositiveClickListener cancelListener);

    void showConfirmDialog(boolean hasTitle, String msg, BaseDialog.OnPositiveClickListener positiveListener, BaseDialog.OnNegativeClickListener negativeListener);

    void showConfirmDialog(String msg, BaseDialog.OnPositiveClickListener positiveListener, BaseDialog.OnNegativeClickListener negativeListener);

    void showConfirmDialog(boolean hasTitle, String msg, String positive, String negative, BaseDialog.OnPositiveClickListener positiveListener, BaseDialog.OnNegativeClickListener negativeListener);

    void showToast(String msg);

    void replaceFragment(Fragment fragment, int layout, boolean addBackStack);

    void replaceFragment(Fragment fragment, boolean addBackStack);

    void replaceFragment(FragmentManager manager, Fragment fragment, int layout, boolean addBackStack);

    void replaceFragment(FragmentManager manager, Fragment fragment, boolean addBackStack, int enter, int exit, int popEnter, int popExit);

    void replaceFragment(FragmentManager manager, Fragment fragment, int res, boolean addBackStack, int enter, int exit, int popEnter, int popExit);

    void replaceFragment(FragmentManager manager, Fragment fragment, int res, boolean addBackStack, View shareElement, String transitionName);

    void popBackStack(FragmentManager manager);

    void popBackStack();

    void popBackStack(FragmentManager manager, String tag);

    void popBackStack(String tag);

    void clearBackStack();

    Context getMainContext();

    MVVMActivity getBaseActivity();

    BaseApplication getBaseApplication();

    void notifyViewModelDataChange();

}
