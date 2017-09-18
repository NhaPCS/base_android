package com.paditech.mvpbase.screen.frg;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.paditech.mvpbase.R;
import com.paditech.mvpbase.mvp.fragment.FragmentPresenter;
import com.paditech.mvpbase.mvp.fragment.MVPFragment;
import com.paditech.mvpbase.screen.FragContact;
import com.paditech.mvpbase.screen.FragPresenter;
import com.paditech.mvpbase.screen.TextAdapter;

import butterknife.BindView;

/**
 * Created by Nha Nha on 9/18/2017.
 */

public class Frag2 extends MVPFragment<FragContact.PresenterViewOps> implements FragContact.ViewOps {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    public static Frag2 newInstance() {
        return new Frag2();
    }

    @Override
    protected int getContentView() {
        return R.layout.frag_2;
    }

    @Override
    protected void initView(View view) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new TextAdapter());
    }

    @Override
    protected Class<? extends FragmentPresenter> onRegisterPresenter() {
        return FragPresenter.class;
    }
}
