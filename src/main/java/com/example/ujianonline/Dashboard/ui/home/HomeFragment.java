package com.example.ujianonline.Dashboard.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ujianonline.R;
import com.example.ujianonline.recycleView.RQuiz;
import com.example.ujianonline.retrofit.RetrofitCon;
import com.example.ujianonline.retrofit.quiz.Kuis;
import com.example.ujianonline.retrofit.quiz.ResponseKuis;
import com.sdsmdg.tastytoast.TastyToast;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    AVLoadingIndicatorView avi;
    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.daftarQuiz);
        avi = root.findViewById(R.id.avi);
        tampilkanDaftar();

        return root;
    }
    public void tampilkanDaftar() {
        Call<ResponseKuis> call = RetrofitCon.getInstasiasi().buatAPI().ambilkuis();
        call.enqueue(new Callback<ResponseKuis>() {
            @Override
            public void onResponse(Call<ResponseKuis> call, Response<ResponseKuis> response) {
                ResponseKuis respon = response.body();
                avi.hide();
                List<Kuis> pengu = respon.getData();
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                RQuiz listHeroAdapter = new RQuiz(pengu,getContext());
                recyclerView.setAdapter(listHeroAdapter);

            }


            @Override
            public void onFailure(Call<ResponseKuis> call, Throwable t) {
                avi.hide();
                TastyToast.makeText(getContext(), "Error karena " + t.getMessage(), 5000, TastyToast.ERROR);

            }
        });
    }
}