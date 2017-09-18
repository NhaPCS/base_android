package com.paditech.mvpbase.screen;


import android.support.v4.app.Fragment;

import com.paditech.mvpbase.R;
import com.paditech.mvpbase.contact.MainContact;
import com.paditech.mvpbase.mvp.activity.ActivityPresenter;
import com.paditech.mvpbase.mvp.activity.MVPActivity;
import com.paditech.mvpbase.presenter.MainPresenter;
import com.paditech.mvpbase.screen.frg.Frag1;
import com.paditech.mvpbase.screen.frg.Frag2;
import com.paditech.mvpbase.screen.frg.Frag3;

import butterknife.OnClick;

public class MainActivity extends MVPActivity<MainContact.PresenterViewOps> implements MainContact.ViewOps {

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        replaceFragment(Frag1.newInstance(), false);
    }

    @OnClick(R.id.btn_floating)
    public void onAddFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_layout);
        if (fragment != null) {
            if (fragment instanceof Frag1) {
                replaceFragment(Frag2.newInstance(), true);
            }
            if (fragment instanceof Frag2) {
                replaceFragment(Frag3.newInstance(), true);
            }
            if(fragment instanceof Frag3) {
                replaceFragment(Frag1.newInstance(), true);
            }
        } else {
            replaceFragment(Frag1.newInstance(), true);
        }
    }

    @Override
    protected Class<? extends ActivityPresenter> onRegisterPresenter() {
        return MainPresenter.class;
    }
}
