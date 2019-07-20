package com.careeranna.medicentodelivery;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    AreaAdapter adapter;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Initialisation
        pref= getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        final TextView completed= findViewById(R.id.dc);
        final TextView pending= findViewById(R.id.dp);
        final TextView points= findViewById(R.id.points);
        final TextView collected_amount= findViewById(R.id.amountcollected);
        recyclerView=findViewById(R.id.recycle);

        final API api=new API();
        String s=null;
        if(pref.contains("Email_pwd"))
            s=pref.getString("Email_pwd", "");
        final Call<DashboardPojo> dcall=api.getService().GetUser(s.substring(0, s.indexOf(" ")));
        dcall.enqueue(new Callback<DashboardPojo>() {
            @Override
            public void onResponse(Call<DashboardPojo> call, Response<DashboardPojo> response) {
                DashboardPojo data=response.body();
                if(data==null){
                    Toast.makeText(getApplicationContext(),"Nothing Found!", Toast.LENGTH_SHORT);
                }
                else{
                    completed.setText(data.getDeliveryCompleted().toString());
                    pending.setText(data.getDeliveryPending().toString());
                    points.setText(data.getPoints().toString());
                    collected_amount.setText(data.getCollectedAmount().toString());
                    recyclerView.setLayoutManager(new LinearLayoutManager(Dashboard.this));
                    List<AreaAndDelivery> ad= data.getAreaAndDelivery();
                    adapter=new AreaAdapter(ad);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<DashboardPojo> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please Wait...", Toast.LENGTH_SHORT).show();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();
        }
        Intent i= new Intent(Dashboard.this,Dashboard.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile) {
            Intent intent = new Intent(Dashboard.this, Profile.class);
            startActivity(intent);
        } else if (id == R.id.Billing) {
            setTitle("Billing");
            FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fl, new Billing_fragment());
            ft.commit();
        }
        else if(id == R.id.Dashboard){
            setTitle("Dashboard");
            if (getSupportFragmentManager().getFragments() != null && getSupportFragmentManager().getFragments().size() > 0) {
                for (int i = 0; i < getSupportFragmentManager().getFragments().size(); i++) {
                    Fragment mFragment = getSupportFragmentManager().getFragments().get(i);
                    if (mFragment != null) {
                        getSupportFragmentManager().beginTransaction().remove(mFragment).commit();
                    }
                }
            }        }
        else if (id == R.id.PendingPackagings) {
            setTitle("Pending Packagings");
            FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fl, new Pending_packagings());
            ft.commit();
        } else if (id == R.id.Joblist) {
            setTitle("Pending Jobs");
            FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fl, new Pending_jobs());
            ft.commit();
        }
        else if(id== R.id.change_pwd){
            Intent intent = new Intent(Dashboard.this, change_password.class);
            startActivity(intent);
        }
        else if(id==R.id.logout){
            SharedPreferences.Editor editor=pref.edit();
            editor.clear();
            editor.commit();
            finish();
            Intent intent =new Intent(Dashboard.this, MainActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
