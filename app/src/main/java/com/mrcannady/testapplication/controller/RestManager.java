package com.mrcannady.testapplication.controller;

import com.mrcannady.testapplication.rest.ServiceAPi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by irwan on 6/14/16.
 */
public class RestManager {

    private ServiceAPi serviceAPi;

    public ServiceAPi getServiceAPi(){

        if (serviceAPi == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            serviceAPi = retrofit.create(ServiceAPi.class);
        }

        return serviceAPi;
    }
}
