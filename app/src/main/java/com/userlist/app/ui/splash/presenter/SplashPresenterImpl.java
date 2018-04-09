package com.userlist.app.ui.splash.presenter;

import android.os.Handler;

import com.userlist.app.ui.splash.SplashContract;

/**
 * Created by fatimaaits on 14/12/17.
 */

public class SplashPresenterImpl implements SplashContract.SplashPresenter {

    private SplashContract.SplashView mView;

    public SplashPresenterImpl(SplashContract.SplashView view) {
        mView = view;
    }


    @Override
    public void onDestroy() {
        mView = null;
    }

    @Override
    public void onResume() {
        haltSplash();
    }

    @Override
    public void onStop() {

    }


    public void haltSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mView!=null) {
                    mView.navigateToUserList();
                }
            }
        }, 2000);

    }
}
