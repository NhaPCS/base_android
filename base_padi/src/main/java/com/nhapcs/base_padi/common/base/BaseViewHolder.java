package com.nhapcs.base_padi.common.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by nhapcs on 6/9/18.
 */
public abstract class BaseViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {

    V dataBinding;

    public BaseViewHolder(V binding) {
        super(binding.getRoot());
        dataBinding = binding;
    }

    public V getDataBinding() {
        return dataBinding;
    }

    public abstract void bind(int pos);
}
