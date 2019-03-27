package com.careeranna.medicentodelivery;
import android.support.annotation.CallSuper;
import android.widget.SearchView;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class API {
    private static final String url="https://medicento-api.herokuapp.com/product/delivery/";
    public static getData Getdata=null;


    public static getData getService(){
        if(Getdata==null){
            Retrofit retrofit= new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
            Getdata=retrofit.create(getData.class);
        }
        return Getdata;
    }
    public interface getData{

        @GET("{login}")
        Call<Verification> GetUser(@Path("login") String l,
                                   @Query("user_email") String email,
                                   @Query("password") String pwd);
    }
}

