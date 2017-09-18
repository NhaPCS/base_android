package com.paditech.mvpbase;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by Nha Nha on 6/27/2017.
 */

public class BaseApplication extends MultiDexApplication {

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
