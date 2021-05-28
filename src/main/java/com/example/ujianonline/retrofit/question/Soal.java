package com.example.ujianonline.retrofit.question;

public class Soal {
    int id;
    int id_kuis;
    int point;
    String soal;
    String tingkat_kesulitan;
    String tipe_soal;
    String isi;

    public Soal(int id, int id_soal, int point, String soal, String tingkat_kesulitan, String tipe_soal, String isi) {
        this.id = id;
        this.id_kuis = id_soal;
        this.point = point;
        this.soal = soal;
        this.tingkat_kesulitan = tingkat_kesulitan;
        this.tipe_soal = tipe_soal;
        this.isi = isi;
    }

    public Soal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_kuis() {
        return id_kuis;
    }

    public void setId_kuis(int id_soal) {
        this.id_kuis = id_soal;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getTingkat_kesulitan() {
        return tingkat_kesulitan;
    }

    public void setTingkat_kesulitan(String tingkat_kesulitan) {
        this.tingkat_kesulitan = tingkat_kesulitan;
    }

    public String getTipe_soal() {
        return tipe_soal;
    }

    public void setTipe_soal(String tipe_soal) {
        this.tipe_soal = tipe_soal;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
