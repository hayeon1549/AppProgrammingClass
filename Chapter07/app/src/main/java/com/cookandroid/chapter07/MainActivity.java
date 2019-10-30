package com.cookandroid.chapter07;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

// 메뉴를 포함시키기 위해 Java 코딩에서 필요한 것
// 1. onCreateOptionsMenu() 메소드 ~ 오버라이딩
// 2. onOptionsItemSelected() 메소드 ~ 오버라이딩

// <실습2> 컨텍스트 메뉴 만들기
// 1. onCreate() 내부에서, registerForContext() 메소드로 위젯 등록
// 2. onCreateContextMenu() 메소드를 ~오버라이딩
// 3. onContextItemSelected() 메소드 ~ 오버라이딩
public class MainActivity extends AppCompatActivity {

    // 메뉴의 각 기능들을 선택했을 때 연동될 수 있도록...
    LinearLayout menuLayout;
    TextView menuTextView;
    Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuLayout = (LinearLayout)findViewById(R.id.baseLayout);
        menuTextView = (TextView)findViewById(R.id.textView);
        menuButton = (Button)findViewById(R.id.button);

        registerForContextMenu(menuButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // 자동완성된 내용을 아래와 같이 바꿔주세요.
        super.onCreateOptionsMenu(menu);

        // 인플레이터(Inflater) : 정적으로 존재하는 XML 파일을 Java 코드에서 사용
        //ManuInflater, LayoutInflater 등 이 존재
        MenuInflater MInf = getMenuInflater();

        //inflater ~ 부풀리기(menu XML 파일을 연결해줌)
        MInf.inflate(R.menu.menu01, menu);
        return true;
    }

    // 2. 각 메뉴들의 기능을 부여 하기위해서 onOptionsItemSelected() 메소드 오버라이딩
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // switch - case 문을 사용하여 메뉴들의 기능을 부여
        // switch (item.getItemId())
        switch (item.getItemId()){
            case R.id.setBlack:
                menuLayout.setBackgroundColor(Color.BLACK);
                return true;
            case R.id.setYourColor:
                menuLayout.setBackgroundColor(Color.rgb(221,221,225));
                return true;
            case R.id.changeTV:
                menuTextView.setText(("텍스트뷰의 내용을 바꿨다."));
                return true;
            case R.id.changeBTN:
                menuButton.setRotation(30);
                //  Toast라는 것을 사용하자.
                // 애플리케이션에서 간단한 알림을 전하고자 할 때
                // 디버깅 할 떄 쓰기도 함
                Toast msg = Toast.makeText(MainActivity.this,
                        "버튼메뉴가 눌렸음", Toast.LENGTH_LONG);
                msg.show();
                return true;
        }
        return false;
    }

    // <실습2>의 2. onCreateContextMenu() 메소드 오버라이딩
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater contextMInf = getMenuInflater();
        if(v == menuButton){
            contextMInf.inflate(R.menu.menu02, menu);
        }
    }

    // <실습2> 2. onCreateContextMenu()
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case R.id.btn1:
                Toast.makeText(MainActivity.this,
                        "컨텍스트 메뉴1과 상호작용",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.btn2:
                Toast.makeText(MainActivity.this,
                        "컨텍스트 메뉴2와 상호작용",
                        Toast.LENGTH_SHORT).show();
                return true;
        }
        return  false;
    }
}

//// MainActivity 기본 형태 복사본
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}