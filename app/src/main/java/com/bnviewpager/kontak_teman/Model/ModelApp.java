package com.bnviewpager.kontak_teman.Model;

/*Tanggal Pengerjaan : 14/8/2019
  Nim                : 10116135
  Nama               : Rival Agung Fahrizal
  Kelas              : IF-3
* */

public class ModelApp {
    private int image;
    private String nim,nama,kelas,telephone,email,instagram;

    public ModelApp(int image, String nim, String nama, String kelas, String telephone, String email, String instagram){
        this.image = image;
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.telephone = telephone;
        this.email = email;
        this.instagram = instagram;
    }

    public int getImage() {
        return image;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
