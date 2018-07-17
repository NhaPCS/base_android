package com.nhapcs.base_padi.common.mvvm;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhapcs.base_padi.common.base.BaseApplication;
import com.nhapcs.base_padi.common.base.BaseDialog;
import com.nhapcs.base_padi.common.mvvm.view_model.BaseViewModel;

import java.lang.ref.WeakReference;

/**
 * Created by nhapcs on 6/9/18.
 */
public abstract class MVVMFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment implements Navigator {

    protected T dataBinding;
    protected V viewModel;
    private WeakReference<Activity> mWeakRef;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mWeakRef = new WeakReference<Activity>((Activity) context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setInjection();
        super.onCreate(savedInstanceState);
        viewModel = getViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, getContentView(), container, false);
        return dataBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataBinding.setVariable(getVariableId(), viewModel);
        dataBinding.executePendingBindings();
        if (viewModel != null) viewModel.setNavigator(this);
        try {
            initView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Activity getActivityReference() {
        return mWeakRef != null ? mWeakRef.get() : null;
    }

    protected abstract int getContentView();

    protected abstract V getViewModel();

    protected abstract int getVariableId();

    protected abstract void setInjection();

    protected abstract void initView(View view);

    @Override
    public void onLoading() {

    }

    @Override
    public void onLoadDone() {

    }

    @Override
    public void showLoading() {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.showLoading();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hideLoading() {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.hideLoading();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAlertDialog(boolean hasTitle, String msg) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.showAlertDialog(hasTitle, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAlertDialog(boolean hasTitle, String msg, BaseDialog.OnPositiveClickListener cancelListener) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.showAlertDialog(hasTitle, msg, cancelListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAlertDialog(String msg) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.showAlertDialog(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAlertDialog(String msg, BaseDialog.OnPositiveClickListener positiveListener) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.showAlertDialog(msg, positiveListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showToast(String msg) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.showToast(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showConfirmDialog(boolean hasTitle, String msg, String positive, String negative, BaseDialog.OnPositiveClickListener positiveListener, BaseDialog.OnNegativeClickListener negativeListener) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.showConfirmDialog(hasTitle, msg, positive, negative, positiveListener, negativeListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showConfirmDialog(String msg, BaseDialog.OnPositiveClickListener positiveListener, BaseDialog.OnNegativeClickListener negativeListener) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.showConfirmDialog(msg, positiveListener, negativeListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showConfirmDialog(boolean hasTitle, String msg, BaseDialog.OnPositiveClickListener positiveListener, BaseDialog.OnNegativeClickListener negativeListener) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.showConfirmDialog(hasTitle, msg, positiveListener, negativeListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void replaceFragment(Fragment fragment, boolean addBackStack) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.replaceFragment(fragment, addBackStack);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void replaceFragment(Fragment fragment, int layout, boolean addBackStack) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.replaceFragment(fragment, layout, addBackStack);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void replaceFragment(FragmentManager manager, Fragment fragment, boolean addBackStack, int enter, int exit, int popEnter, int popExit) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.replaceFragment(manager, fragment, addBackStack, enter, exit, popEnter, popExit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void replaceFragment(FragmentManager manager, Fragment fragment, int layout, boolean addBackStack) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.replaceFragment(manager, fragment, layout, addBackStack);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void popBackStack() {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.popBackStack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void popBackStack(FragmentManager manager) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.popBackStack(manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void popBackStack(String tag) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.popBackStack(tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void popBackStack(FragmentManager manager, String tag) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.popBackStack(manager, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void replaceFragment(FragmentManager manager, Fragment fragment, int res, boolean addBackStack, int enter, int exit, int popEnter, int popExit) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.replaceFragment(manager, fragment, res, addBackStack, enter, exit, popEnter, popExit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void replaceFragment(FragmentManager manager, Fragment fragment, int res, boolean addBackStack, View shareElement, String transitionName) {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.replaceFragment(manager, fragment, res, addBackStack, shareElement, transitionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearBackStack() {
        try {
            MVVMActivity mvpActivity = (MVVMActivity) getActivity();
            mvpActivity.clearBackStack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Context getBaseContext() {
        return getContext();
    }

    @Override
    public MVVMActivity getBaseActivity() {
        return (MVVMActivity) getActivityReference();
    }

    @Override
    public BaseApplication getBaseApplication() {
        return (BaseApplication) getActivityReference().getApplication();
    }

}
