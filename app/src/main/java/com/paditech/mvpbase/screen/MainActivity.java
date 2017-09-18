package com.paditech.mvpbase.screen;


import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.paditech.mvpbase.R;
import com.paditech.mvpbase.contact.MainContact;
import com.paditech.mvpbase.mvp.activity.ActivityPresenter;
import com.paditech.mvpbase.mvp.activity.MVPActivity;
import com.paditech.mvpbase.presenter.MainPresenter;
import com.paditech.mvpbase.screen.frg.Frag1;
import com.paditech.mvpbase.screen.frg.Frag2;
import com.paditech.mvpbase.screen.frg.Frag3;
import com.paditech.mvpbase.utils.get_location.GetLocationManager;

import butterknife.OnClick;

public class MainActivity extends MVPActivity<MainContact.PresenterViewOps> implements MainContact.ViewOps {
    private GetLocationManager mGetLocationManager;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mGetLocationManager = new GetLocationManager(this);
        mGetLocationManager.getCurrentLocation();
        mGetLocationManager.setmOnCurrentLocationListener(new GetLocationManager.OnCurrentLocationListener() {
            @Override
            public void onCurrentLocationResult(Location location) {
                Toast.makeText(MainActivity.this, "LOCATION: " + location.getLatitude() + "-" + location.getLongitude(), Toast.LENGTH_SHORT).show();
            }
        });
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
            if (fragment instanceof Frag3) {
                replaceFragment(Frag1.newInstance(), true);
            }
        } else {
            replaceFragment(Frag1.newInstance(), true);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(mGetLocationManager != null) mGetLocationManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(mGetLocationManager != null) mGetLocationManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onDestroy() {
        if(mGetLocationManager != null) mGetLocationManager.onDestroy();
        super.onDestroy();
    }

    @Override
    protected Class<? extends ActivityPresenter> onRegisterPresenter() {
        return MainPresenter.class;
    }
}
