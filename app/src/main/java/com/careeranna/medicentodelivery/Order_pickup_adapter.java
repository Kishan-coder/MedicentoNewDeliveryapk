package com.careeranna.medicentodelivery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Order_pickup_adapter extends RecyclerView.Adapter<Order_pickup_adapter.Jobholder> {
    private ArrayList<Order_pickup> mOrder_pickups;



    public Order_pickup_adapter(ArrayList<Order_pickup> Order_pickups) {
        mOrder_pickups = Order_pickups;
    }

    @NonNull
    @Override
    public Jobholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.order_pickup, viewGroup, false);
        return new Jobholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Jobholder jobholder, int i) {
        Order_pickup pendingjobs = mOrder_pickups.get(i);
        TextView Distibutor = jobholder.mDistributor;
        Distibutor.setText(pendingjobs.getmDistributor());
        TextView add = jobholder.mAddress;
        add.setText(pendingjobs.getmAdress());
        TextView time= jobholder.mtime;
        time.setText(pendingjobs.getmTime());
    }

    @Override
    public int getItemCount() {
        return mOrder_pickups.size();
    }


    class  Jobholder extends RecyclerView.ViewHolder  {

        public TextView mDistributor;
        public TextView mAddress;
        public TextView mtime;
        //private TextView mDistance;

        public Jobholder(@NonNull View itemView) {

            super(itemView);
            mDistributor = itemView.findViewById(R.id.distributor);
            mAddress = itemView.findViewById(R.id.address);
            mtime = itemView.findViewById(R.id.time);
        }

    }
}
