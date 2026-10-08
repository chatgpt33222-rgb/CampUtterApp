package com.camputter.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView webView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        webView = new WebView(this);
        webView.setBackgroundColor(Color.rgb(244,247,251));
        setContentView(webView);
        WebSettings s=webView.getSettings();
        s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setDatabaseEnabled(true);
        s.setLoadsImagesAutomatically(true); s.setAllowFileAccess(true); s.setAllowContentAccess(true);
        s.setAllowFileAccessFromFileURLs(true); s.setAllowUniversalAccessFromFileURLs(true);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient(){
            @Override public boolean shouldOverrideUrlLoading(WebView v, WebResourceRequest r){
                Uri u=r.getUrl(); String sc=u.getScheme();
                if("http".equalsIgnoreCase(sc)||"https".equalsIgnoreCase(sc)||"file".equalsIgnoreCase(sc)) return false;
                try{startActivity(new Intent(Intent.ACTION_VIEW,u));}catch(Exception ignored){}
                return true;
            }
        });
        webView.loadUrl("file:///android_asset/index.html");
    }
    @Override public void onBackPressed(){ if(webView.canGoBack()) webView.goBack(); else super.onBackPressed(); }
}
