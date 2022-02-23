package com.jetpack.paging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Window window = getWindow();
        window.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM);
        window.getDecorView().setPadding(0, 0, 0, 0);

        LoadingHelper.LoadingSwitch.getInstance()
                .isShow.observe(this,
                (isShow) -> {
                    Log.d("log_debug","LoadingActivity  isShow = " + isShow);
                    if(!isShow){
                        finish();
                    }
                });
    }
}