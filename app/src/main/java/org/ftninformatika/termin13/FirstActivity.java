package org.ftninformatika.termin13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void klik(View v){
        Intent i=new Intent(this, SecondActivity.class);
        i.putExtra("url","http://www.google.com");
        startActivity(i);
    }
}
