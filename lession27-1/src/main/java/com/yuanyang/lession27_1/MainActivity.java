package com.yuanyang.lession27_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(R.id.webView);
        String data = "<html>\n" +
                "    <head>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "        <title>Insert title here</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <a href=\"yuanyang://test.com\">打开app</a><br/>\n" +
                "    </body>\n" +
                "</html>";
        webView.loadData(data, "text/html", "UTF-8");
    }
}
