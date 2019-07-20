package com.careeranna.medicentodelivery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Delivery_adapter extends RecyclerView.Adapter<Delivery_adapter.DeliveryHolder>  {
    private ArrayList<Delivery> mDeliveryjobs;
    Delivery_adapter(ArrayList<Delivery> deliveryjobs){
        mDeliveryjobs=deliveryjobs;
    }
    @NonNull
    @Override
    public Delivery_adapter.DeliveryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.delivery_item, viewGroup, false);
        return new DeliveryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Delivery_adapter.DeliveryHolder deliveryHolder, int i) {
        Delivery dj=mDeliveryjobs.get(i);
        TextView tw1=deliveryHolder.NumPhramacies;
        tw1.setText(dj.getNumPhramacies());
        TextView tw2=deliveryHolder.Numareas;
        tw2.setText(dj.getNumAreas());
        TextView tw3=deliveryHolder.Time;
        tw3.setText(dj.getTime());
    }

    @Override
    public int getItemCount() {
        return mDeliveryjobs.size();
    }
    class  DeliveryHolder extends RecyclerView.ViewHolder {
        public TextView NumPhramacies;
        public TextView Numareas;
        public  TextView Time;
        public DeliveryHolder(@NonNull View itemView) {
            super(itemView);
            NumPhramacies=itemView.findViewById(R.id.numPharmacies);
            Numareas=itemView.findViewById(R.id.numAreas);
            Time =itemView.findViewById(R.id.time);
        }
    }
}
