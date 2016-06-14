package com.mrcannady.testapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.mrcannady.testapplication.controller.RestManager;
import com.mrcannady.testapplication.model.Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TitleActivity extends AppCompatActivity implements DataAdapter.TitleClickListener {

    public static final String VERSION = "";
    public static final String NAME = "";

    private RecyclerView recyclerView;
    private DataAdapter adapter;
    public LinearLayout ll;

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
        adapter = new DataAdapter(this);
        recyclerView.setAdapter(adapter);
        loadJSON();

    }

    private void loadJSON() {

        final ProgressDialog loading = ProgressDialog.show(this, "Loading Data", "Please wait...", false, false);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://jsonplaceholder.typicode.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ServiceAPi request = retrofit.create(ServiceAPi.class);

        RestManager request = new RestManager();
        Call<List<Model>> call = request.getServiceAPi().getJson();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                loading.dismiss();

                    List<Model> modelList = response.body();

                    for (int i = 0; i < modelList.size(); i++) {
                        Model model = modelList.get(i);
                        adapter.addModel(model);
                    }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }

        });


    }

    @Override
    public void onClick(int position) {

    }
}