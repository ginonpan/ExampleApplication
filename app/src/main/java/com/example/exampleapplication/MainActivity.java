package com.example.exampleapplication;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void move() {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}
