package com.userlist.app.ui.user.presenter;

import android.util.Log;
import android.widget.Toast;

import com.userlist.app.Constants;
import com.userlist.app.ui.user.UserContract;
import com.userlist.app.ui.user.model.UserListInteractorImpl;
import com.userlist.app.ui.user.model.Users;
import com.userlist.app.utils.NetworkCheckUtil;

import java.util.List;

import butterknife.internal.Utils;

/**
 * Created by has9 on 4/9/18.
 */

public class UserListPresenterImpl implements UserContract.UserPresenter, UserContract.OnCompleteListener {

    private UserContract.UserView mUserView;
    private UserContract.UserInteractor mUserInteractor;


    public UserListPresenterImpl(UserContract.UserView mUserView) {
        this.mUserView = mUserView;
        mUserInteractor = new UserListInteractorImpl();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void requestForUserDate() {

        if (NetworkCheckUtil.isConnectedToInternet(mUserView.getActivityContext())){
            mUserInteractor.onUserDataReq(mUserView.getActivityContext(),this);

        } else {
            Toast.makeText(mUserView.getContext(), Constants.TOAST.INTERNET_ERROR,Toast.LENGTH_LONG);
        }

    }

    @Override
    public void onSuccess(Users users) {

        mUserView.onUserDataLoad(users);

    }

    @Override
    public void onError(String message) {
        mUserView.onDataError(message);
    }

    @Override
    public void onHttpError(String message) {

    }

    @Override
    public void onViewError(String message) {

    }
}
