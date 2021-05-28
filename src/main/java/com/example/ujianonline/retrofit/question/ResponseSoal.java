package com.example.ujianonline.retrofit.question;

import java.util.List;

public class ResponseSoal {
    String status;
    List<Soal> data;

    public ResponseSoal(String status, List<Soal> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Soal> getData() {
        return data;
    }

    public void setData(List<Soal> data) {
        this.data = data;
    }
}
