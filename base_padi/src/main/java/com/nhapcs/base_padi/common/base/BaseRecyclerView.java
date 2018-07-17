package com.nhapcs.base_padi.common.base;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseRecyclerView extends RecyclerView.Adapter<BaseViewHolder> {

    private OnItemClickListener mItemClickListener;

    public void setmItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    protected abstract Object getItem(int index);

    @Override
    public void onBindViewHolder(@NonNull final BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null)
                    mItemClickListener.onItemClick(holder.itemView, position);
            }
        });
        holder.bind(position);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int pos);
    }
}
