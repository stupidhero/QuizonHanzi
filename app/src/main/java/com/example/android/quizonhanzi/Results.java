package com.example.android.quizonhanzi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    int numberOfQuestion= 5;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle temp = getIntent().getExtras();
        String savedScore = temp.getString("score");
        score = Integer.parseInt(savedScore);

        TextView result = (TextView) findViewById(R.id.scoreIs);
        TextView resultText =(TextView) findViewById(R.id.resultIs);
        result.setText("" + score);
        if(score < numberOfQuestion/2 ){
            result.setTextColor(0xffff0000);
            resultText.setText(R.string.resultIsBad);
        }
       }
}
