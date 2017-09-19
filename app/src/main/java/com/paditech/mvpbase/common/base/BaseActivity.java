package com.paditech.mvpbase.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.paditech.mvpbase.R;
import com.paditech.mvpbase.common.dialog.LoadingDialog;

import butterknife.ButterKnife;

/**
 * Created by Nha Nha on 6/26/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        overridePendingTransition(R.anim.from_right, R.anim.to_left);
        ButterKnife.bind(this);
        mLoadingDialog = new LoadingDialog();
        initView();
    }

    protected abstract int getContentView();

    protected abstract void initView();

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.from_left, R.anim.to_right);
    }

    public void showLoadingDialog() {
        try {
            if (mLoadingDialog != null) {
                mLoadingDialog.dismiss();
                mLoadingDialog.show(getSupportFragmentManager(), mLoadingDialog.getClass().getSimpleName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void hideLoadingDialog() {
        try {
            if (mLoadingDialog != null) {
                mLoadingDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
