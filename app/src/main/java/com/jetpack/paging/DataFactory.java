package com.jetpack.paging;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;

public class DataFactory extends DataSource.Factory<Integer,Concert>{
    private MutableLiveData<ListDataSource> mSourceLiveData = new MutableLiveData<>();
    /**
     * Create a DataSource.
     * <p>
     * The DataSource should invalidate itself if the snapshot is no longer valid. If a
     * DataSource becomes invalid, the only way to query more data is to create a new DataSource
     * from the Factory.
     * <p>
     * {@link LivePagedListBuilder} for example will construct a new PagedList and DataSource
     * when the current DataSource is invalidated, and pass the new PagedList through the
     * {@code LiveData<PagedList>} to observers.
     *
     * @return the new DataSource.
     */
    @NonNull
    @Override
    public DataSource<Integer, Concert> create() {
        ListDataSource dataSource = new ListDataSource();
        mSourceLiveData.postValue(dataSource);
        return dataSource;
    }
}
