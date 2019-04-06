package com.careeranna.medicentodelivery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AreaAndDelivery {

    @SerializedName("No_of_delivery")
    @Expose
    private Integer noOfDelivery;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("area")
    @Expose
    private String area;

    public Integer getNoOfDelivery() {
        return noOfDelivery;
    }

    public void setNoOfDelivery(Integer noOfDelivery) {
        this.noOfDelivery = noOfDelivery;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
