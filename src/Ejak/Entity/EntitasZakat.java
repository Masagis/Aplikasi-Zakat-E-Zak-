/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejak.Entity;

/**
 *
 * @author dimasgs
 */
public class EntitasZakat {
    public String kdzakat,nmzakat,satuan;
    public int harga;

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }


    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKdzakat() {
        return kdzakat;
    }

    public void setKdzakat(String kdzakat) {
        this.kdzakat = kdzakat;
    }

    public String getNmzakat() {
        return nmzakat;
    }

    public void setNmzakat(String nmzakat) {
        this.nmzakat = nmzakat;
    }

}
