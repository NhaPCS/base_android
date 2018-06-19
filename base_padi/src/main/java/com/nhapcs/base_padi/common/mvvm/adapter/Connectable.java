package com.nhapcs.base_padi.common.mvvm.adapter;

import io.reactivex.disposables.Disposable;

/**
 * Created by nhapcs on 6/9/18.
 */
public interface Connectable {
    Disposable connect();
}
