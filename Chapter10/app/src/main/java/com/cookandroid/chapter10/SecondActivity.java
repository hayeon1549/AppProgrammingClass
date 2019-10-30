package com.cookandroid.chapter10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;

// 새로운 액티비티를 사용하기 위해서
// 1. XML 코드가 필요 (틀)
// 2. Java 클래스가 필요 (액티비티 활성화)
public class SecondActivity extends Activity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn = (Button)findViewById(R.id.finishBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
