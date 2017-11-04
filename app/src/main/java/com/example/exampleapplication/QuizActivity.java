package com.example.exampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity
{

    private TextView tv_num;
    private ImageView imageView;
    private Button[] buttons;
    private Quiz quiz;
    private TextView result;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // 画面上のウィジェットを取得しておく
        tv_num     = (TextView) findViewById(R.id.q_string);
        imageView  = (ImageView) findViewById(R.id.flag_image);
        buttons    = new Button[4];
        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3] = (Button) findViewById(R.id.button4);
        result      = (TextView) findViewById(R.id.result);
        next        = (Button) findViewById(R.id.next);

        // データを受け取る
        Intent intent = getIntent();
        if (intent != null) {
            quiz = (Quiz) intent.getSerializableExtra("Quiz");
            show();
        }
    }

    // 表示に反映させる
    void show() {
        if (quiz != null) {
            tv_num.setText(quiz.q_string);
            imageView.setImageResource(quiz.image);
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(true);
                buttons[i].setText(quiz.choices[i]);
            }
            result.setText("");
            next.setVisibility(View.INVISIBLE);
        }
    }

    public void answer(View view) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(false);
            if (view.getId() == buttons[i].getId()) {
                if (i == quiz.answer_index) {
                    result.setText("正解!");
                    next.setVisibility(View.VISIBLE);
                } else {
                    result.setText("不正解");
                    next.setText("戻る");
                    next.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void next(View view){
        if(result.getText() == "不正解") {
            finish();
        } else {
            quiz = Quiz.getQuiz(quiz.quiz_num + 1);
            if (quiz != null) {
                show();
            } else {
                finish();
            }
        }
    }
}
