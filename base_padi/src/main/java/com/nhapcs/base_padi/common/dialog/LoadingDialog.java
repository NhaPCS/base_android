package com.nhapcs.base_padi.common.dialog;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.nhapcs.base_padi.R;
import com.nhapcs.base_padi.common.base.BaseDialog;
import com.nhapcs.base_padi.common.mvvm.view_model.BaseViewModel;

/**
 * Created by Nha Nha on 5/30/2017.
 */

public class LoadingDialog extends BaseDialog<ViewDataBinding, BaseViewModel> {
    @Override
    protected int getContentView() {
        return R.layout.dialog_loading;
    }

    @Override
    protected void initView(View view) {
        
    }

    @Override
    protected int getVariableId() {
        return 0;
    }

}
