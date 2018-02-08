package org.writing.jumpstart.jumpstart2017;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class VideoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        WebView vimeoVid = (WebView) findViewById(R.id.webView);
        vimeoVid.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = vimeoVid.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setDomStorageEnabled(true);

        vimeoVid.loadUrl("//player.vimeo.com/video/114695683");
    }




    //WebSettings settings = vimeoVid.getSettings();

    //settings.setJavaScriptEnabled(true);



}