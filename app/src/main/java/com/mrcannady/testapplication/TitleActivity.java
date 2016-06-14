package com.mrcannady.testapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.mrcannady.testapplication.model.JSONresponse;
import com.mrcannady.testapplication.model.Model;
import com.mrcannady.testapplication.rest.ServiceAPi;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TitleActivity extends AppCompatActivity {

    public static final String VERSION = "";
    public static final String NAME = "";

    private RecyclerView recyclerView;
    private ArrayList<Model> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.cardview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();

    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceAPi request = retrofit.create(ServiceAPi.class);
        Call<JSONresponse> call = request.getJson();
        call.enqueue(new Callback<JSONresponse>() {
            @Override
            public void onResponse(Call<JSONresponse> call, Response<JSONresponse> response) {

                JSONresponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getModel()));
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<JSONresponse> call, Throwable t) {

                Log.d("Error",t.getMessage());
            }
        });
    }

}
