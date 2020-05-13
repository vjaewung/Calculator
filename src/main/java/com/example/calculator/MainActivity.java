package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    boolean isFirstInput = true;
    int resultNumber = 0;
    char operator = '+';

    TextView resultText;

    /*Button num0;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.result_text);

        /*
        num0 = findViewById(R.id.num_0_button);
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */
    }

    @SuppressLint("ResourceType")
    public void buttonClick(View view) {

        /*
        if(view.getId() == R.id.all_clear_button) {
            isFirstInput = true;
            resultNumber = 0;
            operator = '+';
            resultText.setTextColor(0xFF666666);
            resultText.setText(String.valueOf(resultNumber));
        }
        */

        Button getButton = findViewById(view.getId());
        Log.e(">>>>>ButtonClick", "ButtonClick 시작 : " + getButton.getText().toString() + " 버튼이 클릭되었습니다." );
        Log.d(">>>>>ButtonClick", "resultNumber = " + resultNumber);

        switch (view.getId()) {

            case R.id.all_clear_button:
                isFirstInput = true;
                resultNumber = 0;
                operator = '+';
                resultText.setTextColor(0xFF666666);
                resultText.setText(String.valueOf(resultNumber));
                break;

            case R.id.addition_button :
            case R.id.subtraction_button :
            case R.id.division_button :
            case R.id.multiply_button :
                int lastNum = Integer.parseInt(resultText.getText().toString());
                if(operator == '+') {
                    resultNumber = resultNumber + lastNum;
                }
                else if(operator == '-') {
                    resultNumber = resultNumber - lastNum;
                }
                else if(operator == '/') {
                    resultNumber = resultNumber / lastNum;
                }
                else if(operator == '*') {
                    resultNumber = resultNumber * lastNum;
                }

                operator = getButton.getText().toString().charAt(0);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
                Log.d(">>>>>ButtonClick", "add resultNumber = " + resultNumber);

                break;

            case R.id.result_button :
                int lastNum2 = Integer.parseInt(resultText.getText().toString());
                if(operator == '+') {
                    resultNumber = resultNumber + lastNum2;
                }
                else if(operator == '-') {
                    resultNumber = resultNumber - lastNum2;
                }
                else if(operator == '/') {
                    resultNumber = resultNumber / lastNum2;
                }
                else if(operator == '*') {
                    resultNumber = resultNumber * lastNum2;
                }

                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
                Log.d(">>>>>ButtonClick", "add resultNumber = " + resultNumber);

                break;

            case R.id.num_0_button:
            case R.id.num_1_button:
            case R.id.num_3_button:
            case R.id.num_4_button:
            case R.id.num_5_button:
            case R.id.num_6_button:
            case R.id.num_7_button:
            case R.id.num_8_button:
            case R.id.num_9_button:
                if(isFirstInput) {
                    resultText.setTextColor(0xFF000000);
                    resultText.setText(getButton.getText().toString());
                    isFirstInput = false;
                }
                else {
                    resultText.append(getButton.getText().toString());
                }
                break;

            default:
                //Toast.makeText(getApplicationContext(), getButton.getText().toString() + " 버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show();
                Log.e(">>>>>ButtonClick", "default " + getButton.getText().toString()+ " 버튼이 클릭되었습니다." );
                break;
        }

        /*
        if(view.getId() >= R.id.num_0_button && view.getId() <= R.id.num_9_button) {
            if(isFirstInput) {
                resultText.setTextColor(0xFF000000);
                resultText.setText(getButton.getText().toString());
                isFirstInput = false;
            }
            else {
                resultText.append(getButton.getText().toString());
            }

        }
        else {

        }
        */

    }

    /*
    @Override
    public void onClick(View v) {

    }
    */
}
