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
public class EntitasDetailBayar {
    String nonota,nmzakat;
    int harga,jml,total;
    
    public int getHarga(){
        return harga;
    }
    
    public void setHarga(int harga){
        this.harga = harga;
    }
    
    public int getJml(){
        return jml;
    }
    
    public void setJml (int jml){
        this.jml = jml;
    }

    public String getNmzakat(){
        return nmzakat;
    }
    
    public void setNmzakat(String nmzakat){
        this.nmzakat = nmzakat;
    }
    
    public String getNonota (){
        return nonota;
    } 
    
    public void setNonota (String nonota){
        this.nonota =  nonota;
        
    }
    
    public int getTotal(){
        return total;
    }
    
    public void setTotal(int total){
        this.total = total;
    } 
}
