package com.example.ujianonline.uiquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ujianonline.R;
import com.example.ujianonline.retrofit.RetrofitCon;
import com.example.ujianonline.retrofit.question.ResponseSoal;
import com.example.ujianonline.retrofit.question.Soal;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HalamanQuiz extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;
    Button sebelum,selanjutnya;
    private  int data = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_quiz);
        final ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        sebelum = findViewById(R.id.sebelum);
        selanjutnya = findViewById(R.id.selanjutnya);
        data = getIntent().getIntExtra("id_soal",0);
        Call<ResponseSoal> call = RetrofitCon.getInstasiasi().buatAPI().ambilsoal(data);
        call.enqueue(new Callback<ResponseSoal>() {
            @Override
            public void onResponse(Call<ResponseSoal> call, Response<ResponseSoal> response) {
                adapterViewPager = new MyPagerAdapter(getSupportFragmentManager(),response.body().getData());
                System.out.println(response.body().getData());
                vpPager.setAdapter(adapterViewPager);

            }

            @Override
            public void onFailure(Call<ResponseSoal> call, Throwable t) {
                TastyToast.makeText(getApplicationContext(), "Error karena " +   t.getMessage(), 5000, TastyToast.ERROR);

            }
        });


        if(vpPager.getCurrentItem() == 0){
            sebelum.setEnabled(false);
        }

        vpPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

                if(vpPager.getCurrentItem() == 0){
                    sebelum.setEnabled(false);
                }
                else {
                    sebelum.setEnabled(true);
                }
            }
        });
        selanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpPager.setCurrentItem(vpPager.getCurrentItem()+1);
            }
        });
        sebelum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpPager.setCurrentItem(vpPager.getCurrentItem()-1);
            }
        });

    }
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        List<Soal> soal;
        List<Fragment> pages = new ArrayList<Fragment>();
        public MyPagerAdapter(FragmentManager fragmentManager,List<Soal> soal) {
            super(fragmentManager);
            this.soal = soal;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return soal.size();
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            for(int i = 0 ; i < soal.size(); i++) {
                System.out.println( soal.size());
                if (soal.get(i).getTipe_soal().equals("pilihan")) {
                    pages.add(SoalBergandaFragment.newInstance(i, soal.get(i)));

                }
                else if(soal.get(i).getTipe_soal().equals("esay")){
                    pages.add(SoalEssayragment.newInstance(i, soal.get(i)));

                }
                else if(soal.get(i).getTipe_soal().equals("tf")){
                    pages.add(TrueFalseFragment.newInstance(i, soal.get(i)));

                }
            }
            return pages.get(position);
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Nomor " + position;
        }

    }
}