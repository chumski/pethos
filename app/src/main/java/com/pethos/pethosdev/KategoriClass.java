package com.pethos.pethosdev;


public class KategoriClass {

    int idKategori;
    String nama;
    int icon;

    public KategoriClass(int idKategori, String nama, int icon) {
            this.idKategori= idKategori;
            this.nama = nama;
            this.icon = icon;
    }


    public int getIdKategori(){

        return idKategori;
    }

}

