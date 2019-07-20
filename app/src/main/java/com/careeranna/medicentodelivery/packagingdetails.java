package com.careeranna.medicentodelivery;

public class packagingdetails {
    private String phramacyName;
    private String area;
    private String orderNo;
    private String orderAmount;
    private String items;
    private String deliveryby;
    private String distributor;
    public packagingdetails(String mPharmacy, String mArea, String mOrderno, String morderAmount, String mitems, String mdeliveryby, String mdistributor){
        phramacyName=mPharmacy;
        area=mArea;
        orderAmount=morderAmount;
        orderNo=mOrderno;
        items=mitems;
        deliveryby=mdeliveryby;
        distributor=mdistributor;
    }

    public String getArea() {
        return area;
    }

    public String getDeliveryby() {
        return deliveryby;
    }

    public String getDistributor() {
        return distributor;
    }

    public String getItems() {
        return items;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public String getPhramacyName() {
        return phramacyName;
    }


}
