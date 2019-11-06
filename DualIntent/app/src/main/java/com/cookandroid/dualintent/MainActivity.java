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

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("putHap",n1+n2);
                // 양방향 액티비티 위해서 메소드가 달라짐
                startActivityForResult(intent,0);
            }
        });
    }

    // SecondActivity에서 넘겨준 내용을 받기 위해 메소드 오버라이딩


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            String str = data.getStringExtra("outData");
            Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
        }
    }
}
