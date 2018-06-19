package com.paditech.mvpbase.di.module;

import com.nhapcs.base_padi.common.mvvm.MVVMActivity;

import dagger.Module;

/**
 * Created by nhapcs on 6/10/18.
 */

@Module
public abstract class BaseActivityModule {
    MVVMActivity activity;

    public BaseActivityModule(MVVMActivity activity) {
        this.activity = activity;
    }

}
