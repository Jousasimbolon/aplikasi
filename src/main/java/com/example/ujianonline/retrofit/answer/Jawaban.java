package com.example.ujianonline.retrofit.answer;

public class Jawaban {
    int id;
    int id_soal;
    String tipe;
    String isi;
    int validasi;

    public Jawaban(int id, int id_soal, String tipe, String isi, int validasi) {
        this.id = id;
        this.id_soal = id_soal;
        this.tipe = tipe;
        this.isi = isi;
        this.validasi = validasi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_soal() {
        return id_soal;
    }

    public void setId_soal(int id_soal) {
        this.id_soal = id_soal;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public int getValidasi() {
        return validasi;
    }

    public void setValidasi(int validasi) {
        this.validasi = validasi;
    }
}
