package com.example.ujianonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ujianonline.Dashboard.Beranda;

public class About extends AppCompatActivity {
    Button Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Back = findViewById(R.id.btnback);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about = new Intent(About.this, Beranda.class);
                startActivity(about);
            }
        });
    }
}