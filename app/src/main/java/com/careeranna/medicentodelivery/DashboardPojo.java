package com.careeranna.medicentodelivery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DashboardPojo {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("delivery_pending")
    @Expose
    private Integer deliveryPending;
    @SerializedName("delivery_completed")
    @Expose
    private Integer deliveryCompleted;
    @SerializedName("collected_amount")
    @Expose
    private Integer collectedAmount;
    @SerializedName("points")
    @Expose
    private Integer points;
    @SerializedName("area_and_delivery")
    @Expose
    private List<AreaAndDelivery> areaAndDelivery = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDeliveryPending() {
        return deliveryPending;
    }

    public void setDeliveryPending(Integer deliveryPending) {
        this.deliveryPending = deliveryPending;
    }

    public Integer getDeliveryCompleted() {
        return deliveryCompleted;
    }

    public void setDeliveryCompleted(Integer deliveryCompleted) {
        this.deliveryCompleted = deliveryCompleted;
    }

    public Integer getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(Integer collectedAmount) {
        this.collectedAmount = collectedAmount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public List<AreaAndDelivery> getAreaAndDelivery() {
        return areaAndDelivery;
    }

    public void setAreaAndDelivery(List<AreaAndDelivery> areaAndDelivery) {
        this.areaAndDelivery = areaAndDelivery;
    }

}