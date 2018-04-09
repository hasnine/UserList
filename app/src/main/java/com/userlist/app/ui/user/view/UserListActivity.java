package com.userlist.app.ui.user.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.userlist.app.Constants;
import com.userlist.app.R;
import com.userlist.app.ui.user.UserContract;
import com.userlist.app.ui.user.model.Users;
import com.userlist.app.ui.user.presenter.UserListPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.adapters.AnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class UserListActivity extends AppCompatActivity implements UserContract.UserView {

    @BindView(R.id.rvUserList)
    RecyclerView rvUserList;

    @BindView(R.id.progressbar)
    ProgressBar mProgressbar;

    private UserListAdapter mUserListAdapter;
    private UserContract.UserPresenter mUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list_activity);
        ButterKnife.bind(this);
        initView();
    }

    public void initView() {
        mProgressbar.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mUserPresenter = new UserListPresenterImpl(this);
        mUserPresenter.requestForUserDate();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public Activity getActivityContext() {
        return this;
    }

    @Override
    public void onUserDataLoad(Users users) {
        mProgressbar.setVisibility(View.GONE);
        Log.d("Are",users.getUsers().size()+"");
        mUserListAdapter = new UserListAdapter(users.getUsers(),this);
        rvUserList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AnimationAdapter alphaAdapter = new ScaleInAnimationAdapter(mUserListAdapter);
        alphaAdapter.setFirstOnly(false);
        alphaAdapter.setDuration(1000);
        alphaAdapter.setInterpolator(new OvershootInterpolator(1f));
        rvUserList.setAdapter(mUserListAdapter);



    }

    @Override
    public void onDataError(String message) {
        Toast.makeText(getContext(), message,Toast.LENGTH_LONG);
    }

    @Override
    public void onHttpError() {

    }

    @Override
    public void onViewError(String message) {

    }
}
