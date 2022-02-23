package com.jetpack.paging;

import android.app.Application;

public class PagingApplication extends Application {
    private static PagingApplication instance;

    public static PagingApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
