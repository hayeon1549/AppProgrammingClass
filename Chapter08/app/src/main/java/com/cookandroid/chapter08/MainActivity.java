package com.cookandroid.chapter08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText inputArea;
    Button write, read;
    TextView outputArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputArea = (EditText)findViewById(R.id.inputArea);
        write = (Button)findViewById(R.id.write);
        read = (Button)findViewById(R.id.read);
        outputArea = (TextView)findViewById(R.id.outputArea);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 이 부분에 파일을 생성하는 내용이 들어가겠죠?
                // 파일 입출력을 위해서는 FileInput(Output) Stream이라는 클래스를 사용

                try {
                    FileOutputStream outFS = openFileOutput("file.txt", MODE_PRIVATE); //private 내용 덮어쓰기, append 내용 이어쓰기
                    if(inputArea.getText().toString() == ""){
                        Toast.makeText(MainActivity.this, "입력된 내용이 없습니다.", Toast.LENGTH_SHORT);
                        return;
                    }
                    String str = inputArea.getText().toString();
                    outFS.write(str.getBytes());
                    outFS.close();

                } catch (java.io.IOException e) {
                    // file 못 찾았을 때
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inFS = openFileInput("file.txt");

                    //  버퍼가 처리하는 방식과 비슷
                    // 한 번에 읽어들일 수 있는 최대한의 byte 수 지정
                    // 작은 byte 단위로 나눠 읽어들일 경우 글자 깨짐이 발생할 수 있다. (한글)
                    // file 저장 경로 data/data/패키지명/files : 폴더
                    byte[] txt = new byte[3000];
                    inFS.read(txt);
                    String str = new String(txt);
                    outputArea.setText(str);
                    inFS.close();

                } catch (FileNotFoundException e) {
                } catch (IOException e) {
                }
            }
        });
    }
}
