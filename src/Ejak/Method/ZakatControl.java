/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejak.Method;
import Ejak.Entity.EntitasZakat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dimasgs
 */
public class ZakatControl {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;
    public Connection connection;
    
    public void ZakatControl(){
        try{
            String url, user, password;
                url = "jdbc:mysql://localhost:3306/ezak?autoReconnect=true&useSSL=false"; //alamat DB
                user = "root";
                password = "1234567890";
                connection = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null,"Koneksi Berhasil");
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Terjadi kesalahaan Pada : \n"+a);
        }
    }
    
    public List tampil(){
        List logZakat = new ArrayList();       
        sql="select harga,tipe from stok order by tipe asc";
        try{
            rs=st.executeQuery(sql);

            while(rs.next()){
                EntitasZakat eb=new EntitasZakat();
                eb.setKdzakat(rs.getString("kdzakat"));
                eb.setNmzakat(rs.getString("nmzakat"));
                eb.setHarga(rs.getInt("harga"));
                logZakat.add(eb);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan tampil, pada :\n"+a);
        }
        return logZakat;
    }
    
    public List cariBarang(String cari){
       List logZakat = new ArrayList();
       sql= "select harga, tipe from stok where tipe like '%"+cari+"%' or harga like '%"+cari+"%'";
       try{
           rs=st.executeQuery(sql);
           while(rs.next()){
               EntitasZakat eb = new EntitasZakat();
               eb.setKdzakat(rs.getString("kdzakat"));
               eb.setNmzakat(rs.getString("nmzakat"));
               eb.setHarga(rs.getInt("harga"));
               logZakat.add(eb);
           } 
       } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan cari, pada :\n"+a);
        }
        return logZakat;
    }
    
    public int editZakat(EntitasZakat e){
        sql="update stok set nmzakat='"+e.getNmzakat()+"',harga='"+e.getHarga()+"'";
        int hasil=0;
        try{
            hasil=st.executeUpdate(sql);
        } catch(SQLException a){
            Logger.getLogger(ZakatControl.class.getName()).log(Level.SEVERE,null,a);
        }
        return hasil;
    }
    
    public int updateStok(int harga,String kdBarang){
        sql="update stok set harga='"+harga+"' where kdzakat='"+kdBarang+"'";
        int hasil=0;
        try{
            hasil=st.executeUpdate(sql);
        } catch(SQLException a){
            Logger.getLogger(ZakatControl.class.getName()).log(Level.SEVERE,null,a);
        }
        return hasil;
    }
    
}
