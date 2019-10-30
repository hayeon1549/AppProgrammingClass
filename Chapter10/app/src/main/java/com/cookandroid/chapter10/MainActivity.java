package com.cookandroid.chapter10;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("정답률 45%를 자랑하는 마의 2번 문제");

        final int voteCount[] = new int[5];
        for(int i = 0; i < voteCount.length; i++)
            voteCount[i] = 0;

        Button btn[] = new Button[5];
        Integer btnId[] = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5};
        Button result; // 결과보기 버튼 (for문 X)

        for(int i = 0; i < btnId.length; i++){
            final int index; // new View,OnClickListener는 다른 클래스이기 때문에 i가 접근하지 못함 -> final 선언을 통해 공유 변수 선언
            index = i;
            btn[index] = (Button)findViewById(btnId[index]);
            btn[index].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), (index+1) + "번을 찍음", Toast.LENGTH_SHORT).show();
                }
            });
        }

        result = (Button)findViewById(R.id.result);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

                // 액티비티간 데이터를 주고 받기 위해 사용하는 메소드
                // putExtra() 에 박스포장을 해서 넘겨줄 수 있다.
                intent.putExtra("Count", voteCount/*int 배열*/);
                startActivity(intent);
            }
        });
    }
}

//public class MainActivity extends AppCompatActivity {
//
//    Button btn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        btn = (Button)findViewById(R.id.goToSecondActivity);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 새로운 액티비티를 띄어주기 위한 코드
//                // Intent라는 것을 활용 - 4대 컴포넌트(액티비티, 서비스, 콘텐트프로바이더, 브로드리시버)
//                // 이 서로 데이터를 주고받기 위해 사용하는 메시지 객체
//                // Intent를 생성하기 위해 필요한 두개의 입력인자 : getApplicationContext(),
//                // Context = 어떤 Activity나 application 인자를 '구별'하는 정보
//                // 2. 인텐트에 포함시킬 액티비티
//                //   ava'파일명 '.class
//
//                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//}
