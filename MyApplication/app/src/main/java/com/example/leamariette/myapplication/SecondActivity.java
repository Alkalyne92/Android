package com.example.leamariette.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.web_container, NewsFragment.newInstance((News) getIntent().getParcelableExtra("OneNews")))
                .commit();

    }
}

