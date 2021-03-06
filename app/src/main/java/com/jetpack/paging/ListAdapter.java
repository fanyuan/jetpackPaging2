package com.jetpack.paging;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends PagedListAdapter<Concert, ListAdapter.RecyclerViewHolder> {

    protected ListAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Concert concert = getItem(position);
        if (concert != null) {
            holder.mTitleTextView.setText(concert.getTitle());
            holder.mAuthorTextView.setText(concert.getAuthor());
            holder.mContentTextView.setText(concert.getContent());
        }
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView mTitleTextView;
        TextView mAuthorTextView;
        TextView mContentTextView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mTitleTextView = itemView.findViewById(R.id.title);
            mAuthorTextView = itemView.findViewById(R.id.author);
            mContentTextView = itemView.findViewById(R.id.content);
        }
    }

    //需要oldConcert与新 newConcert 比较才能得出变化的数据
    private static DiffUtil.ItemCallback<Concert> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Concert>() {
                // 判断Item是否已经存在
                @Override
                public boolean areItemsTheSame(Concert oldConcert, Concert newConcert) {
                    return oldConcert.getTitle().equals(newConcert.getTitle());
                }

                // 如果Item已经存在则会调用此方法，判断Item的内容是否一致
                @Override
                public boolean areContentsTheSame(Concert oldConcert, Concert newConcert) {
                    return oldConcert.equals(newConcert);
                }
            };

}

