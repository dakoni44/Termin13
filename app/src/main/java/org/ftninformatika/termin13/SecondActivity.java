package org.ftninformatika.termin13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {

    private String url;
    private static final int PERMISION_REQUEST_INTERNET=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        url=getIntent().getExtras().getString(url);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)== PackageManager.PERMISSION_GRANTED){
            openUrl();
        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PERMISION_REQUEST_INTERNET);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==PERMISION_REQUEST_INTERNET){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                openUrl();
            }
        }
    }

    private void openUrl(){
        WebView ww=findViewById(R.id.webview);
        ww.getSettings().setJavaScriptEnabled(true);
        ww.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    return false;
                }
        });

        ww.loadUrl(url);
    }
}
