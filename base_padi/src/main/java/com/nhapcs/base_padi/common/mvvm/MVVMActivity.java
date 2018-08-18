package com.nhapcs.base_padi.common.mvvm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.nhapcs.base_padi.R;
import com.nhapcs.base_padi.common.base.BaseApplication;
import com.nhapcs.base_padi.common.base.BaseDialog;
import com.nhapcs.base_padi.common.dialog.LoadingDialog;
import com.nhapcs.base_padi.common.dialog.MessageDialog;
import com.nhapcs.base_padi.common.mvvm.view_model.BaseViewModel;
import com.nhapcs.base_padi.common.utils.CommonUtil;

/**
 * Created by nhapcs on 6/9/18.
 */
public abstract class MVVMActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity implements Navigator {
    private static final String CONNECT_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

    private LoadingDialog mLoadingDialog;
    private Snackbar mSnackbarNoConnect;
    private MessageDialog mDialog;

    private T dataBinding;
    private V viewModel;

    public T getDataBinding() {
        return dataBinding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setInjection();
        super.onCreate(savedInstanceState);
        initDataBinding();
        mLoadingDialog = new LoadingDialog();
        setupSnackBar();
        try {
            initView();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, getContentView());
        viewModel = viewModel == null ? initViewModel() : viewModel;
        dataBinding.setVariable(getVariableId(), viewModel);
        dataBinding.executePendingBindings();
        if (viewModel != null) viewModel.setNavigator(this);
        Log.e("viewModel", viewModel + "");
    }

    protected abstract int getContentView();

    protected abstract V initViewModel();

    protected abstract int getVariableId();

    protected abstract void initView();

    protected abstract void setInjection();

    protected abstract boolean hasAutoCheckNetwork();


