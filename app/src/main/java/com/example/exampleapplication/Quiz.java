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

    private static Quiz[] quizzes = new Quiz[3]; //クイズ集

    // 問題の登録
    public static void init() {
        quizzes[0] = new Quiz(0, "第1問", R.drawable.sakura, new String[]{"桃", "紅葉", "桜", "椿"}, 2);
        quizzes[1] = new Quiz(1, "第2問", R.drawable.rose, new String[]{"薔薇", "タンポポ", "すみれ", "チューリップ"}, 0);
        quizzes[2] = new Quiz(2, "第3問", R.drawable.sea, new String[]{"空", "草原", "宇宙", "海"}, 3);
    }

    // 問題を取得する
    public static Quiz getQuiz(int num) {
        if (num >= quizzes.length) {
            return null;
        }
        return quizzes[num];
    }
}
