package com.nhapcs.base_padi.common.dialog;

import android.content.DialogInterface;
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

import com.nhapcs.base_padi.R;

/**
 * Created by Nha Nha on 5/30/2017.
 */

public class LoadingDialog extends AppCompatDialogFragment {
    private boolean isShow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        } catch (Exception e) {
            e.printStackTrace();
        }
        return inflater.inflate(R.layout.dialog_loading, container, false);
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
