package com.example.ujianonline.retrofit.quiz;

public class Kuis {
        int id_kuis;
        String judul;
        String durasi;

    public Kuis(int id_kuis, String judul, String durasi) {
        this.id_kuis = id_kuis;
        this.judul = judul;
        this.durasi = durasi;
    }

    public int getId_kuis() {
        return id_kuis;
    }

    public void setId_kuis(int id_kuis) {
        this.id_kuis = id_kuis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }
}
