package com.nhapcs.base_padi.common.dialog;

import android.view.View;
import android.widget.TextView;

import com.nhapcs.base_padi.R;
import com.nhapcs.base_padi.common.base.BaseDialog;
import com.nhapcs.base_padi.common.utils.StringUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Nha Nha on 6/28/2017.
 */

public class MessageDialog extends BaseDialog {
    TextView mTvMessage;
    TextView mBtnOk;
    TextView mBtnCancel;
    View mLine;

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
        mTvMessage = view.findViewById(R.id.tv_message);
        mBtnOk = view.findViewById(R.id.btn_ok);
        mBtnCancel = view.findViewById(R.id.btn_cancel);
        mLine = view.findViewById(R.id.line);
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mOnPositiveClickListener != null) mOnPositiveClickListener.onPositiveClick();
            }
        });
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mOnNegativeClickListener != null) mOnNegativeClickListener.onNegativeClick();
            }
        });
        if (!StringUtil.isEmpty(message)) {
            mTvMessage.setText(message);
        }
        if (!StringUtil.isEmpty(okText)) {
            mBtnOk.setText(okText);
        }

        if (!StringUtil.isEmpty(cancelText)) {
            mLine.setVisibility(View.VISIBLE);
            mBtnCancel.setVisibility(View.VISIBLE);
            mBtnCancel.setText(cancelText);
        } else {
            mBtnCancel.setVisibility(View.GONE);
            mLine.setVisibility(View.GONE);
        }
    }

}
