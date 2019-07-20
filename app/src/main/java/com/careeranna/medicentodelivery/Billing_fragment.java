package com.careeranna.medicentodelivery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Billing_fragment extends Fragment {


    public Billing_fragment() {
        // Required empty public constructor
    }

    RecyclerView crc1;
    final private ArrayList<Billing_details> cd=new ArrayList<Billing_details>();
    final private ArrayList<Medicine_Details> md =new ArrayList<Medicine_Details>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.billing_fragment, container, false);
        crc1=rootView.findViewById(R.id.crc1);
        md.add(new Medicine_Details("crocin","500mg",5,8));
        md.add(new Medicine_Details("crocing","500mg",5,8));
        md.add(new Medicine_Details("croci","500mg",5,8));
        /*md.add(new Medicinedetails("crocin","500mg",5,8));
        md.add(new Medicinedetails("crocin","500mg",5,8));
        md.add(new Medicinedetails("crocin","500mg",5,8));
        md.add(new Medicinedetails("crocin","500mg",5,8));*/
        cd.add(new Billing_details("AP phrama","5000","8778",5,md));
        cd.add(new Billing_details("AP phrama","5000","8778",5,md));
        cd.add(new Billing_details("AP phrama","5000","8778",5,md));
        cd.add(new Billing_details("AP phrama","5000","8778",5,md));
        cd.add(new Billing_details("AP phrama","5000","8778",5,md));
        cd.add(new Billing_details("AP phrama","5000","8778",5,md));
        cd.add(new Billing_details("AP phrama","5000","8778",5,md));
        cd.add(new Billing_details("AP phrama","5000","8778",5,md));
        cd.add(new Billing_details("AP phrama","5000","8778",5,md));
        cd.add(new Billing_details("AP phrama","5000","8778",5,md));
        cd.add(new Billing_details("AP phrama","5000","8778",5,md));
        cd.add(new Billing_details("AP phrama","5000","8778",5,md));

        Billing_adapter checklist_adapter=new Billing_adapter(this.getActivity(),cd);
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this.getActivity());
        crc1.setLayoutManager(linearLayoutManager);
        //crc1.setHasFixedSize(true);
        crc1.setAdapter(checklist_adapter);
        return rootView;
    }

}
