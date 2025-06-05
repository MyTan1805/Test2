package com.project.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView textViewLuckyNumberLabel;
    TextView textViewLuckyNumber;
    Button buttonShareNumber;

    String userName;
    int luckyNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewLuckyNumberLabel = findViewById(R.id.textViewLuckyNumberLabel);
        textViewLuckyNumber = findViewById(R.id.textViewLuckyNumber);
        buttonShareNumber = findViewById(R.id.buttonShareNumber);

        Intent intent = getIntent();
        userName = intent.getStringExtra("USER_NAME");

        Random random = new Random();
        luckyNumber = random.nextInt(900) + 100;

        textViewLuckyNumber.setText(String.valueOf(luckyNumber));

        buttonShareNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareLuckyNumber();
            }
        });
    }

    private void shareLuckyNumber() {
        String message = getString(R.string.share_message_template, userName, luckyNumber);

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_subject));
        shareIntent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_via)));
    }
}