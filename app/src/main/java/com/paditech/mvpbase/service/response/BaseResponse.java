package com.paditech.mvpbase.service.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nha Nha on 6/28/2017.
 */

public class BaseResponse {
    @SerializedName("code")
    int code;
    @SerializedName("message")
    String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
