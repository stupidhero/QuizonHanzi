package com.example.android.quizonhanzi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class Question2 extends AppCompatActivity {


    private RadioButton answer1;
    private RadioButton answer2;
    private RadioButton answer3;
    private int score;
    private Random randNum = new Random();
    boolean initVal = randNum.nextBoolean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        Bundle temp = getIntent().getExtras();
        String savedScore = temp.getString("score");
        score = Integer.parseInt(savedScore);

        TextView hanzi = findViewById(R.id.hanzi);
        hanzi.setText(getResources().getString(R.string.hanzi2));

        TextView question = findViewById(R.id.question);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);

        if (initVal) {
            question.setText(getResources().getString(R.string.meaningOf));
            answer1.setText(getResources().getString(R.string.meaning21));
            answer2.setText(getResources().getString(R.string.meaning22));
            answer3.setText(getResources().getString(R.string.meaning23));
        } else {
            question.setText(getResources().getString(R.string.readingOf));
            answer1.setText(getResources().getString(R.string.reading21));
            answer2.setText(getResources().getString(R.string.reading22));
            answer3.setText(getResources().getString(R.string.reading23));

        }

    }

    public void onRadioButtonClick(View view) {
        if (initVal) {
            if (answer3.isChecked()) {
                score += 1;
            }
        } else {
            if (answer3.isChecked()) {
                score += 1;
            }
        }

        Intent nextQuestion = new Intent(this, Question3.class);

        Bundle savedScore = new Bundle();
        savedScore.putString("score", "" + score);
        nextQuestion.putExtras(savedScore);

        startActivity(nextQuestion);
    }
}
