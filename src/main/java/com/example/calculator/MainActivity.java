package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isFirstInput = true;
    int resultNumber = 0;
    char operator = '+';

    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.result_text);
    }


}
