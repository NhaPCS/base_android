package com.paditech.mvpbase.screen.main;

import android.util.Log;

import com.paditech.mvpbase.screen.fragment.HomeViewModel;
import com.paditech.mvpbase.service.MyClient;
import com.paditech.mvpbase.service.MyService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nhapcs on 6/10/18.
 */

@Module
public class MainModule {

    @Provides
    @Singleton
    MainViewModel provideViewModel() {
        Log.e("run here", "model");
        return new MainViewModel();
    }

    @Provides
    @Singleton
    HomeViewModel proviewHomeViewModel() {
        return new HomeViewModel();
    }

    @Provides
    @Singleton
    MyService provideService() {
        Log.e("run here", "service");
        return MyClient.getInstance().getService();
    }

}
