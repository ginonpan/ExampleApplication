package com.example.exampleapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity
        implements OnSampleListChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListSelectedChanged(String s) {
        FragmentManager fragmentManager
                = getFragmentManager();
        ContentFragment contentFragment =
                (ContentFragment) fragmentManager
                        .findFragmentByTag("contentFragment");
        if(contentFragment == null
                || !contentFragment.isVisible()){
            Toast.makeText(getBaseContext(),
                    s,
                    Toast.LENGTH_SHORT)
                    .show();
        }
        else{
            contentFragment.setText(s);
        }
    }
}