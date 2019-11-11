package com.cookandroid.appp_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends Activity {

    TextView data3_1, data3_2;
    EditText intent3;
    Button returnBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        data3_1 = (TextView)findViewById(R.id.data3_1);
        data3_2 = (TextView)findViewById(R.id.data3_2);
        intent3 = (EditText)findViewById(R.id.intent3);
        returnBtn3= (Button)findViewById(R.id.returnBtn3);

        Intent inIntent = getIntent();
        final String word1 = inIntent.getStringExtra("word1");
        final String word2 = inIntent.getStringExtra("word2");
        data3_1.setText(word1);
        data3_2.setText(word2);

        returnBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent(getApplicationContext(),MainActivity.class);
                String word3 = intent3.getText().toString();
                int lastIndex = word2.length()-1; //마지막 문자에 대한 인덱스
                char lastChar = word2.charAt(lastIndex); //마지막 문자

                if(lastChar == word3.charAt(0)){
                    returnIntent.putExtra("word3", word3);

                    setResult(RESULT_OK, returnIntent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "끝말잇기 실패! 다시 입력하세요.", Toast.LENGTH_LONG).show();
                    intent3.setText("");
                }
            }
        });
    }
}
