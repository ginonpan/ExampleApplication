package com.example.exampleapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContentFragment extends Fragment {

    TextView textView;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.fragment_content,
                container,
                false);
        textView = (TextView)
                v.findViewById(R.id.textView);
        return v;
    }

    public void setText(String s){
        textView.setText(s);
    }
}