package com.paditech.mvpbase.di.module;

import android.app.Application;
import android.util.Log;

import com.nhapcs.base_padi.common.base.BaseApplication;
import com.paditech.mvpbase.service.MyClient;
import com.paditech.mvpbase.service.MyService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nhapcs on 6/10/18.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    BaseApplication provideContext(Application application) {
        Log.e("run here", "app");
        return (BaseApplication) application;
    }

}
