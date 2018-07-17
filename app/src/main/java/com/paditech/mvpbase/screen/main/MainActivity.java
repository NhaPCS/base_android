package com.paditech.mvpbase.screen.main;

import android.databinding.ViewDataBinding;
import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;
import com.nhapcs.base_padi.common.mvvm.MVVMActivity;
import com.nhapcs.base_padi.common.mvvm.view_model.BaseViewModel;
import com.paditech.mvpbase.MyApplication;
import com.paditech.mvpbase.R;
import com.paditech.mvpbase.BR;
import com.paditech.mvpbase.databinding.ActMainBinding;
import com.paditech.mvpbase.model.Category;
import com.paditech.mvpbase.screen.fragment.HomeFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Nha Nha on 9/19/2017.
 */

public class MainActivity extends MVVMActivity<ActMainBinding, MainViewModel> implements MainNavigator {

    @Inject
    MainViewModel mainViewModel;

    @Override
    protected int getContentView() {
        return R.layout.act_main;
    }

    @Override
    protected MainViewModel initViewModel() {
        Log.e("WTF", mainViewModel + "");
        return mainViewModel;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        new Handler().postDelayed(() -> showAlertDialog("Ahihi"), 3000);
        replaceFragment(new HomeFragment(), true);
    }

    @Override
    protected void setInjection() {
        ((MyApplication) getApplication()).getAppComponent().inject(this);
    }

    @Override
    protected boolean hasAutoCheckNetwork() {
        return false;
    }


    @Override
    public void updateData(List<Category> categories) {
        getDataBinding().name.setText(new Gson().toJson(categories));
    }
}
