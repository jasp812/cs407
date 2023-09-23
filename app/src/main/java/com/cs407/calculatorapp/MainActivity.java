package com.cs407.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {
        EditText editTextText = (EditText) findViewById(R.id.editTextText);
        EditText editTextText2 = (EditText) findViewById(R.id.editTextText2);
        Button button = (Button) view;
        goToActivity(editTextText.getText().toString(), editTextText2.getText().toString(), button.getText().toString());
    }


    public void goToActivity(String num1, String num2, String op) {
        int first, second = 0;

        try {
            first = Integer.parseInt(num1);
            second = Integer.parseInt(num2);
        } catch(NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Please enter" +
                    " integers into the text field", Toast.LENGTH_LONG).show();
            return;
        }

        if(op.equals("/") && second == 0) {
            Toast.makeText(MainActivity.this, "Cannot divide by zero. Try dividing by" +
                    " a different number", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, Result.class);
        intent.putExtra("firstInt", Integer.parseInt(num1));
        intent.putExtra("secondInt", Integer.parseInt(num2));
        intent.putExtra("op", op);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}