package com.careeranna.medicentodelivery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfilePojo {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("ratings")
    @Expose
    private String ratings;
    @SerializedName("phone_no")
    @Expose
    private String phoneNo;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("total_deliveries")
    @Expose
    private Integer totalDeliveries;
    @SerializedName("avg_delivery_time")
    @Expose
    private String avgDeliveryTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(Integer totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

    public String getAvgDeliveryTime() {
        return avgDeliveryTime;
    }

    public void setAvgDeliveryTime(String avgDeliveryTime) {
        this.avgDeliveryTime = avgDeliveryTime;
    }

}