package com.example.ujianonline.retrofit.answer;

import java.util.List;

public class ResponseJawaban {
    String status;
    List<Jawaban> data;

    public ResponseJawaban(String status, List<Jawaban> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Jawaban> getData() {
        return data;
    }

    public void setData(List<Jawaban> data) {
        this.data = data;
    }
}
