package com.paditech.mvpbase.service;

import com.nhapcs.base_padi.common.service.APIClient;

import javax.inject.Inject;

/**
 * Created by nhapcs on 6/10/18.
 */
public class MyClient extends APIClient<MyService> {

    private static MyClient instance;

    public static MyClient getInstance() {
        if (instance == null) {
            instance = new MyClient();
            instance.generateAPIService();
        }
        return instance;
    }

    @Override
    protected String getBaseUrl() {
        return "http://hamara-pakistan.com/api/web/v1/";
    }

    @Override
    protected Class<MyService> getServiceType() {
        return MyService.class;
    }
}
