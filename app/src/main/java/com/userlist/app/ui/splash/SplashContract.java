package com.userlist.app.ui.splash;

import com.userlist.app.BasePresenter;
import com.userlist.app.BaseView;

/**
 * Created by has9 on 4/9/18.
 */

public interface SplashContract {

    interface SplashView extends BaseView {
        void navigateToUserList();
    }

    interface SplashPresenter extends BasePresenter {

    }
}
