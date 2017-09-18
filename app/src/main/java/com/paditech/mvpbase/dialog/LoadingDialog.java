package com.paditech.mvpbase.dialog;

import android.view.View;

import com.paditech.mvpbase.R;
import com.paditech.mvpbase.base.BaseDialog;

/**
 * Created by Nha Nha on 5/30/2017.
 */

public class LoadingDialog extends BaseDialog {
    @Override
    protected int getContentView() {
        return R.layout.dialog_loading;
    }

    @Override
    protected void initView(View view) {
        
    }

}
