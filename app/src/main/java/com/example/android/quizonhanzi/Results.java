package com.example.android.quizonhanzi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    int numberOfQuestion = 8;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle temp = getIntent().getExtras();
        String savedScore = temp.getString("score");
        score = Integer.parseInt(savedScore);

        TextView result = findViewById(R.id.resultIs);
        if (score < numberOfQuestion / 2) {
            result.setText(R.string.resultIsBad);
        }

        Button resultButton = findViewById(R.id.resultButton);

        resultButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Toast toast = Toast.makeText(Results.this, "Your result is: " + score, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, -5);
                toast.show();
            }

        });
    }
}
