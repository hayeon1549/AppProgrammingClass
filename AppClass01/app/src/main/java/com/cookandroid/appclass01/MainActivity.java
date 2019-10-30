package com.cookandroid.appclass01;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 1. xml 에서 선언된 TextView를 연결해주기 위한 변수 선언

    TextView tv1, tv2, tv3, tv4;
    Button bt1;
 void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    @Override
    protected
        setContentView(R.layout.activity_main);

        // 2. 버튼과 변수를 연결
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        // 왼쪽은 자바에서 설정한 변수명, 오른쪽은 xml에서 정
     //        tv4 = (TextView)findViewById(R.id.tv4);
     //        bt1 = (Button)findViewById(R.id.click);의한 변수명

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setTextColor(Color.YELLOW);
                tv2.setRotation(45);
                tv3.setGravity(10);
                tv4.setBackgroundColor(Color.BLUE);
            }
        });
    }
}
