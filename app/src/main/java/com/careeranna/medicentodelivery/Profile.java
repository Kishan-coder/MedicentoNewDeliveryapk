package com.careeranna.medicentodelivery;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.icu.text.DateTimePatternGenerator.PatternInfo.OK;

public class Profile extends AppCompatActivity {
    //variable for edit button
    Boolean ed=true;
    String Rating=null;
    ImageView imageView;
    Button button;
    //imageview
    ImageView m1;
    ImageView m2;
    ImageView m3;
    ImageView m4;
    ImageView m5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //Initialisation
        ScrollView sv= findViewById(R.id.sv);
        sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.INVISIBLE);
            }
        });
        final TextView first_name=findViewById(R.id.user_name);
        final TextView full_name=findViewById(R.id.user_full_name);
        final TextView email=findViewById(R.id.email_value);
        final TextView contact=findViewById(R.id.contact_no_value);
        final TextView total_delivery=findViewById(R.id.total_deliveries_value);
        final TextView avg_time=findViewById(R.id.Avg_delivery_time_value);
        final TextView dob=findViewById(R.id.dob_value);
        button=findViewById(R.id.edit);
        imageView=findViewById(R.id.profile_image);

        //imageview
        m1=findViewById(R.id.start_one);
        m2=findViewById(R.id.start_two);
        m3=findViewById(R.id.start_three);
        m4=findViewById(R.id.start_four);
        m5=findViewById(R.id.start_five);

        //Get email from bundle
        Bundle bundle = getIntent().getExtras();
        final String email_ = bundle.getString("message");

        //call API
        final API api=new API();
        final Call<ProfilePojo> pcall=api.getService().GetUser("profile", email_);
        pcall.enqueue(new Callback<ProfilePojo>() {
            @Override
            public void onResponse(Call<ProfilePojo> call, Response<ProfilePojo> response) {
                ProfilePojo data=response.body();
                first_name.setText(data.getUserName().substring(0, data.getUserName().indexOf(' ')));
                full_name.setText(data.getUserName());
                email.setText(email_);
                contact.setText(data.getPhoneNo());
                total_delivery.setText(data.getTotalDeliveries().toString());
                avg_time.setText(data.getAvgDeliveryTime());
                dob.setText(data.getDateOfBirth().substring(0, data.getDateOfBirth().indexOf('T')));
                Rating=data.getRatings();
                switch (Rating){
                    case "5": {
                        m1.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m2.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m3.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m4.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m5.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        break;
                    }
                    case "4.5":{
                        m1.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m2.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m3.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m4.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m5.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_half));
                        break;
                    }
                    case "4":{
                        m1.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m2.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m3.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m4.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m5.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        break;
                    }
                    case "3.5":{
                        m1.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m2.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m3.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m4.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_half));
                        m5.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        break;
                    }
                    case "3":{
                        m1.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m2.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m3.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m4.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m5.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        break;
                    }
                    case "2.5":{
                        m1.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m2.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m3.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_half));
                        m4.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m5.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        break;
                    }
                    case "2":{
                        m1.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m2.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m3.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m4.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m5.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        break;
                    }
                    case "1.5":{
                        m1.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m2.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_half));
                        m3.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m4.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m5.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        break;
                    }
                    case "1":{
                        m1.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_full));
                        m2.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m3.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m4.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m5.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        break;
                    }
                    case "0.5":{
                        m1.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_half));
                        m2.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m3.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m4.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m5.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        break;
                    }
                    default:{
                        m1.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m2.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m3.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m4.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        m5.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_empty));
                        break;
                    }
                }

            }

            @Override
            public void onFailure(Call<ProfilePojo> call, Throwable t) {
                //Toast.makeText(getApplicationContext(), "Please Wait...", Toast.LENGTH_SHORT).show();
            }
        });



        //on_image_click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed==true) {
                    ed=false;
                    button.setVisibility(View.VISIBLE);
                }
                else{
                    ed=true;
                    button.setVisibility(View.INVISIBLE);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                        String[] Permissions= new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(Permissions, 1001);
                    }
                    else{
                        pickImage();
                    }
                }
                else{
                    pickImage();
                }
            }
        });
    }
    void pickImage(){
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 1000);
    }
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions,
                                           int[] grantResults){
        if(requestCode==1001){
            if(grantResults.length>0&& grantResults[0] ==PackageManager.PERMISSION_GRANTED)
                pickImage();
        }
        else{
            Toast.makeText(getApplicationContext(), "Give Persmission!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1000){
            if(data.getData()!=null)
                imageView.setImageURI(data.getData());
            button.setVisibility(View.INVISIBLE);
        }
    }
}
