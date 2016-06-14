package com.mrcannady.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView txtDetail = (TextView) findViewById(R.id.tv_detail);

        Intent intent=  getIntent();
        txtDetail.setText("Body : " + intent.getStringExtra(TitleActivity.BODY));

    }
}
