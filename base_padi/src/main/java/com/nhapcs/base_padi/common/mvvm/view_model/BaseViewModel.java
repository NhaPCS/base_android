package com.nhapcs.base_padi.common.mvvm.view_model;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.nhapcs.base_padi.common.mvvm.Navigator;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by nhapcs on 6/9/18.
 */
public abstract class BaseViewModel<N extends Navigator> extends ViewModel {
    protected CompositeDisposable mCompositeDisposable;

    private WeakReference<N> mNavigator;

    public BaseViewModel() {
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    protected abstract void handleError(Throwable error);
}
