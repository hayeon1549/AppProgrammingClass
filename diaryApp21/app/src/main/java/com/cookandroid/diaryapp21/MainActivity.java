package com.cookandroid.diaryapp21;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.WriteAbortedException;

public class MainActivity extends AppCompatActivity {

    // 위젯의 배치 순서대로 변수 선언
    EditText year, month, day;
    Button writeMode, readMode;

    // inputDiary, writeOrInsert는 writeView에 속한 위젯들
    LinearLayout writeView;
    EditText inputDiary;
    Button writeOrInsert;

    // outputDiary는 readView에 속한 위젯들
    LinearLayout readView;
    TextView outputDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        year = (EditText) findViewById(R.id.year);
        month = (EditText) findViewById(R.id.month);
        day = (EditText) findViewById(R.id.day);

        writeMode = (Button) findViewById(R.id.writeMode);
        readMode = (Button) findViewById(R.id.readMode);

        writeView = (LinearLayout) findViewById(R.id.writeView);
        inputDiary = (EditText) findViewById(R.id.inputDiary);
        writeOrInsert = (Button) findViewById(R.id.writeOrInsert);

        readView = (LinearLayout) findViewById(R.id.readView);
        outputDiary = (TextView) findViewById(R.id.outputDiary);

        writeMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 날짜가 충분하게 채워지지 않은 경우
                if (!isInputDate()) {
                    Toast.makeText(MainActivity.this, "년, 월, 일을 채워주세요", Toast.LENGTH_LONG).show();
                } else {
                    // writeView만 화면에 표시되게 한다.
                    writeView.setVisibility(View.VISIBLE);
                    readView.setVisibility(View.GONE);

                    String fileName = year.getText().toString() + month.getText().toString() + day.getText().toString();

                    inputDiary.setText("");

                    FileInputStream inFS = null;
                    try {
                        inFS = openFileInput(fileName);
                        byte[] txt = new byte[3000];
                        inFS.read(txt);
                        String str = new String(txt);
                        inputDiary.setText(str);
                        inFS.close();
                    } catch (FileNotFoundException e) {
                    } catch (IOException e) {
                    }

                    writeOrInsert.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // 이 부분에 파일을 생성하는 내용이 들어가겠죠?
                            // 파일 입출력을 위해서는 FileInput(Output) Stream이라는 클래스를 사용

                            try {
                                String fileName = year.getText().toString() + month.getText().toString() + day.getText().toString();
                                FileOutputStream outFS = openFileOutput(fileName, MODE_PRIVATE);

                                if (inputDiary.getText().toString().equals("")) {
                                    Toast.makeText(MainActivity.this, "입력된 내용이 없습니다.", Toast.LENGTH_SHORT).show();
                                }
                                String str = inputDiary.getText().toString();
                                outFS.write(str.getBytes());
                                outFS.close();

                            } catch (java.io.IOException e) {
                            }
                        }
                    });
                }
            }
        });


        readMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 날짜가 충분하게 채워지지 않은 경우
                if (!isInputDate()) {
                    Toast.makeText(MainActivity.this, "년, 월, 일을 채워주세요", Toast.LENGTH_LONG).show();
                } else {
                    // readView만 화면에 표시되게 한다.
                    writeView.setVisibility(View.GONE);
                    readView.setVisibility(View.VISIBLE);
                    outputDiary.setVisibility(View.INVISIBLE);

                    String fileName = year.getText().toString() + month.getText().toString() + day.getText().toString();

                    try {
                        FileInputStream inFS = openFileInput(fileName);
                        byte[] txt = new byte[3000];
                        inFS.read(txt);
                        String str = new String(txt);
                        outputDiary.setVisibility(View.VISIBLE);
                        outputDiary.setText(str);
                        inFS.close();
                    } catch (FileNotFoundException e) {
                    } catch (IOException e) {
                    }
                }
            }
        });
    }

    boolean isInputDate() {
        // 년, 월, 일 EditText가 모두 작성된 경우에만 true 반환
        boolean a = year.getText().toString().equals("");
        boolean b = month.getText().toString().equals("");
        boolean c = day.getText().toString().equals("");
        return (!a) && (!b) && (!c);
    }
}