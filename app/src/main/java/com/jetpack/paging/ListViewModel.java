package com.jetpack.paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class ListViewModel extends ViewModel {
    private final LiveData<PagedList<Concert>> dataList;
    private DataSource<Integer,Concert> dataSource;

    public ListViewModel() {
        DataFactory factory = new DataFactory();
        dataList = new LivePagedListBuilder<>(factory,ListDataSource.PAGE_SIZE).build();
        dataSource = factory.create();
    }

    public void initDataSource() {
        dataSource.invalidate();
    }

    public LiveData<PagedList<Concert>> getDataList(){
        return dataList;
    }
}
