package com.cookandroid.moodlet;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;
import java.io.InputStream;
import java.util.Calendar;

public class SettingActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    private ImageView profile;
    private Switch swalert, swword;
    private TimePicker picker;
    private LinearLayout layoutalert;
    private Button btnalert;
    private AlarmManager am;
    PendingIntent sender;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swalert = (Switch)findViewById(R.id.swalert);
        swword = (Switch)findViewById(R.id.swword);
        layoutalert=(LinearLayout)findViewById(R.id.layoutalert);
        btnalert=(Button)findViewById(R.id.btnalert);
        picker = (TimePicker)findViewById(R.id.timePicker);

        // ---액션바 숨기기---
        ActionBar ab = getSupportActionBar() ;
        ab.hide();

        // ---알림---
        swalert.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                // 스위치 버튼이 체크되었는지 검사하여 텍스트뷰에 각 경우에 맞게 출력합니다.
                if (isChecked) {
                    layoutalert.setVisibility(View.VISIBLE);
                    picker.setIs24HourView(true);

                    btnalert.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            final int hour = picker.getHour();
                            final int minute = picker.getMinute();

                            am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

                            Intent intent = new Intent(SettingActivity.this, broadcast.class);
                            sender = PendingIntent.getBroadcast(SettingActivity.this, 0, intent, 0);

                            Calendar calendar = Calendar.getInstance();
                            //알람시간 calendar에 set해주기
                            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), hour, minute, 0);

                            //알람 예약
                            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
                            am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 24*60*60*1000, sender);
                            Toast.makeText(getApplicationContext(),"매일 "+ Integer.toString(calendar.get(calendar.HOUR_OF_DAY))+"시 "+Integer.toString(calendar.get(calendar.MINUTE))+"분에 알림 설정",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else{
                    layoutalert.setVisibility(View.GONE);
                    am.cancel(sender);
                    Toast.makeText(getApplicationContext(),"알림 취소",Toast.LENGTH_LONG).show();
                }
            }
        });

        // ---사진 가져오기---
        profile = (ImageView)findViewById(R.id.profile);

        profile.setBackground(new ShapeDrawable(new OvalShape()));
        profile.setClipToOutline(true);

        profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                try{
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    profile.setImageBitmap(img);
                }catch(Exception e)
                {

                }
            }
            else if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }
}
