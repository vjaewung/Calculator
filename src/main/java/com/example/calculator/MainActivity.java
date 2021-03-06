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

    final String CLEARED_INPUT_VALUE = "0";

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
        //Log.e(">>>>>ButtonClick", "ButtonClick 시작 : " + getButton.getText().toString() + " 버튼이 클릭되었습니다." );
        //Log.d(">>>>>ButtonClick", "resultNumber = " + resultNumber);

        switch (view.getId()) {

            case R.id.all_clear_button :
                resultNumber = 0;
                operator = '+';
                setClearText("0");
                break;

            case R.id.clear_entry_button :
                setClearText("0");
                break;

            case R.id.back_space_button :
                isFirstInput = true;
                if(resultText.getText().toString().length() > 1) {
                    String getResultText = resultText.getText().toString();
                    String subtractedString = getResultText.substring(0, getResultText.length() - 1);
                    resultText.setText(subtractedString);
                }
                else {
                    setClearText("0");

                }
                break;

            case R.id.decimal_button :
                Log.e(">>>>>ButtonClick",  getButton.getText().toString() + " 버튼이 클릭되었습니다." );

                break;

            case R.id.addition_button :
            case R.id.subtraction_button :
            case R.id.division_button :
            case R.id.multiply_button :
                resultNumber = intCalc(resultNumber, Integer.parseInt(resultText.getText().toString()), operator);

                /*
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
                */
                operator = getButton.getText().toString().charAt(0);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
                Log.d(">>>>>ButtonClick", "add resultNumber = " + resultNumber);

                break;

            case R.id.result_button :

                resultNumber = intCalc(resultNumber, Integer.parseInt(resultText.getText().toString()), operator);
                /*
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
                */

                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
                Log.d(">>>>>ButtonClick", "add resultNumber = " + resultNumber);

                break;
            /*
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
            */
            default:
                Toast.makeText(getApplicationContext(), getButton.getText().toString() + " 버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show();
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

    public void numButtonClick(View view) {

        Button getButton = findViewById(view.getId());

        if(isFirstInput) {
            resultText.setTextColor(0xFF000000);
            resultText.setText(getButton.getText().toString());
            isFirstInput = false;
        }
        else {
            resultText.append(getButton.getText().toString());
        }
    }

    public void setClearText(String clearText) {
        isFirstInput = true;
        resultText.setTextColor(0xFF666666);
        resultText.setText(clearText);
    }

    public int intCalc(int resultNumber, int lastNum, char operator) {

        if(operator == '+') {
            resultNumber += lastNum;
        }
        else if(operator == '-') {
            resultNumber -= lastNum;
        }
        else if(operator == '/') {
            resultNumber /= lastNum;
        }
        else if(operator == '*') {
            resultNumber *= lastNum;
        }

        return resultNumber;
    }

    public void clickOperator(View view) {

        Button getButton = findViewById(view.getId());

        if(view.getId() == R.id.result_button) {
            resultNumber = intCalc(resultNumber, Integer.parseInt(resultText.getText().toString()), operator);
            operator = getButton.getText().toString().charAt(0);
            resultText.setText(String.valueOf(resultNumber));
            isFirstInput = true;
        }
        else {
            resultNumber = intCalc(resultNumber, Integer.parseInt(resultText.getText().toString()), operator);
            operator = getButton.getText().toString().charAt(0);
            resultText.setText(String.valueOf(resultNumber));
            isFirstInput = true;
        }

        Log.d(">>>>>ButtonClick", "add resultNumber = " + resultNumber);

    }

    /*
    @Override
    public void onClick(View v) {

    }
    */
}
