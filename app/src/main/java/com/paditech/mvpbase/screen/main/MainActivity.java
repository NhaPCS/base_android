package com.paditech.mvpbase.screen.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nhapcs.base_padi.common.base.BaseActivity;
import com.paditech.mvpbase.R;

/**
 * Created by Nha Nha on 9/19/2017.
 */

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getContentView() {
        return 0;
    }

    @Override
    protected void initView() {

    }
}
