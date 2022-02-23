package com.jetpack.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * DataSource:顾名思义，数据源，获取数据是通过它实现的。
 * 官方文档上，实现的是ItemKeyedDataSource,这里实现的是PositionalDataSource
 */
public class ListDataSource extends PositionalDataSource<Concert> {
    public static final int PAGE_SIZE = 10;
    private static final int PAGE_TOTAL_SIZE = 1000;

    /**
     * 加载初始化数据，可以这么来理解，加载的是第一页的数据。
     * 形象的说，当我们第一次打开页面，需要回调此方法来获取数据。
     */
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Concert> callback) {
        LoadingHelper.showLoading();
        callback.onResult(getItems(0,PAGE_SIZE),0,PAGE_TOTAL_SIZE);
        LoadingHelper.hideLoading();
    }

    /**
     * 当有了初始化数据之后，滑动的时候如果需要加载数据的话，会调用此方法。
     */
    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Concert> callback) {
        Log.d("log_debug","ListDataSource --- loadRange " + Thread.currentThread().getName());
        LoadingHelper.showLoading();
        callback.onResult(getItems(params.startPosition,params.loadSize));
        LoadingHelper.hideLoading();
    }

    /**
     * 获取数据条目信息
     * @param startPosition
     * @param pageSize
     * @return
     */
    private List<Concert> getItems(int startPosition, int pageSize) {
        Log.d("log_debug","ListDataSource --- getItems " + Thread.currentThread().getName());


        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}

        List<Concert> list = new ArrayList<>();
        for (int i = startPosition; i < startPosition + pageSize; i++) {
            Concert concert = new Concert();
            concert.setAuthor("author --- " + i);
            concert.setContent("content --- " + i);
            concert.setTitle("title --- " + i);
            list.add(concert);
        }

        return list;
    }
}
