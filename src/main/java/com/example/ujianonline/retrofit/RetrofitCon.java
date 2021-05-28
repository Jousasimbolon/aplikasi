package com.example.ujianonline.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCon {
    private static  final  String baseURL = "http://192.168.43.117/WebService/public/pengguna";
    private  static RetrofitCon intasiasi;
    private Retrofit retrofit;
    private  RetrofitCon(){
        retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public  static  synchronized  RetrofitCon  getInstasiasi(){
        if(intasiasi == null){
            intasiasi = new RetrofitCon();
        }
        return intasiasi;
    }
    public API buatAPI(){
        return retrofit.create(API.class);
    }
}
