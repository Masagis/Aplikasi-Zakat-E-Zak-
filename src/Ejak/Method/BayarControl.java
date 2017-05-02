/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejak.Method;
import Ejak.Entity.EntitasBayar;
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
public class BayarControl {
    Connection conn=null;
    Statement st=null;
    ResultSet rs=null;
    String sql=null;
    public Connection connection;
    
       public void BayarControl(){
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
        List logBayar = new ArrayList();
        sql="select nonota,nm_pembayar,tgl,total,bayar, from bayar order by idbayar asc";
        try{
            rs=st.executeQuery(sql);

            while(rs.next()){
                EntitasBayar eb=new EntitasBayar();
                eb.setNonota(rs.getString("nonota"));
                eb.setPembayar(rs.getString("nm_pembayar"));
                eb.setTgl(rs.getString("tgl"));
                eb.setTotal(rs.getInt("total"));
                eb.setBayar(rs.getInt("bayar"));
                logBayar.add(eb);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan tampil, pada :\n"+a);
        }
        return logBayar;
    }
      
    public int tambahBayar(EntitasBayar e){
        sql="insert into bayar values('"+e.getPembayar()+"','"+e.getTotal()+"')";
        int hasil=0;
        try{
            hasil=st.executeUpdate(sql);
        } catch(SQLException a){
            Logger.getLogger(ZakatControl.class.getName()).log(Level.SEVERE,null,a);
        }
        return hasil;
    }
      
    public int deleteBayar(EntitasBayar e){
        sql="delete from bayar where nonota='"+e.getNonota()+"'";
        int hasil=0;
        try{
            hasil=st.executeUpdate(sql);
        } catch(SQLException a){
            Logger.getLogger(ZakatControl.class.getName()).log(Level.SEVERE,null,a);
        }
        return hasil;
    }  
}
