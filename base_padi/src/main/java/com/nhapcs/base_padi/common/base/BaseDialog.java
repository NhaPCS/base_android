package com.nhapcs.base_padi.common.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.nhapcs.base_padi.common.mvvm.view_model.BaseViewModel;


/**
 * Created by Nha Nha on 11/3/2016.
 */

public abstract class BaseDialog<D extends ViewDataBinding, V extends BaseViewModel> extends AppCompatDialogFragment {

    private D dataBinding;
    private V viewModel;

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
        dataBinding.setVariable(getVariableId(), viewModel);
        dataBinding.executePendingBindings();
        View view = dataBinding.getRoot();
        initView(view);
        return view;
    }


    public D getDataBinding() {
        return dataBinding;
    }

    public V getViewModel() {
        return viewModel;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            super.show(manager, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        try {
            return super.show(transaction, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    protected abstract int getContentView();

    protected abstract void initView(View view);

    protected abstract int getVariableId();

    public interface OnPositiveClickListener {
        void onPositiveClick();
    }

    public interface OnNegativeClickListener {
        void onNegativeClick();
    }

    @Override
    public void dismiss() {
        super.dismissAllowingStateLoss();
    }
}
