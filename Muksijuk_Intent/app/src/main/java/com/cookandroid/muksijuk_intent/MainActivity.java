package com.cookandroid.muksijuk_intent;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button telbtn, webbtn, goobtn, cambtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telbtn=(Button)findViewById(R.id.telbtn);
        webbtn=(Button)findViewById(R.id.webbtn);
        goobtn=(Button)findViewById(R.id.goobtn);
        cambtn=(Button)findViewById(R.id.cambtn);

        telbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                // 묵시적(암시적) 인텐트를 사용
                Intent  telIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01089603471"));
                startActivity(telIntent);
            }
        });

        webbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Uri webUri = Uri.parse("https://www.gsm.hs.kr");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
                startActivity(webIntent);
            }
        });

        goobtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Uri mapUri = Uri.parse("https://maps.google.com/maps?q"+"광주소프트웨어마이스터고");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                startActivity(mapIntent);
            }
        });

        cambtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivity(camIntent);
            }
        });
    }
}
