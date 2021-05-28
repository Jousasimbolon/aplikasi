package com.example.ujianonline.retrofit;

import com.example.ujianonline.retrofit.answer.ResponseJawaban;
import com.example.ujianonline.retrofit.quiz.ResponseKuis;
import com.example.ujianonline.retrofit.pengguna.ResponsePengguna;
import com.example.ujianonline.retrofit.question.ResponseSoal;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    @FormUrlEncoded
    @POST("pengguna")
    Call<ResponsePengguna> login(
            @Field("username") String username,
            @Field("password") String password
    );
    @GET("quiz")
    Call<ResponseKuis> ambilkuis();
    @FormUrlEncoded
    @POST("soal")
    Call<ResponseSoal> ambilsoal(
            @Field("id") int id
    );
    @FormUrlEncoded
    @POST("jawaban")
    Call<ResponseJawaban> ambiljawab(
            @Field("id") int id
    );
}
