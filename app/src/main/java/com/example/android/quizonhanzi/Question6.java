package com.example.android.quizonhanzi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jonas on 31.03.2018.
 */

public class Question6 extends AppCompatActivity {

    private int score = 0;
    private String answer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Bundle temp = getIntent().getExtras();
        String savedScore = temp.getString("score");
        score = Integer.parseInt(savedScore);

        TextView question = findViewById(R.id.question);
        question.setHint(getResources().getString(R.string.writePinyin));

        final EditText answerView = findViewById(R.id.answer);
        final Intent nextQuestion = new Intent(this, Question7.class);

        Button nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = answerView.getText().toString();

                if (answer.equals(getResources().getString(R.string.pinyin61)) || answer.equals(getResources().getString(R.string.pinyin62))) {
                    score += 1;
                }

                Bundle savedScore = new Bundle();
                savedScore.putString("score", "" + score);
                nextQuestion.putExtras(savedScore);

                startActivity(nextQuestion);

            }
        });

    }

}




