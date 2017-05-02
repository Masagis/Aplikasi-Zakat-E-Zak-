/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejak.Method;
import Ejak.Entity.EntitasDetailBayar;
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
public class DetailBayarControl {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String sql=null;
    
    public DetailBayarControl(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ezak?autoReconnect=true&useSSL=false","root","1234567890");
            st=con.createStatement();
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Terjadi kesalahaan Pada : \n"+a);
        }
    }
    
    
    public List tampilBarang(String noNota){
        List logDetailBeli = new ArrayList();
        sql="select nmzakat,harga from detailbayar where nonota='"+noNota+"'";
        try{
            rs=st.executeQuery(sql);

            while(rs.next()){
                EntitasDetailBayar eb=new EntitasDetailBayar();
                eb.setNmzakat(rs.getString("nmzakat"));
                eb.setHarga(rs.getInt("harga"));
                logDetailBeli.add(eb);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan tampil, pada :\n"+a);
        }
        return logDetailBeli;
    }
    
    public List CekBarang(String noNota,String kdBarang){
        List logDetailBeli = new ArrayList();
        sql="select nmzakat,harga from detailbayar where nonota='"+noNota+"'";
        try{
            rs=st.executeQuery(sql);

            while(rs.next()){
                EntitasDetailBayar eb=new EntitasDetailBayar();
                eb.setNmzakat(rs.getString("nmzakat"));
                eb.setHarga(rs.getInt("harga"));
                logDetailBeli.add(eb);        
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan Cek barang, pada :\n"+a);
        }
        return logDetailBeli;
    }
    
}

