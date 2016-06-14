package com.mrcannady.testapplication.rest;

import com.mrcannady.testapplication.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by irwan on 6/14/16.
 */
public interface ServiceAPi {

    @GET("/posts")
    Call<List<Model>> getJson();

}
