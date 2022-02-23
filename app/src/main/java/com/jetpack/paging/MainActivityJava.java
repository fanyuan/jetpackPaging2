package com.jetpack.paging;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivityJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
    }

    public void test(View view) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.d("debug_tag","java runnable " + Thread.currentThread().getName());
            }
        };


        Tools.test(runnable);
    }
}