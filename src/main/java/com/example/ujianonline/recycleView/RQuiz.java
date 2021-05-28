package com.example.ujianonline.recycleView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ujianonline.uiquiz.HalamanQuiz;
import com.example.ujianonline.R;
import com.example.ujianonline.retrofit.quiz.Kuis;

import java.util.List;

public class RQuiz extends RecyclerView.Adapter<RQuiz.Holder> {
    private List<Kuis> data;
    Context context;
    public RQuiz(List<Kuis> data,Context context){
        this.data = data;
        this.context =context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz,parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        final Kuis list = this.data.get(position);
        holder.judul.setText(list.getJudul());
        holder.durasi.setText("Durasi : " + list.getDurasi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final Intent intent = new Intent(context, Pengaduans.class);
//                intent.putExtra("data", list);
//                context.startActivity(intent);
            }
        });
        holder.lakukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to = new Intent(context, HalamanQuiz.class);
                to.putExtra("id_soal",list.getId_kuis());
                context.startActivity(to);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView judul;
        TextView  durasi;
        Button lakukan;
        public Holder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul_kuis);
            durasi = itemView.findViewById(R.id.durasi);
            lakukan = itemView.findViewById(R.id.lakukan);
        }
    }
}
