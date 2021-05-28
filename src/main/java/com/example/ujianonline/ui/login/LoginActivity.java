package com.example.ujianonline.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.ujianonline.About;
import com.example.ujianonline.R;
import com.example.ujianonline.Dashboard.Beranda;
import com.example.ujianonline.retrofit.RetrofitCon;
import com.example.ujianonline.retrofit.pengguna.ResponsePengguna;
import com.sdsmdg.tastytoast.TastyToast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button Back;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                Call<ResponsePengguna> login = RetrofitCon.getInstasiasi().buatAPI().login(usernameEditText.getText().toString(), passwordEditText.getText().toString());
                login.enqueue(new Callback<ResponsePengguna>() {
                    @Override
                    public void onResponse(Call<ResponsePengguna> call, Response<ResponsePengguna> response) {
                        if (response.body().getStatus().equals("success")) {
                            if (response.body().getRole().equals("Peserta Ujian")) {
                                loadingProgressBar.setVisibility(View.INVISIBLE);
                                TastyToast.makeText(getApplicationContext(), "Berhasil Login", 5000, TastyToast.SUCCESS);

                                Intent intent = new Intent(getApplicationContext(), Beranda.class);
                                startActivity(intent);
                            } else {
                                loadingProgressBar.setVisibility(View.INVISIBLE);

                                TastyToast.makeText(getApplicationContext(), "Tidak dapat login karena akun tidak terdaftar", 5000, TastyToast.WARNING);

                            }

                        } else {
                            loadingProgressBar.setVisibility(View.INVISIBLE);

                            TastyToast.makeText(getApplicationContext(), "Tidak dapat login karena akun tidak terdaftar", 5000, TastyToast.WARNING);

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsePengguna> call, Throwable t) {
                        loadingProgressBar.setVisibility(View.INVISIBLE);
                        TastyToast.makeText(getApplicationContext(), "Salah karena" + t.getMessage(), 5000, TastyToast.ERROR);

                    }
                });
            }
        });
    }
}



