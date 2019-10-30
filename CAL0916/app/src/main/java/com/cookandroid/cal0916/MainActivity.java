package com.cookandroid.cal0916;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2;
    Button plus, minus, multiple, division;
    TextView textR, qwer;
    String num1, num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기");

        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);

        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        multiple = (Button) findViewById(R.id.multiple);
        division = (Button) findViewById(R.id.division);

        textR = (TextView) findViewById(R.id.textR);
        qwer = (TextView) findViewById(R.id.qwer);

        plus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = input1.getText().toString();
                num2 = input2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textR.setText("결과 : " + result.toString());
                qwer.setText("+");
                return  false;
            }
        });

        minus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = input1.getText().toString();
                num2 = input2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textR.setText("결과 : " + result.toString());
                qwer.setText("－");
                return  false;
            }
        });

        multiple.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = input1.getText().toString();
                num2 = input2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textR.setText("결과 : " + result.toString());
                qwer.setText("×");
                return  false;
            }
        });

        division.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = input1.getText().toString();
                num2 = input2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textR.setText("결과 : " + result.toString());
                qwer.setText("÷");
                return  false;
            }
        });
    }
}
