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
public class EntitasBayar {
    String nonota,pembayar,tipe_zakat;
    String tgl;
    int total,bayar;
    
    public String getTipe_zakat(){
        return tipe_zakat;
    }
    
    public void setTipe_zakat(String tipe_zakat){
        this.tipe_zakat = tipe_zakat;
    }
    
    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }
    
    public String getTgl(){
        return tgl;
    }
    
    public void setTgl(String tgl){
        this.tgl = tgl;
    }
    
    public String getNonota(){
        return nonota;
    }
    
    public void setNonota(String nonota){
        this.nonota = nonota;
    }
    
    public String getPembayar(){
        return pembayar;
    }
    
    public void setPembayar(String pembayar){
        this.pembayar = pembayar;
    }
    
    public int getTotal(){
        return total;
    }
    
    public void setTotal(int total){
        this.total = total;
    }
    
}
