package com.example.ujianonline.uiquiz;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ujianonline.R;
import com.example.ujianonline.retrofit.question.Soal;

public class SoalEssayragment extends Fragment {
    int position;

    Soal soals;
    TextView judul,isi;
    EditText jawab;
    private SoalEssayragmentViewModel mViewModel;

    public static SoalEssayragment newInstance(int position,Soal soals) {
        return new SoalEssayragment(position,soals);
    }

    public SoalEssayragment(int position, Soal soals) {
        this.position = position;
        this.soals = soals;
    }

    public SoalEssayragment(int contentLayoutId, int position, Soal soals) {
        super(contentLayoutId);
        this.position = position;
        this.soals = soals;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.soal_essayragment_fragment, container, false);
        judul = root.findViewById(R.id.judulsoal);
        jawab = root.findViewById(R.id.jawabEssay);
        isi = root.findViewById(R.id.soal);
        isi.setText(soals.getSoal());
        judul.setText("Soal nomor " + (position+1));
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SoalEssayragmentViewModel.class);
        // TODO: Use the ViewModel
    }

}