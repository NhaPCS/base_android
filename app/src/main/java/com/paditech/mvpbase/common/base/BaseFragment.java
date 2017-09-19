package com.paditech.mvpbase.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Nha Nha on 6/26/2017.
 */

public abstract class BaseFragment extends Fragment {
    //protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      /*  try {
            if (mRootView == null) {
                mRootView = inflater.inflate(getContentView(), container, false);
                initView(mRootView);
                return mRootView;
            } else return mRootView;
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            View view = LayoutInflater.from(getContext()).inflate(getContentView(), container, false);
            ButterKnife.bind(this, view);
            initView(view);
            return view;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract int getContentView();

    protected abstract void initView(View view);

    public void runOnUiThread(Runnable runnable) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(runnable);
        }
    }
}