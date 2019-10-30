package com.cookandroid.imgbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch agree;
    RadioGroup rg1;
    RadioButton r1, r2, r3;
    TextView t1;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("골라골라 단 돈 만원");

        agree = (Switch) findViewById(R.id.agree);

        rg1 = (RadioGroup) findViewById(R.id.rg1);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);

        t1 = (TextView) findViewById(R.id.t1);
        img1 = (ImageView) findViewById(R.id.img1);

        agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(agree.isChecked() == true){
                    rg1.setVisibility(View.VISIBLE);
                    t1.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);
                } else
                {
                    rg1.setVisibility(View.INVISIBLE);
                    t1.setVisibility(View.INVISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                }
            }
        });

        r1.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(r1.isChecked() == true){
                    img1.setImageResource(R.drawable.exo1);
                }
            }
        }));

        r2.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(r2.isChecked() == true){
                    img1.setImageResource(R.drawable.exo2);
                }
            }
        }));

        r3.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(r3.isChecked() == true){
                    img1.setImageResource(R.drawable.exo3);
                }
            }
        }));
    }
}
