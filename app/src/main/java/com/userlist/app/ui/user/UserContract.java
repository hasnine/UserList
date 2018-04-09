package com.userlist.app.ui.user;

import android.content.Context;

import com.userlist.app.BasePresenter;
import com.userlist.app.BaseView;
import com.userlist.app.ui.user.model.Users;

import java.util.List;

/**
 * Created by has9 on 4/9/18.
 */

public interface UserContract {

    interface UserView extends BaseView {

        void onUserDataLoad(Users users);
        void onDataError(String message);
        void onHttpError();
        void onViewError(String message);

    }

    interface UserPresenter extends BasePresenter {

        void requestForUserDate();

    }

    interface UserInteractor {
        void onUserDataReq(Context mContext, OnCompleteListener onCompleteListener);
    }

    interface OnCompleteListener {

        void onSuccess(Users users);
        void onError(String message);
        void onHttpError(String message);
        void onViewError(String message);

    }

}
