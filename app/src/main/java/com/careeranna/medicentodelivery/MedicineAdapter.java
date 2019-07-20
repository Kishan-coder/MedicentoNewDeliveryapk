package com.careeranna.medicentodelivery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.medicineholder> {
    final private ArrayList<Medicine_Details> md2;
    Context context;
    public MedicineAdapter(Context con,ArrayList<Medicine_Details> med){
        md2=med;
        context=con;
    }
    @NonNull
    @Override
    public MedicineAdapter.medicineholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context ct=viewGroup.getContext();
        LayoutInflater inflater=LayoutInflater.from(ct);
        View view=inflater.inflate(R.layout.medicine_list_items,viewGroup,false);
        return new medicineholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineAdapter.medicineholder medicineholder, int i) {
        Medicine_Details medicinedetails=md2.get(i);
        CheckBox cb=medicineholder.cb1;
        cb.setActivated(true);
        cb.setText((i+1)+" .");
        TextView medname=medicineholder.medname;
        medname.setText(medicinedetails.getMedname());
        TextView weight=medicineholder.weigth;
        weight.setText(medicinedetails.getWeigth());
        TextView quantity=medicineholder.quantity;
        quantity.setText(""+medicinedetails.getQuantity());
        TextView ptr=medicineholder.ptr;
        ptr.setText(""+medicinedetails.getPtr());
        TextView total=medicineholder.total;
        total.setText(""+medicinedetails.getTotal());

    }

    @Override
    public int getItemCount() {
        return md2.size();
    }
    class medicineholder extends RecyclerView.ViewHolder {
        public TextView medname;
        public TextView weigth;
        public TextView quantity;
        public TextView ptr;
        public TextView total;
        public CheckBox cb1;
        public medicineholder(@NonNull View itemView) {
            super(itemView);
            medname=itemView.findViewById(R.id.medname);
            weigth=itemView.findViewById(R.id.weight);
            quantity=itemView.findViewById(R.id.quanity);
            ptr=itemView.findViewById(R.id.ptr);
            total=itemView.findViewById(R.id.total);
            cb1=itemView.findViewById(R.id.cbox);

        }
    }
}
