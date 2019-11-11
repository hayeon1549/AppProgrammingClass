package com.cookandroid.appp_test;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    Button btn1;
    EditText  intent1;
    TextView startword, firstword, secondword, thirdword;
    LinearLayout layoutVi;
    String word1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);
        intent1 = (EditText)findViewById(R.id.intent1);

        startword = (TextView)findViewById(R.id.startword);
        final String words[] = {"노트북", "마우스", "컴퓨터", "이어폰", "키보드", "모니터", "충전기", "아이폰", "갤럭시", "애플", "안드로이드", "구글"};
        final int index = random.nextInt(words.length);
        final String word0 = words[index];
        startword.setText(word0);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word1 = intent1.getText().toString();

                int lastIndex = word0.length()-1; //마지막 문자에 대한 인덱스
                char lastChar = word0.charAt(lastIndex); //마지막 문자

                if(lastChar == word1.charAt(0)) {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("word1", word1);
                    startActivityForResult(intent, 0);
                }
                else{
                    Toast.makeText(getApplicationContext(),"끝말잇기 실패! 다시 입력하세요.",Toast.LENGTH_LONG).show();
                    intent1.setText("");
                }
            }
        });
    }

    // 7. MainActivity는 onActivityResult() 메소드를
    // 오버라이딩하여 메소드 안에서 getXXXExtra()로 데이터 사용.
    // 오버라이딩 된 메소드에서의 입력 읹자들(resultCode, data)를 사용
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            layoutVi = (LinearLayout)findViewById(R.id.layoutVi);
            layoutVi.setVisibility(View.VISIBLE);

            firstword = (TextView)findViewById(R.id.firstword);
            secondword = (TextView)findViewById(R.id.secondword);
            thirdword = (TextView)findViewById(R.id.thirdword);

            String word2 = data.getStringExtra("word2");
            String word3 = data.getStringExtra("word3");
            firstword.setText(word1);
            intent1.setText("");

            if(word2.equals("")){
                secondword.setText("거부");
                thirdword.setText("차례가 돌아오지 않음");
            }
            else{
                secondword.setText(word2);
                thirdword.setText(word3);
            }
        }
    }
}
