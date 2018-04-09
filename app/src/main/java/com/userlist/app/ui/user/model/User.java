
package com.userlist.app.ui.user.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("phones")
    @Expose
    public Phones phones;
    @SerializedName("email")
    @Expose
    public List<String> email = null;
    @SerializedName("dateOfBirth")
    @Expose
    public String dateOfBirth;
    @SerializedName("registered")
    @Expose
    public Boolean registered;
    @SerializedName("gender")
    @Expose
    public String gender;
    @SerializedName("photo")
    @Expose
    public Integer photo;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Phones getPhones() {
        return phones;
    }

    public List<String> getEmail() {
        return email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public String getGender() {
        return gender;
    }

    public Integer getPhoto() {
        return photo;
    }
}
