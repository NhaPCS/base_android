package com.paditech.mvpbase.service;

import com.paditech.mvpbase.service.response.ListCategoriesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by nhapcs on 6/10/18.
 */
public interface MyService {
    @GET("categories/list_categories")
    Observable<ListCategoriesResponse> getCategories();
}
