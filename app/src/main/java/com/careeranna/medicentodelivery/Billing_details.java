package com.careeranna.medicentodelivery;

import java.util.ArrayList;

public class Billing_details {
    String Pharmacy;
    String orderno;
    String  ordervalue;
    int items;
    ArrayList<Medicine_Details> medicinedetails;
    public Billing_details(String mPharmacy,String mOrdervalue,String morderno,int mitems,ArrayList<Medicine_Details> med){
        Pharmacy=mPharmacy;
        orderno=morderno;
        ordervalue=mOrdervalue;
        medicinedetails=med;
        items=mitems;
    }

    public ArrayList<Medicine_Details> getMedicinedetails() {
        return medicinedetails;
    }

    public String getOrderno() {
        return orderno;
    }

    public int getItems() {
        return items;
    }

    public String getOrdervalue() {
        return ordervalue;
    }

    public String getPharmacy() {
        return Pharmacy;
    }

}
