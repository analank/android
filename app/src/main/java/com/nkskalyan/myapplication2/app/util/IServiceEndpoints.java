package com.nkskalyan.myapplication2.app.util;

import com.nkskalyan.myapplication2.app.models.User;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by knachiappan on 8/9/15.
 */
public interface IServiceEndpoints {

    @GET("/55be7b8f395dd4691513dd8e")
    void getUsers(Callback<User> cb);
}
