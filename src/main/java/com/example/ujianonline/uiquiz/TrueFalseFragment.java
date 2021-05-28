package com.example.ujianonline.uiquiz;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ujianonline.R;
import com.example.ujianonline.retrofit.question.Soal;

public class TrueFalseFragment extends Fragment {
    int position;

    Soal soals;
    TextView judul,isi;

    private TrueFalseViewModel mViewModel;

    public static TrueFalseFragment newInstance(int position,Soal soals) {

        return new TrueFalseFragment(position,soals);
    }

    public TrueFalseFragment(int position, Soal soals) {
        this.position = position;
        this.soals = soals;
    }

    public TrueFalseFragment(int contentLayoutId, int position, Soal soals) {
        super(contentLayoutId);
        this.position = position;
        this.soals = soals;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.true_false_fragment, container, false);
        judul = root.findViewById(R.id.judulsoal);
        isi = root.findViewById(R.id.soal);
        judul.setText("Soal nomor " + (position+1));
        isi.setText(soals.getSoal());
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TrueFalseViewModel.class);
        // TODO: Use the ViewModel
    }

}