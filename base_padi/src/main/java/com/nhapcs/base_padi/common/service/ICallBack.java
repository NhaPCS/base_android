package com.nhapcs.base_padi.common.service;

import com.google.gson.Gson;
import com.nhapcs.base_padi.common.service.response.BaseResponse;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Nha Nha on 6/27/2017.
 */

public abstract class ICallBack implements Callback {


    @Override
    public void onFailure(Call call, IOException e) {
        try {
            onFailed(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        try {
            String body = response.body().string();
            BaseResponse baseResponse = new Gson().fromJson(body, BaseResponse.class);
            onResponse(body, response.isSuccessful());
        } catch (Exception e) {
            e.printStackTrace();
            onFailure(call, new IOException());
        }
    }

    public abstract void onErrorToken();

    public abstract void onFailed(IOException e);

    public abstract void onResponse(String response, boolean isSuccessful);
}
