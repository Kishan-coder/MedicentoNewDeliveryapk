package com.careeranna.medicentodelivery;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class Packingadapter extends RecyclerView.Adapter<Packingadapter.Packingholder> {
    final private ArrayList<packagingdetails> pd;
    public static ArrayList<packagingdetails> to_remove=new ArrayList<packagingdetails>();
    Context mcontext,context;
    public Packingadapter(ArrayList<packagingdetails> ss, Context context){
        pd=ss;
        this.mcontext=context;
    }
    @NonNull
    @Override
    public Packingholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.packaging_listitems, viewGroup, false);
        return new Packingholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Packingholder packingholder, final int i) {
        final packagingdetails p=pd.get(i);
        TextView tw1=packingholder.phramacyName;
        tw1.setText(p.getPhramacyName());
        TextView tw2=packingholder.area;
        tw2.setText("Area  :"+p.getArea());
        TextView tw3=packingholder.orderAmount;
        tw3.setText(p.getOrderAmount());
        TextView tw4=packingholder.orderNo;
        tw4.setText(p.getOrderNo());
        TextView tw5=packingholder.items;
        tw5.setText(p.getItems());
        TextView tw6=packingholder.distributor;
        tw6.setText(p.getDistributor());
        TextView tw7=packingholder.deliveryby;
        tw7.setText(p.getDeliveryby());
        Button call=packingholder.call;
        Button sendmail=packingholder.sendorder;
        sendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                //smsIntent.putExtra("address", "12125551212");
                smsIntent.putExtra("sms_body","Body of Message");
                context.startActivity(smsIntent);

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // TextView t1=
                showPopup(v,p);
            }
        });

        Switch status=packingholder.status;
        status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    to_remove.add(pd.get(i));
                }
                else if(!isChecked){
                    to_remove.remove(pd.get(i));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pd.size();
    }

    public class Packingholder extends RecyclerView.ViewHolder  {
        public TextView phramacyName;
        public TextView area;
        public TextView orderNo;
        public TextView orderAmount;
        public TextView items;
        public TextView deliveryby;
        public TextView distributor;
        public Button call,sendorder;
        Switch status;
        public Packingholder(@NonNull View itemView) {
            super(itemView);
            area=itemView.findViewById(R.id.area1);
            orderAmount=itemView.findViewById(R.id.orderamt);
            orderNo=itemView.findViewById(R.id.orderno);
            items=itemView.findViewById(R.id.items1);
            deliveryby=itemView.findViewById(R.id.deliverby);
            distributor=itemView.findViewById(R.id.distributor);
            phramacyName=itemView.findViewById(R.id.phramacies);
            call=itemView.findViewById(R.id.calldistributor);
            sendorder=itemView.findViewById(R.id.sendorder);
            status=itemView.findViewById(R.id.switch1);
        }



    }

    public void showPopup(View view, packagingdetails packagingdetails) {
        View popupView = LayoutInflater.from(mcontext).inflate(R.layout.popup, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, 600);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(popupView,Gravity.CENTER, 0,0);
        TextView p=popupView.findViewById(R.id.distname);
        p.setText(packagingdetails.getDistributor());
        Button b=popupView.findViewById(R.id.callbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0123456789"));
                context.startActivity(intent);
            }
        });
    }
}
