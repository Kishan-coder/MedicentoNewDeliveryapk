package com.careeranna.medicentodelivery;

public class Medicine_Details {
    String medname;
    String weigth;
    int quantity;
    int ptr;
    int total;
    public Medicine_Details(String mName,String mweight,int mquantity,int mptr){
        medname=mName;
        weigth=mweight;
        quantity=mquantity;
        ptr=mptr;
        total=mptr*mquantity;
    }

    public int getPtr() {
        return ptr;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotal() {
        return total;
    }

    public String getMedname() {
        return medname;
    }

    public String getWeigth() {
        return weigth;
    }

}
