package com.example.exampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class DetailActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    void move() {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}
