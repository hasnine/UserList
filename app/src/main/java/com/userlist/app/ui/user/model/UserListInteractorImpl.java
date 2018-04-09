package com.userlist.app.ui.user.model;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.userlist.app.api.RetrofitSingleton;
import com.userlist.app.api.UserListEndpoint;
import com.userlist.app.ui.user.UserContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by has9 on 4/9/18.
 */

public class UserListInteractorImpl implements UserContract.UserInteractor {


    @Override
    public void onUserDataReq(Context mContext, final UserContract.OnCompleteListener onCompleteListener) {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        UserListEndpoint userListEndpoint = retrofit.create(UserListEndpoint.class);

        userListEndpoint.getUserList().enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()) {

                    onCompleteListener.onSuccess(response.body());
                    Log.d("Are", "Hoise ki suc");

                } else {
                    onCompleteListener.onError(response.message());
                    Log.d("Are", "Hoise ki er");
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                onCompleteListener.onError(t.getMessage());

            }
        });
    }
}
