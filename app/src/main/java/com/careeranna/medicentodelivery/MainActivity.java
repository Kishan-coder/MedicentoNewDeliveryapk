package com.careeranna.medicentodelivery;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public  static TextInputLayout email;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pref= getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialisation
        email=findViewById(R.id.useremailL);
        final TextInputLayout pwd=findViewById(R.id.userpasswordL);
        Button login =findViewById(R.id.sign_in_btn);
        final TextView tv=findViewById(R.id.check);
        final ProgressBar pg= findViewById(R.id.sign_in_progress);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg.setVisibility(View.VISIBLE);
                final API api=new API();
                final Call<Verification> vcall=api.getService().GetUser("login",email.getEditText().getText().toString(), pwd.getEditText().getText().toString());
                vcall.enqueue(new Callback<Verification>() {
                    @Override
                    public void onResponse(Call<Verification> call, Response<Verification> response) {
                        Verification data=response.body();
                        if(data==null||data.getMessage()=="No User Found"){
                            tv.setVisibility(View.VISIBLE);
                            pg.setVisibility(View.INVISIBLE);
                        }
                        else{
                            editor = pref.edit();
                            editor.putString("Email_pwd", email.getEditText().getText().toString() + " " + pwd.getEditText().getText().toString());
                            editor.apply();
                            tv.setVisibility(View.INVISIBLE);
                            pg.setVisibility(View.GONE);

                            Intent intent = new Intent(MainActivity.this, Dashboard.class);
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onFailure(Call<Verification> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Please Wait...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
   }

    @Override
    protected void onResume() {
        super.onResume();
        if(pref.contains("Email_pwd")){
            Intent intent = new Intent(MainActivity.this, Dashboard.class);
            startActivity(intent);
        }
    }
}
