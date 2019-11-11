package com.cookandroid.adapterviewexercise;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.cookandroid.adapterviewexercise.R.id.add;
import static com.cookandroid.adapterviewexercise.R.id.addListViewBtn;

public class DynamicListView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_listview);
        setTitle("동적 리스트 뷰 테스트");

        // (자료구조에서 배운) ArrayList를 사용하여 add, remove 하여 리스트뷰를 동적으로 사용 가능
        // 사용자가 수정 불가능한 정해진 정적 리스트뷰를 만들고 싶다면 ArrayList 대신 String[] 배열을 사용하면 됨.

        final ArrayList<String> list = new ArrayList<String>();

        ListView lv = (ListView)findViewById(R.id.listView);

        // 입력하는 세 가지 피라매터 (입력 인자
        // 1. 보통 this 사용
        // 2. 리스트 뷰의 형식
        // 3. 리스트뷰에 적용할 내용들 (ArrayList)
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        // listView에 어댑터를 사용하겠다고 말함
        lv.setAdapter(adapter);

        final EditText et = (EditText)findViewById(R.id.addItemText);
        Button btn = (Button)findViewById(addListViewBtn);

        // 리스트뷰를 동적으로 구성, ArrayList의 add() 메소드 사용
        // 그리고 어댑터의 notifyDataSetChanged() 메소드로 갱신
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(et.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        // inItemClick의 입력 인자가 무려 4개
        // 어댑터뷰, 뷰, i(리스트의 위치값), l(id)
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "리스트뷰의 " + (i + 1) + "번쨰 클릭함", Toast.LENGTH_LONG).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "리스트뷰의 " + (i + 1) + "번쨰 item 제거됨", Toast.LENGTH_LONG).show();
                list.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
