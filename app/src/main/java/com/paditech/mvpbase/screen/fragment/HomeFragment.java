package com.paditech.mvpbase.screen.fragment;

import android.util.Log;
import android.view.View;

import com.nhapcs.base_padi.common.mvvm.MVVMFragment;
import com.nhapcs.base_padi.common.mvvm.Navigator;
import com.paditech.mvpbase.MyApplication;
import com.paditech.mvpbase.R;
import com.paditech.mvpbase.BR;
import com.paditech.mvpbase.databinding.FragHomeBinding;

import javax.inject.Inject;

/**
 * Created by nhapcs on 6/10/18.
 */
public class HomeFragment extends MVVMFragment<FragHomeBinding, HomeViewModel> implements Navigator {

    @Inject
    HomeViewModel homeViewModel;

    @Override
    protected int getContentView() {
        return R.layout.frag_home;
    }

    @Override
    protected HomeViewModel getViewModel() {
        Log.e("HomeModel", homeViewModel+"");
        return homeViewModel;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void setInjection() {
        ((MyApplication) getActivityReference().getApplication()).getAppComponent().inject(this);
    }

    @Override
    protected void initView(View view) {
    }


}
