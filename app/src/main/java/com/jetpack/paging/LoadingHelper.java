package com.jetpack.paging;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.MutableLiveData;

/**
 * 加载对话框
 */
public class LoadingHelper {
    /**
     * 显示加载进度对话框；<br/>
     * 需要和{@link LoadingHelper#hideLoading()}成对出现
     */
    public static void showLoading(){
        LoadingSwitch.getInstance().turnOn();

        Intent intent = new Intent(PagingApplication.getInstance(),LoadingActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PagingApplication.getInstance().startActivity(intent);
    }
    /**
     * 隐藏加载进度对话框；<br>
     * 需要和{@link LoadingHelper#showLoading()}成对出现
     */
    public static void hideLoading(){
        LoadingSwitch.getInstance().turnOff();
    }

    /**
     * loading开关
     */
    public static class LoadingSwitch{
        private static LoadingSwitch instance;
        public MutableLiveData<Boolean> isShow = new MutableLiveData<>(false);
        private LoadingSwitch(){}

        public static LoadingSwitch getInstance(){
            if(instance == null){
                synchronized (LoadingSwitch.class){
                    if(instance == null){
                        instance = new LoadingSwitch();
                    }
                }
            }
            return instance;
        }

        public void turnOn(){
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> {
                isShow.setValue(true);
            });
        }
        public void turnOff(){
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> {
                isShow.setValue(false);
            });
        }


    }
}
