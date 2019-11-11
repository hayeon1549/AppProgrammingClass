package com.cookandroid.dualintent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);
        sendBtn = (Button)findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(num1.getText().toString());
                int n2 = Integer.parseInt(num2.getText().toString());

                // 1. putData
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("putHap",n1+n2);
                // 2. 주고받기를 할 목적으로 Intent를 사용하려면
                // startActivity + ForResult 메소드로 명명하여야 함.
                // 첫 번째 인자는 intent, 두번 째 인자는 돌려받을 값이 있을 경우 0 이상의 수
                startActivityForResult(intent,0);
            }
        });
    }

    // 7. MainActivity는 onActivityResult() 메소드를
    // 오버라이딩하여 메소드 안에서 getXXXExtra()로 데이터 사용.
    // 오버라이딩 된 메소드에서의 입력 읹자들(resultCode, data)를 사용
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            String str = data.getStringExtra("outData");
            Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
        }
    }
}
