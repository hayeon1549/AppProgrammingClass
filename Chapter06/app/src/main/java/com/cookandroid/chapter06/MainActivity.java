package com.cookandroid.chapter06;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.ViewFlipper;

/*복사용 MainActivity Class 틀 */
/*public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}*/

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button move, back;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        url = (EditText)findViewById(R.id.urlArea);
        move = (Button)findViewById(R.id.move);
        back = (Button)findViewById(R.id.back);
        webView = (WebView)findViewById(R.id.webArea);

        // 2. (1)에서 생성한 클래스를 생성하여 webView에 연결
        webView.setWebViewClient(new WebViewTest());

        //( (부가기능)
        // WebSettings 클래스에 웹뷰의 설정값을 가져오고 여러 기능을 추가할 수 있다.
        WebSettings webSet = webView.getSettings();
        webSet.setBuiltInZoomControls(true);

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(url.getText().toString());
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.goBack();
            }
        });
    }

    // 1. 클래스 생성 WevViewClient를 상속받는.
    class WebViewTest extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
        //WevViewClient 클래스를 상속받고 이 클래스에서 필요한 메소드를 오버라이딩해서 사용하자.
    }
}

//TabHost ~ 탭 기능이 구현되어 있는 클래스 포함 extends TabActivity
//약한 경고를
/*@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);

        // 1. XML에서 생성한 탭 호스트
        //  (@android:id/tabhost로 id를 지정한 탭 호스트)를 가져온다.
        TabHost tab = getTabHost();

        //2. 탭 위젯에 필요한 내용들을 등록한다.
        // 아래의 세 줄을 반복하여 필요한 만큼 등록한다.
        TabHost.TabSpec redTab = tab.newTabSpec("red").setIndicator("빨간탭");
        redTab.setContent(R.id.tab1);
        tab.addTab(redTab);

        TabHost.TabSpec greenTab = tab.newTabSpec("green").setIndicator("초록탭");
        greenTab.setContent(R.id.tab2);
        tab.addTab(greenTab);

        TabHost.TabSpec blueTab = tab.newTabSpec("blue").setIndicator("파란탭");
        blueTab.setContent(R.id.tab3);
        tab.addTab(blueTab);

        // 탭호스트를 액티비티에 띄우기 위한 코드
        tab.setCurrentTab(0);
    }
}*/

//ViewFlipper의 기능을 작동시키기 위한 Java 부분
/*public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewflipper);

        btn1=(Button)findViewById(R.id.preBtn);
        btn2=(Button)findViewById(R.id.nextBtn);
        vf=(ViewFlipper)findViewById(R.id.vf);

        // < 버튼 클릭에 대한 기능 정의
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //vf.showPrevious();
                vf.setFlipInterval(250);
                vf.startFlipping();
            }
        });

        // <>버튼 클릭에 대한 기능 정의
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //vf.showNext();
                vf.stopFlipping();
            }
        });
    }
}*/
