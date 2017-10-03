package com.example.exampleapplication;

import java.io.Serializable;

public class Quiz implements Serializable
{
    int quiz_num;                     //クイズ番号
    String q_string;                  //第○問というString
    int image;                        //画像ID
    String[] choices = new String[4]; //選択肢
    int answer_index;                //正解

    //クイズの中身
    private Quiz(int quiz_num, String q_string, int image, String[] choices, int answer_index) {
        this.quiz_num      = quiz_num;
        this.q_string      = q_string;
        this.image         = image;
        this.choices       = choices;
        this.answer_index = answer_index;
    }

    private static Quiz[] quizzes = new Quiz[1]; //クイズ集

    // 問題の登録(ここでは1問のみ)
    public static void init() {
        quizzes[0] = new Quiz(0, "第1問", R.drawable.france, new String[]{"イタリア", "フランス", "ロシア", "オランダ"}, 1);
    }

    // 問題を取得する
    public static Quiz getQuiz(int num) {
        if (num >= quizzes.length) {
            return null;
        }
        return quizzes[num];
    }
}
