package com.example.jinpu.myfirsth5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webView = new WebView(this);

        webView.getSettings().setJavaScriptEnabled(true);

        //重写shouldOverrideUrlLoading方法使得要加载的网页在本webview中打开，而不是使用浏览器打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        try{
            webView.loadUrl("file:///android_asset/htmldir/rotate.html");
        }catch (Exception e){
            e.printStackTrace();
        }

        webView.setWebChromeClient(new WebChromeClient());
        setContentView(webView);

    }
}
