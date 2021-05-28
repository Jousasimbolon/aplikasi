package com.example.ujianonline.retrofit.quiz;

import java.util.List;

public class ResponseKuis {
    String status;
    List<Kuis> data;

    public ResponseKuis(String status, List<Kuis> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Kuis> getData() {
        return data;
    }

    public void setData(List<Kuis> data) {
        this.data = data;
    }
}
