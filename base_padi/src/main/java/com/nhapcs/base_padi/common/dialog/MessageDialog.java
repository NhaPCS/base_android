package com.nhapcs.base_padi.common.dialog;

import android.view.View;

import com.nhapcs.base_padi.R;
import com.nhapcs.base_padi.common.base.BaseDialog;
import com.nhapcs.base_padi.common.utils.StringUtil;
import com.nhapcs.base_padi.databinding.DialogMessageBinding;


/**
 * Created by Nha Nha on 6/28/2017.
 */

public class MessageDialog extends BaseDialog<DialogMessageBinding> {

    private OnPositiveClickListener mOnPositiveClickListener;
    private OnNegativeClickListener mOnNegativeClickListener;
    private String message, okText, cancelText;
    private boolean hasTitle;


    public static MessageDialog newInstance(boolean hasTitle, String message) {
        MessageDialog messageDialog = new MessageDialog();
        messageDialog.message = message;
        messageDialog.hasTitle = hasTitle;
        return messageDialog;
    }

    public static MessageDialog newInstance(boolean hasTitle, String message, String ok) {
        MessageDialog messageDialog = new MessageDialog();
        messageDialog.message = message;
        messageDialog.okText = ok;
        messageDialog.hasTitle = hasTitle;
        return messageDialog;
    }

    public static MessageDialog newInstance(boolean hasTitle, String message, String ok, String cancelText) {
        MessageDialog messageDialog = new MessageDialog();
        messageDialog.message = message;
        messageDialog.okText = ok;
        messageDialog.cancelText = cancelText;
        messageDialog.hasTitle = hasTitle;
        return messageDialog;
    }

    public void setmOnPositiveClickListener(OnPositiveClickListener mOnPositiveClickListener) {
        this.mOnPositiveClickListener = mOnPositiveClickListener;
    }

    public void setmOnNegativeClickListener(OnNegativeClickListener mOnNegativeClickListener) {
        this.mOnNegativeClickListener = mOnNegativeClickListener;
    }

    @Override
    protected int getContentView() {
        return R.layout.dialog_message;
    }

    @Override
    protected void initView(View view) {
        getDataBinding().btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mOnPositiveClickListener != null) mOnPositiveClickListener.onPositiveClick();
            }
        });
        getDataBinding().btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mOnNegativeClickListener != null) mOnNegativeClickListener.onNegativeClick();
            }
        });
        if (!StringUtil.isEmpty(message)) {
            getDataBinding().tvMessage.setText(message);
        }
        if (!StringUtil.isEmpty(okText)) {
            getDataBinding().btnOk.setText(okText);
        }

        if (!StringUtil.isEmpty(cancelText)) {
            getDataBinding().line.setVisibility(View.VISIBLE);
            getDataBinding().btnCancel.setVisibility(View.VISIBLE);
            getDataBinding().btnCancel.setText(cancelText);
        } else {
            getDataBinding().btnCancel.setVisibility(View.GONE);
            getDataBinding().line.setVisibility(View.GONE);
        }
    }

}
