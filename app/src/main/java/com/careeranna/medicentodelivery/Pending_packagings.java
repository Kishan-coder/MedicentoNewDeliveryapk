package com.careeranna.medicentodelivery;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.invalidateOptionsMenu;


/**
 * A simple {@link Fragment} subclass.
 */
public class Pending_packagings extends Fragment {
    public Packingadapter packingadapter;
    private RecyclerView packingrcv;
    ArrayList<packagingdetails> packdetails= new ArrayList<packagingdetails>();
    ArrayList<packagingdetails> filtered= new ArrayList<packagingdetails>();
    View rootView;
    ViewGroup c;
    Boolean b=true, con=false;
    Button submit;
    TextView textView;
    public Pending_packagings() {
        // Required empty public constructor
    }
    @SuppressLint("ValidFragment")
    public Pending_packagings(ArrayList<packagingdetails> filter) {
        filtered= (ArrayList<packagingdetails>) filter.clone();
        con=true;
    }

    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        c=container;
        setHasOptionsMenu(true);
        rootView = inflater.inflate(R.layout.fragment_pending_packagings, container, false);
        // Inflate the layout for this fragment
        packingrcv=rootView.findViewById(R.id.packingrc);
        submit=rootView.findViewById(R.id.submit);
        textView=rootView.findViewById(R.id.invisible);
        if(!filtered.isEmpty()){
            packingadapter=new Packingadapter(filtered, getActivity());
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
            packingrcv.setLayoutManager(mLayoutManager);
            packingrcv.setAdapter(packingadapter);
        }
        packdetails.add(new packagingdetails("vamshi medical","banglore","155787","550","25","10 am 28th feb","Makhan"));
        packdetails.add(new packagingdetails("arpan medical","banglore","155788","550","25","5 am 28th feb","Tulsasi"));
        packdetails.add(new packagingdetails("vamshi medical","banglore","155789","550","25","5 am 28th feb","Tulsasi"));
        packdetails.add(new packagingdetails("medha medical","New Delhi","155798","550","25","10 am 28th feb","Kiran"));
        packdetails.add(new packagingdetails("vamshi medical","banglore","155708","550","25","5 am 28th feb","Makhan"));
        packdetails.add(new packagingdetails("vamshi medical","banglore","155768","550","25","5 am 28th feb","Tulsasi"));
        packdetails.add(new packagingdetails("arpan medical","banglore","1557768","550","25","10 am 28th feb","Tulsasi"));
        packdetails.add(new packagingdetails("harish medical","New Delhi","1557887","550","25","5 pm 28th feb","Tulsasi"));
        packdetails.add(new packagingdetails("maruti medical","banglore","1557887","550","25","5 pm 28th feb","Tulsasi"));
        packdetails.add(new packagingdetails("maruti medical","banglore","15578865","550","25","5 am 28th feb","Tulsasi"));
        packdetails.add(new packagingdetails("medha medical","New Delhi","15578185","550","25","10 am 28th feb","Kiran"));
        packdetails.add(new packagingdetails("medha medical","New Delhi","15577865","550","25","10 am 28th feb","Kiran"));
        if(filtered.isEmpty()&&con){
            //dshfdduhfdjifuifdsh
            submit.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.VISIBLE);
            con=false;
        }
        else if(filtered.isEmpty()) {
            packingadapter = new Packingadapter(packdetails, getActivity());
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
            packingrcv.setLayoutManager(mLayoutManager);
            packingrcv.setAdapter(packingadapter);
        }
        Button submit=rootView.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<packingadapter.to_remove.size();i++){
                    if(packdetails.contains(packingadapter.to_remove.get(i)))
                        packdetails.remove(packingadapter.to_remove.get(i));
                }
                packingadapter = new Packingadapter(packdetails, getActivity());
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                packingrcv.setLayoutManager(mLayoutManager);
                packingrcv.setAdapter(packingadapter);
            }
        });
        return rootView;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if(b)
            inflater.inflate(R.menu.title_menu, menu);
        b=false;
    }
    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item1){

            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.forpopup, new Filter_packaging(packdetails));
            ft.commit();
            ft.addToBackStack(null);
          }
          if(id==R.id.item2){
              textView.setVisibility(View.GONE);
              submit.setVisibility(View.VISIBLE);
              packingadapter = new Packingadapter(packdetails, getActivity());
              LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
              packingrcv.setLayoutManager(mLayoutManager);
              packingrcv.setAdapter(packingadapter);
          }
        return super.onOptionsItemSelected(item);

    }
}
