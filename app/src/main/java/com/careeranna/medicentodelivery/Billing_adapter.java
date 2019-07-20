package com.careeranna.medicentodelivery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Billing_adapter extends RecyclerView.Adapter<Billing_adapter.Billing_holder> {
    private final Context context;
    MedicineAdapter medicineAdapter;
    private Context ct;
    boolean check=true;
    private ArrayList<Billing_details> checklistDetail;
    public Billing_adapter(Context mcontext,ArrayList<Billing_details> cd){
        this.context=mcontext;
        checklistDetail=cd;
    }

    @NonNull
    @Override
    public Billing_adapter.Billing_holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        check=true;
        ct=viewGroup.getContext();
        LayoutInflater inflater=LayoutInflater.from(ct);
        View view=inflater.inflate(R.layout.billing_items,viewGroup,false);
        return new Billing_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Billing_adapter.Billing_holder checklistholder, int i) {
        Billing_details c1=checklistDetail.get(i);
        TextView orderno=checklistholder.ordernum;
        orderno.setText("Order No :"+c1.getOrderno());
        TextView ordervalue=checklistholder.ordervalue;
        ordervalue.setText("Order value :"+c1.getOrdervalue());
        TextView items=checklistholder.items;
        items.setText("Items :"+c1.getItems());

        checklistholder.pharmacy.setText(c1.getPharmacy());

        checklistholder.ordernum.setText("Order No :"+c1.getOrderno());

        checklistholder.ordervalue.setText("Order value :"+c1.getOrdervalue());

        checklistholder.items.setText("Items :"+c1.getItems());

        ArrayList<Medicine_Details> m1=c1.getMedicinedetails();
        medicineAdapter=new MedicineAdapter(context,m1);
        //checklistholder.checkrc1.setHasFixedSize(true);
        checklistholder.checkrc1.setLayoutManager(new LinearLayoutManager(context));
        checklistholder.checkrc1.setAdapter(medicineAdapter);


        checklistholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check){
                LinearLayout p=v.findViewById(R.id.expandablelist);
                p.setVisibility(View.VISIBLE);
                check=false;}
                else{
                    LinearLayout p=v.findViewById(R.id.expandablelist);
                    p.setVisibility(View.GONE);
                    check=true;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return checklistDetail.size();
    }
    class Billing_holder extends RecyclerView.ViewHolder {
        final public RecyclerView checkrc1;
        public TextView pharmacy;
        public TextView ordernum;
        public TextView ordervalue;
        public Button dispatch;
        public TextView items;

        public Billing_holder(@NonNull View itemView) {
            super(itemView);
            checkrc1=itemView.findViewById(R.id.crc2);
            pharmacy=itemView.findViewById(R.id.pharmacy1);
            ordernum=itemView.findViewById(R.id.orderno1);
            ordervalue=itemView.findViewById(R.id.ordervalue1);
            dispatch=itemView.findViewById(R.id.dispatch);
            items=itemView.findViewById(R.id.items2);
        }
    }
}
