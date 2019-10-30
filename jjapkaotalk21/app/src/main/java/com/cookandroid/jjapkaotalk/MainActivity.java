package com.cookandroid.jjapkaotalk;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    LinearLayout menuLayout, doyoungLayout;
    TextView name, title, dysang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuLayout = (LinearLayout)findViewById(R.id.baseLayout);
        doyoungLayout = (LinearLayout)findViewById(R.id.friend);
        name =(TextView)findViewById(R.id.friendName);
        title =(TextView)findViewById(R.id.title);
        dysang  = (TextView)findViewById(R.id.dysang);

        registerForContextMenu(doyoungLayout);
    }

    // 메인 메뉴 연결
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater MInf = getMenuInflater();
        MInf.inflate(R.menu.menu, menu);
        return true;
    }

    // 김도영 메뉴 연결
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater contextMInf = getMenuInflater();
        if(v == doyoungLayout){
            contextMInf.inflate(R.menu.menu2, menu);
        }
    }

    // 김도영 메뉴 구동
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case R.id.btn1:
                // 커스텀한 대화상자를 만들어보기 (xml 레이아웃 파일을 팝업처럼 띄우기)
                // sagmeLayout ~  infLating (뷰에 대한 객체화)
                final View sangmeView = (View)View.inflate(MainActivity.this, R.layout.sangme, null);
                AlertDialog.Builder changeDialog = new AlertDialog.Builder(MainActivity.this);
                // AlertDialog의 메소드 중 setView();
                changeDialog.setView(sangmeView);
                changeDialog.setNegativeButton("취소", null);
                changeDialog.setPositiveButton("변경", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 우리가 가져오고 싶은 위젯 EditText. 이것은 sangme에 있음.
                        EditText et = (EditText)sangmeView.findViewById(R.id.sangme);
                        dysang.setText(et.getText().toString());
                    }
                });
                changeDialog.show();
                return true;
            case R.id.btn2:
                // 팝업창처럼 사용 가능한 '대화상자'를 만들어보자
                AlertDialog.Builder delDialog =
                        new AlertDialog.Builder(MainActivity.this);
                delDialog.setTitle("대화상자의 이름");
                delDialog.setMessage("진짜로 손절할거야?._.");
                delDialog.setNegativeButton("손절 안 할게",null);
                delDialog.setPositiveButton("응 너 손절", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        doyoungLayout.setVisibility(View.GONE);
                    }
                });
                delDialog.show();
                return true;
        }
        return  false;
    }
}