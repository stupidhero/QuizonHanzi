package com.example.android.quizonhanzi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Jonas on 31.03.2018.
 */

public class Question7 extends AppCompatActivity {

    private int score;
    private CheckBox answer1;
    private CheckBox answer2;
    private CheckBox answer3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        Bundle temp = getIntent().getExtras();
        String savedScore = temp.getString("score");
        score = Integer.parseInt(savedScore);

        TextView question = findViewById(R.id.question);
        question.setText(getResources().getString(R.string.questionRelated1));

        answer1 = findViewById(R.id.answer1);
        answer1.setText(getResources().getString(R.string.answer71));
        answer2 = findViewById(R.id.answer2);
        answer2.setText(getResources().getString(R.string.answer72));
        answer3 = findViewById(R.id.answer3);
        answer3.setText(getResources().getString(R.string.answer73));


        final Intent resultPage = new Intent(this, Results.class);

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.isChecked() && answer3.isChecked() && (answer2.isChecked() == false)) {
                    score += 1;
                }

                Bundle savedScore = new Bundle();
                savedScore.putString("score", "" + score);
                resultPage.putExtras(savedScore);

                startActivity(resultPage);

            }
        });
    }


}

