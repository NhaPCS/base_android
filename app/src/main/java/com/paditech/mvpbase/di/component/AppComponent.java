package com.paditech.mvpbase.di.component;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.paditech.mvpbase.di.module.AppModule;
import com.paditech.mvpbase.screen.main.MainActivity;
import com.paditech.mvpbase.screen.main.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by nhapcs on 6/10/18.
 */

@Singleton
@Component(modules = {AppModule.class, MainModule.class})
public interface AppComponent {

    void inject(MainActivity activity);

    void inject(Fragment fragment);

    void inject(Application application);

}
