package com.example.ujianonline.uiquiz;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ujianonline.R;
import com.example.ujianonline.retrofit.RetrofitCon;
import com.example.ujianonline.retrofit.answer.Jawaban;
import com.example.ujianonline.retrofit.answer.ResponseJawaban;
import com.example.ujianonline.retrofit.question.Soal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SoalBergandaFragment extends Fragment {
    Soal soals;
    RadioGroup group;
    RadioButton a,b,c,d,e;
    private SoalBergandaViewModel mViewModel;
    List<Jawaban> pilihan;

    int position;
    TextView judul,isi;
    public static SoalBergandaFragment newInstance(int position,Soal soals) {
        SoalBergandaFragment soal = new SoalBergandaFragment(position,soals);
        return soal;
    }
    SoalBergandaFragment(int position,Soal soal){
        this.position = position;
        this.soals = soal;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.soal_berganda_fragment, container, false);
        Call<ResponseJawaban> call = RetrofitCon.getInstasiasi().buatAPI().ambiljawab(soals.getId_kuis());
        call.enqueue(new Callback<ResponseJawaban>() {
            @Override
            public void onResponse(Call<ResponseJawaban> call, Response<ResponseJawaban> response) {
                pilihan = response.body().getData();
                judul = root.findViewById(R.id.judulsoal);
                isi = root.findViewById(R.id.soal);
                a = root.findViewById(R.id.a);
                b = root.findViewById(R.id.b);
                c = root.findViewById(R.id.c);
                d = root.findViewById(R.id.d);
                e = root.findViewById(R.id.e);
                judul.setText("Soal nomor " + (position+1));
                a.setText(pilihan.get(0).getIsi());
                b.setText(pilihan.get(1).getIsi());
                c.setText(pilihan.get(2).getIsi());
                d.setText(pilihan.get(3).getIsi());
                e.setText(pilihan.get(4).getIsi());
                isi.setText(soals.getSoal());
            }
            @Override
            public void onFailure(Call<ResponseJawaban> call, Throwable t) {

            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SoalBergandaViewModel.class);
        // TODO: Use the ViewModel
    }

}