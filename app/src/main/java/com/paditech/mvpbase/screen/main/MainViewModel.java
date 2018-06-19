package com.paditech.mvpbase.screen.main;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.gson.Gson;
import com.nhapcs.base_padi.common.mvvm.view_model.BaseViewModel;
import com.paditech.mvpbase.service.MyClient;
import com.paditech.mvpbase.service.response.ListCategoriesResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by nhapcs on 6/9/18.
 */
public class MainViewModel extends BaseViewModel<MainNavigator> {

    public MainViewModel() {
        super();
        getListCategories();
    }

    @Override
    protected void handleError(Throwable error) {
        Log.e("LIST", "error: " + error.getMessage());
    }

    @SuppressLint("CheckResult")
    public void getListCategories() {
        Log.e("LIST", "get list");
        mCompositeDisposable.add(MyClient.getInstance().getService().getCategories()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError));
    }

    private void handleResponse(ListCategoriesResponse listCategoriesResponse) {
        Log.e("LIST", new Gson().toJson(listCategoriesResponse));
        getNavigator().updateData(listCategoriesResponse.getListCategories());
    }


}
