package com.nhapcs.base_padi.common.base;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


/**
 * Created by Nha Nha on 11/3/2016.
 */

public abstract class BaseDialog<D extends ViewDataBinding> extends AppCompatDialogFragment {

    private boolean isShow;
    private D dataBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        } catch (Exception e) {
            e.printStackTrace();
        }
        dataBinding = DataBindingUtil.inflate(inflater, getContentView(), container, false);
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            initView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public D getDataBinding() {
        return dataBinding;
    }


    @Override
    public void show(FragmentManager manager, String tag) {
        if (isAdded() || isShow) return;
        try {
            isShow = true;
            super.show(manager, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        if (isAdded() || isShow) return -1;
        try {
            isShow = true;
            return super.show(transaction, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    protected abstract int getContentView();

    protected abstract void initView(View view);

    public interface OnPositiveClickListener {
        void onPositiveClick();
    }

    public interface OnNegativeClickListener {
        void onNegativeClick();
    }

    @Override
    public void dismiss() {
        isShow = false;
        super.dismissAllowingStateLoss();
    }

    @Override
    public void dismissAllowingStateLoss() {
        isShow = false;
        super.dismissAllowingStateLoss();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        isShow = false;
        super.onDismiss(dialog);
    }

    @Override
    public void onDestroy() {
        isShow = false;
        super.onDestroy();
    }
}
