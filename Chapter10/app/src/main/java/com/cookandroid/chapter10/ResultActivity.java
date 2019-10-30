package com.cookandroid.chapter10;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("결과 액티비티");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("Count");

        TextView tv[] = new TextView[voteResult.length];
        Integer tvId[] = {R.id.choice1, R.id.choice2, R.id.choice3, R.id.choice4, R.id.choice5};

        for(int i = 0; i < tvId.length; i++){
            // 내부클래스가 없으므로 final int index X
            tv[i] = (TextView)findViewById(tvId[i]);
            String str = String.valueOf(voteResult[i]);
            tv[i].setText(str);
        }
    }
}
