
package com.userlist.app.ui.user.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("product")
    @Expose
    public String product;
    @SerializedName("version")
    @Expose
    public Float version;
    @SerializedName("releaseDate")
    @Expose
    public String releaseDate;
    @SerializedName("demo")
    @Expose
    public Boolean demo;
    @SerializedName("users")
    @Expose
    public List<User> users = null;

    public String getProduct() {
        return product;
    }

    public Float getVersion() {
        return version;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Boolean getDemo() {
        return demo;
    }

    public List<User> getUsers() {
        return users;
    }
}
