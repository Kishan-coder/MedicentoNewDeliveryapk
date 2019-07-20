package com.careeranna.medicentodelivery;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class Filter_packaging extends Fragment {

    ArrayList<packagingdetails> packdetails;
    final ArrayList<packagingdetails> filtered_details= new ArrayList<packagingdetails>();
    @SuppressLint("ValidFragment")
    public Filter_packaging(ArrayList<packagingdetails> pd) {
        // Required empty public constructor
        packdetails=pd;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        filtered_details.clear();
        final View rootView =inflater.inflate(R.layout.fragment_filter_packaging, container, false);
        final Spinner dropdown1=rootView.findViewById(R.id.spinner1);
        final Spinner dropdown2=rootView.findViewById(R.id.spinner2);
        final Spinner dropdown3=rootView.findViewById(R.id.spinner3);

        final ArrayList<String> items1= new ArrayList<String>();
        items1.add("Distributor Name");
        final ArrayList<String> items2= new ArrayList<String>();
        items2.add("Pharmacy Name");
        final ArrayList<String> items3= new ArrayList<String>();
        items3.add("Time");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, items1);
        dropdown1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, items3);
        dropdown3.setAdapter(adapter3);
        dropdown1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                items1.clear();
                for(int i=0;i<packdetails.size();i++){
                    int j;
                    for( j=0;j<items1.size();j++){
                        if(packdetails.get(i).getDistributor()==items1.get(j))
                            break;
                    }
                    if(j==items1.size()){
                        items1.add(packdetails.get(i).getDistributor());
                    }
                }
                return false;
            }
        });
        dropdown2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                items2.clear();
                for(int i=0;i<packdetails.size();i++){
                    int j;
                    for( j=0;j<items2.size();j++){
                        if(packdetails.get(i).getPhramacyName()==items2.get(j))
                            break;
                    }
                    if(j==items2.size())
                        items2.add(packdetails.get(i).getPhramacyName());

                }
                return false;
            }
        });
        dropdown3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                items3.clear();
                items3.add("10 am 28th feb");
                items3.add("5 am 28th feb");
                items3.add("5 pm 28th feb");
                return false;
            }
        });
        dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!filtered_details.isEmpty()) {
                    packdetails = (ArrayList<packagingdetails>) filtered_details.clone();
                    filtered_details.clear();
                }
                    for(int i=0;i<packdetails.size();i++){
                        if(packdetails.get(i).getDistributor()==dropdown1.getItemAtPosition(position).toString())
                            filtered_details.add(packdetails.get(i));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!filtered_details.isEmpty()) {
                    packdetails = (ArrayList<packagingdetails>) filtered_details.clone();
                    filtered_details.clear();
                }
                    for(int i=0;i<packdetails.size();i++){
                        if(packdetails.get(i).getPhramacyName()==dropdown2.getItemAtPosition(position).toString())
                            filtered_details.add(packdetails.get(i));
                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dropdown3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!filtered_details.isEmpty()) {
                    packdetails = (ArrayList<packagingdetails>) filtered_details.clone();
                    filtered_details.clear();
                }
                    for(int i=0;i<packdetails.size();i++){
                        if(packdetails.get(i).getDeliveryby()==dropdown3.getItemAtPosition(position).toString())
                            filtered_details.add(packdetails.get(i));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button go =rootView.findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.ll1, new Pending_packagings(filtered_details));
                ft.commit();
            }
        });
        Button cancel=rootView.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStackImmediate();
            }
        });
        return rootView;
    }

}
