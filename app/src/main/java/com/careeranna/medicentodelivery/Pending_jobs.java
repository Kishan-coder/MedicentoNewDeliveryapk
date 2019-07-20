package com.careeranna.medicentodelivery;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashSet;

public class Pending_jobs extends Fragment {


    public Pending_jobs() {
        // Required empty public constructor
    }
    private RecyclerView rc1,rc3,rc2;

    final private ArrayList<Order_pickup> order_pickupArrayList=new ArrayList<Order_pickup>();
    final private ArrayList<Delivery> deliveryjobs=new ArrayList<Delivery>();
    final private ArrayList<Delivery> returnjobs=new ArrayList<Delivery>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pending_jobs, container, false);
        rc1=rootView.findViewById(R.id.rc);
        order_pickupArrayList.add(new Order_pickup("AMAN","Delhi","11 AM"));
        order_pickupArrayList.add(new Order_pickup("ANUJ","Delhi","11 AM"));
        order_pickupArrayList.add(new Order_pickup("AMAN","Delhi","11 AM"));
        order_pickupArrayList.add(new Order_pickup("HIRAN","banglore","11 AM"));
        order_pickupArrayList.add(new Order_pickup("DHARAM","banglore","11 AM"));
        order_pickupArrayList.add(new Order_pickup("SATLUJ","banglore","11 AM"));
        order_pickupArrayList.add(new Order_pickup("HIRAN","banglore","11 AM"));
        order_pickupArrayList.add(new Order_pickup("HIRAN","banglore","11 AM"));

        Toast.makeText(getActivity(), Integer.toString(order_pickupArrayList.size()),Toast.LENGTH_SHORT).show();
        for(int i=0;i<Packingadapter.to_remove.size();i++){
            packagingdetails p=Packingadapter.to_remove.get(i);
            Order_pickup order_pickup=new Order_pickup(p.getDistributor(),
                    p.getArea(), p.getDeliveryby());
                    order_pickupArrayList.add(order_pickup);
        }
        Toast.makeText(getActivity(), Integer.toString(order_pickupArrayList.size()),Toast.LENGTH_SHORT).show();
        Order_pickup_adapter order_pickup_adapter=new Order_pickup_adapter(order_pickupArrayList);
        rc1.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rc1.setAdapter(order_pickup_adapter);
        /*rc1.addOnItemTouchListener(
                new Rclistener(this, rc , new Rclistener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Intent i=new Intent(Jobs.this,Checklist.class);
                        startActivity(i);
                        Toast.makeText(getApplicationContext(), "hihi", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(), "too long", Toast.LENGTH_SHORT).show();

                    }
                })
        );*/
        if(order_pickup_adapter.getItemCount()==0){
            rc1.setVisibility(View.GONE);
            TextView t=rootView.findViewById(R.id.op1);
            t.setVisibility(View.GONE);
        }
        deliveryjobs.add(new Delivery("5","6","8:00AM"));
        deliveryjobs.add(new Delivery("5","6","8:00AM"));
        deliveryjobs.add(new Delivery("5","6","8:00AM"));
        deliveryjobs.add(new Delivery("5","6","8:00AM"));
        deliveryjobs.add(new Delivery("5","6","8:00AM"));
        deliveryjobs.add(new Delivery("5","6","8:00AM"));

        rc2=rootView.findViewById(R.id.rc2);
        Delivery_adapter deliveryAdapter=new Delivery_adapter(deliveryjobs);
        rc2.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rc2.setAdapter(deliveryAdapter);

        if(deliveryAdapter.getItemCount()==0){
            rc2.setVisibility(View.GONE);
            TextView t=rootView.findViewById(R.id.d1);
            t.setVisibility(View.GONE);
        }



        returnjobs.add(new Delivery("51","80","11:00 Am"));
        returnjobs.add(new Delivery("52","58","11:00 Am"));
        returnjobs.add(new Delivery("52","86","11:00 Am"));
        returnjobs.add(new Delivery("53","8","11:00 Am"));
        rc3=rootView.findViewById(R.id.rc3);
        Delivery_adapter returnadapter=new Delivery_adapter(returnjobs);
        rc3.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rc3.setAdapter(returnadapter);

        if(returnadapter.getItemCount()==0){
            rc3.setVisibility(View.GONE);
            TextView t=rootView.findViewById(R.id.rp1);
            t.setVisibility(View.GONE);
        }
        return rootView;
    }

}
