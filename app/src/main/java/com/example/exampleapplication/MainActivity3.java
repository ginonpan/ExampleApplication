package com.example.exampleapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends Activity
{
    // 追加
    int count = 0;
    private TextView counter_text;
    private Button push_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);

        // 追加：画面のアイテムと紐付け
        counter_text = (TextView)findViewById(R.id.text_view2);
        push_btn = (Button)findViewById(R.id.button);

        // 追加：クリック
        push_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count++;
                counter_text.setText(String.valueOf(count));
                if(count == 10) {
                    finish();
                }
            }
        });

    }

}
