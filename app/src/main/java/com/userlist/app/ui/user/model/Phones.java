
package com.userlist.app.ui.user.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Phones {

    @SerializedName("home")
    @Expose
    public String home;
    @SerializedName("mobile")
    @Expose
    public String mobile;

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }
}