    public V getViewModel() {
        return viewModel;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.from_left, R.anim.to_right);
    }

    public void setupSnackBar() {
        try {
            if (hasAutoCheckNetwork()) {
                View view = getWindow().getDecorView().findViewById(android.R.id.content);
                if (view != null) {
                    mSnackbarNoConnect = Snackbar.make(view, getString(R.string.mess_no_connect), Snackbar.LENGTH_INDEFINITE);
                    registerReceiver(mConnectReceiver, new IntentFilter(CONNECT_ACTION));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BroadcastReceiver mConnectReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(CONNECT_ACTION)) {
                if (!CommonUtil.hasConnected(context)) {
                    if (mSnackbarNoConnect != null) mSnackbarNoConnect.show();
                } else {
                    if (mSnackbarNoConnect != null) mSnackbarNoConnect.dismiss();
                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        if (hasAutoCheckNetwork()) {
            try {
                unregisterReceiver(mConnectReceiver);
            } catch (Exception ignored) {
            }
        }
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mSnackbarNoConnect != null && !CommonUtil.hasConnected(this)) mSnackbarNoConnect.show();
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onLoadDone() {

    }

    @Override
    public void showLoading() {
        try {
            if (mLoadingDialog == null) {
                mLoadingDialog = new LoadingDialog();
            }
            if (!mLoadingDialog.isAdded()) {
                mLoadingDialog.show(getSupportFragmentManager(), mLoadingDialog.getClass().getSimpleName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hideLoading() {
        try {
            if (mLoadingDialog != null && mLoadingDialog.isVisible()) {
                mLoadingDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAlertDialog(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null && mDialog.isVisible()) mDialog.dismiss();
                mDialog = MessageDialog.newInstance(false, msg);
                mDialog.show(getSupportFragmentManager(), mDialog.getClass().getSimpleName());
            }
        });
    }

    @Override
    public void showAlertDialog(boolean hasTitle, final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null && mDialog.isVisible()) mDialog.dismiss();
                mDialog = MessageDialog.newInstance(true, msg);
                mDialog.show(getSupportFragmentManager(), mDialog.getClass().getSimpleName());
            }
        });
    }

    @Override
    public void showAlertDialog(final boolean hasTitle, final String msg, final BaseDialog.OnPositiveClickListener positiveClickListener) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null && mDialog.isVisible()) mDialog.dismiss();
                mDialog = MessageDialog.newInstance(hasTitle, msg);
                mDialog.setmOnPositiveClickListener(positiveClickListener);
                mDialog.show(getSupportFragmentManager(), mDialog.getClass().getSimpleName());
            }
        });
    }

    @Override
    public void showAlertDialog(final String msg, final BaseDialog.OnPositiveClickListener positiveClickListener) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null && mDialog.isVisible()) mDialog.dismiss();
                mDialog = MessageDialog.newInstance(false, msg);
                mDialog.setmOnPositiveClickListener(positiveClickListener);
                mDialog.show(getSupportFragmentManager(), mDialog.getClass().getSimpleName());
            }
        });
    }

    @Override
    public void showConfirmDialog(final String msg, final BaseDialog.OnPositiveClickListener positiveListener, final BaseDialog.OnNegativeClickListener negativeListener) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null && mDialog.isVisible()) mDialog.dismiss();
                mDialog = MessageDialog.newInstance(false, msg, getString(R.string.ok), getString(R.string.cancel));
                mDialog.setmOnPositiveClickListener(positiveListener);
                mDialog.setmOnNegativeClickListener(negativeListener);
                mDialog.show(getSupportFragmentManager(), mDialog.getClass().getSimpleName());
            }
        });
    }

    @Override
    public void showConfirmDialog(final boolean hasTitle, final String msg, final BaseDialog.OnPositiveClickListener positiveListener, final BaseDialog.OnNegativeClickListener negativeListener) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null && mDialog.isVisible()) mDialog.dismiss();
                mDialog = MessageDialog.newInstance(hasTitle, msg, getString(R.string.ok), getString(R.string.cancel));
                mDialog.setmOnPositiveClickListener(positiveListener);
                mDialog.setmOnNegativeClickListener(negativeListener);
                mDialog.show(getSupportFragmentManager(), mDialog.getClass().getSimpleName());
            }
        });
    }

    @Override
    public void showToast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showConfirmDialog(final boolean hasTitle, final String msg, final String positive, final String negative, final BaseDialog.OnPositiveClickListener positiveListener,
                                  final BaseDialog.OnNegativeClickListener negativeListener) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null && mDialog.isVisible()) mDialog.dismiss();
                mDialog = MessageDialog.newInstance(hasTitle, msg, positive, negative);
                mDialog.setmOnPositiveClickListener(positiveListener);
                mDialog.setmOnNegativeClickListener(negativeListener);
                mDialog.show(getSupportFragmentManager(), mDialog.getClass().getSimpleName());
            }
        });
    }

    @Override
    public void replaceFragment(Fragment fragment, boolean addBackStack) {
        replaceFragment(getSupportFragmentManager(), fragment, R.id.main_layout, addBackStack, R.anim.from_right, R.anim.to_left, R.anim.from_left, R.anim.to_right);

    }

    @Override
    public void replaceFragment(Fragment fragment, int layout, boolean addBackStack) {
        replaceFragment(getSupportFragmentManager(), fragment, layout, addBackStack, R.anim.from_right, R.anim.to_left, R.anim.from_left, R.anim.to_right);

    }

    @Override
    public void replaceFragment(FragmentManager manager, Fragment fragment, boolean addBackStack, int enter, int exit, int popEnter, int popExit) {
        replaceFragment(manager, fragment, R.id.main_layout, addBackStack, R.anim.from_right, R.anim.to_left, R.anim.from_left, R.anim.to_right);

    }

    @Override
    public void replaceFragment(FragmentManager manager, Fragment fragment, int layout, boolean addBackStack) {
        replaceFragment(manager, fragment, layout, addBackStack, R.anim.from_right, R.anim.to_left, R.anim.from_left, R.anim.to_right);
    }

    @Override
    public void replaceFragment(final FragmentManager manager, final Fragment fragment, final int res, final boolean addBackStack, final int enter, final int exit, final int popEnter, final int popExit) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    FragmentTransaction fragmentTransaction = manager.beginTransaction();
                    if (enter != 0 && exit != 0 && popEnter != 0 && popExit != 0)
                        fragmentTransaction.setCustomAnimations(enter, exit, popEnter, popExit);
                    if (addBackStack)
                        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
                    fragmentTransaction.replace(res, fragment, fragment.getClass().getSimpleName());
                    fragmentTransaction.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void replaceFragment(final FragmentManager manager, final Fragment fragment, final int res, final boolean addBackStack, final View shareElement, final String transitionName) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    FragmentTransaction fragmentTransaction = manager.beginTransaction();
                    if (shareElement != null)
                        fragmentTransaction.addSharedElement(shareElement, transitionName);
                    if (addBackStack)
                        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
                    fragmentTransaction.replace(res, fragment, fragment.getClass().getSimpleName());
                    fragmentTransaction.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void popBackStack() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Override
    public void popBackStack(final FragmentManager manager) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                manager.popBackStack();
            }
        });
    }

    @Override
    public void popBackStack(final String tag) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });
    }

    @Override
    public void popBackStack(final FragmentManager manager, final String tag) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                manager.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });
    }

    @Override
    public void clearBackStack() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FragmentManager fm = getSupportFragmentManager();
                int count = fm.getBackStackEntryCount();
                for (int i = 0; i < count; ++i) {
                    fm.popBackStack();
                }
            }
        });
    }

    @Override
    public BaseApplication getBaseApplication() {
        return (BaseApplication) getApplication();
    }

    @Override
    public MVVMActivity getBaseActivity() {
        return this;
    }

    @Override
    public Context getMainContext() {
        return this;
    }

    @Override
    public void notifyViewModelDataChange() {
        dataBinding.executePendingBindings();
        dataBinding.setVariable(getVariableId(), viewModel);
    }
}
