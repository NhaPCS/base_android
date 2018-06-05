package com.nhapcs.base_padi.common.dialog;

import android.view.View;

import com.nhapcs.base_padi.R;
import com.nhapcs.base_padi.common.base.BaseDialog;

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
