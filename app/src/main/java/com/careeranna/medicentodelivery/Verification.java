package com.careeranna.medicentodelivery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Verification {

    @SerializedName("is_first_time_sign_in")
    @Expose
    private Boolean isFirstTimeSignIn;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getIsFirstTimeSignIn() {
        return isFirstTimeSignIn;
    }

    public void setIsFirstTimeSignIn(Boolean isFirstTimeSignIn) {
        this.isFirstTimeSignIn = isFirstTimeSignIn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}