package com.cookandroid.appp_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

    TextView data2;
    EditText intent2;
    Button btn2, returnBtn2;
    String word3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        data2 = (TextView)findViewById(R.id.data2);
        intent2 = (EditText)findViewById(R.id.intent2);
        btn2 = (Button)findViewById(R.id.btn2);
        returnBtn2= (Button)findViewById(R.id.returnBtn2);

        Intent inIntent = getIntent();
        final String word1 = inIntent.getStringExtra("word1");
        data2.setText(word1);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word2 = intent2.getText().toString();

                int lastIndex = word1.length()-1; //마지막 문자에 대한 인덱스
                char lastChar = word1.charAt(lastIndex); //마지막 문자

                if(lastChar == word2.charAt(0)){
                    Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                    intent.putExtra("word1",word1);
                    intent.putExtra("word2",word2);
                    startActivityForResult(intent,0);
                }
                else{
                    Toast.makeText(getApplicationContext(),"끝말잇기 실패! 다시 입력하세요.",Toast.LENGTH_LONG).show();
                    intent2.setText("");
                }
            }
        });

        returnBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent(getApplicationContext(),MainActivity.class);
                String word2 = intent2.getText().toString();
                String returnText = returnBtn2.getText().toString();
                if(returnText.equals("이전 친구의 단어 거부"))
                    word2="";

                returnIntent.putExtra("word2", word2);
                returnIntent.putExtra("word3", word3);

                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            word3 = data.getStringExtra("word3");
            Toast.makeText(getApplicationContext(),word3,Toast.LENGTH_LONG).show();
            returnBtn2.setText("이전 친구에게 단어 전달");
        }
    }
}
