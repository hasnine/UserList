package com.userlist.app.ui.splash.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.userlist.app.R;
import com.userlist.app.ui.splash.SplashContract;
import com.userlist.app.ui.splash.presenter.SplashPresenterImpl;
import com.userlist.app.ui.user.view.UserListActivity;

import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements SplashContract.SplashView{

    SplashContract.SplashPresenter mPresenter;

    private static final String TAG = SplashActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new SplashPresenterImpl(this);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public Activity getActivityContext() {
        return this;
    }

    @Override
    public void navigateToUserList() {
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }
}
