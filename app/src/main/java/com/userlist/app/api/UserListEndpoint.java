package com.userlist.app.api;

import com.userlist.app.ui.user.model.User;
import com.userlist.app.ui.user.model.Users;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by has9 on 4/9/18.
 */

public interface UserListEndpoint {
    @GET("users.json")
    Call<Users> getUserList();
}
