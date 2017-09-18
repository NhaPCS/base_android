package com.paditech.mvpbase.screen;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Nha Nha on 9/18/2017.
 */

public class TextAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = new TextView(parent.getContext());
        textView.setPadding(20, 15, 20, 15);
        textView.setTextColor(Color.WHITE);

        return new TextHolder(textView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextHolder textHolder = (TextHolder) holder;
        ((TextView) textHolder.itemView).setText("Text number " + position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    private class TextHolder extends RecyclerView.ViewHolder {

        public TextHolder(View itemView) {
            super(itemView);
        }
    }
}
