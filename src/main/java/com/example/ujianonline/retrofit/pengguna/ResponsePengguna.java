package com.example.ujianonline.retrofit.pengguna;

public class ResponsePengguna {
    String status;
    String username;
    String nama;
    String role;

    public ResponsePengguna(String status, String username, String nama, String role) {
        this.status = status;
        this.username = username;
        this.nama = nama;
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
