package com.paditech.mvpbase;

import com.crashlytics.android.Crashlytics;
import com.nhapcs.base_padi.common.base.BaseApplication;
import com.paditech.mvpbase.di.component.AppComponent;
import com.paditech.mvpbase.di.component.DaggerAppComponent;
import com.paditech.mvpbase.service.MyService;

import javax.inject.Inject;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Nha Nha on 6/27/2017.
 */

public class MyApplication extends BaseApplication {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Inject
    MyService mMyService;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        appComponent = DaggerAppComponent.builder().build();
        appComponent.inject(this);
    }
}
