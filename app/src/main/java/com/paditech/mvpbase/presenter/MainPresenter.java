package com.paditech.mvpbase.presenter;

import com.paditech.mvpbase.contact.MainContact;
import com.paditech.mvpbase.model.Slide;
import com.paditech.mvpbase.mvp.activity.ActivityPresenter;
import com.paditech.mvpbase.service.APIService;
import com.paditech.mvpbase.service.ICallBack;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nha Nha on 6/27/2017.
 */

public class MainPresenter extends ActivityPresenter<MainContact.ViewOps> implements MainContact.PresenterViewOps {
    private APIService mApiService;

    @Override
    public void onCreate() {
        super.onCreate();
        mApiService = new APIService();
    }

}
