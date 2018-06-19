package com.paditech.mvpbase.service.response;

import com.google.gson.annotations.SerializedName;
import com.paditech.mvpbase.model.Category;

import java.util.List;

public class ListCategoriesResponse {

    /**
     * code : 1
     * time : 16-06-2018 16:01
     * list_categories : [{"id":1,"title":"Football"},{"id":2,"title":"game"},{"id":3,"title":"Education"},{"id":4,"title":"number phone"},{"id":5,"title":"address"},{"id":6,"title":"Technology"},{"id":7,"title":"Machine Learning"},{"id":8,"title":"Music World"},{"id":9,"title":"hockey"}]
     */

    @SerializedName("code")
    private int code;
    @SerializedName("time")
    private String time;
    @SerializedName("list_categories")
    private List<Category> listCategories;

    public int getCode() {
        return code;
    }

    public String getTime() {
        return time;
    }

    public List<Category> getListCategories() {
        return listCategories;
    }
}
