package com.cs407.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView = (TextView) findViewById(R.id.result);
        Intent intent = getIntent();
        int result = 0;
        int first = intent.getIntExtra("firstInt", 0);
        int second = intent.getIntExtra("secondInt", 0);
        String op = intent.getStringExtra("op");
        if(op.equals("+")) {
            result = first + second;
        } else if(op.equals("-")) {
            result = first - second;
        } else if(op.equals("x")) {
            result = first * second;
        } else if(op.equals("/")) {
            double result2 = (double) first / (double) second;
            textView.setText("Result: " + result2);
            return;
        }
        textView.setText("Result: " + result);
    }
}