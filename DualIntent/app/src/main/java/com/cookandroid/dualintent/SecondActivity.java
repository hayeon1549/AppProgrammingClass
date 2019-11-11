package com.cookandroid.dualintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    TextView tv;
    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2nd);

        tv = (TextView)findViewById(R.id.data);
        et = (EditText)findViewById(R.id.intent2nd);
        btn = (Button)findViewById(R.id.returnBtn);

        Intent inIntent = getIntent();
        final int hap = inIntent.getIntExtra("putHap",0);
        tv.setText(Integer.toString(hap));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 4~ 6 새로운 인텐트에 담아서 setResult라는 메소드로 전송
                Intent returnIntent = new Intent(getApplicationContext(),MainActivity.class);
                String str = et.getText().toString();
                returnIntent.putExtra("outData",str);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
