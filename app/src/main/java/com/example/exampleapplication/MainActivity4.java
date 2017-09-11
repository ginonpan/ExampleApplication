package com.example.exampleapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity4 extends Activity
{
    private TextView textView;
    private String[] results={
            "大吉",
            "中吉",
            "小吉",
            "凶"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_4);

        //TextViewの取得
        textView = (TextView)findViewById(R.id.text_view2);
        //ボタンの取得
        final Button button = (Button)findViewById(R.id.button);
        final Button back   = (Button)findViewById(R.id.back);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Random randomGenerator = new Random();
                int num = randomGenerator.nextInt(results.length);
                //配列の中から適当な要素をテキストにセット
                textView.setText(results[num]);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });

    }

}
