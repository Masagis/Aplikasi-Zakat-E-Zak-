/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejak.Method;
import Ejak.Entity.EntitasPengguna;
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
public class PenggunaControl {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String sql=null;
    
    public Connection connection;
    
    public void PenggunaControl(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ezak?autoReconnect=true&useSSL=false","root","1234567890");
            st=con.createStatement();            
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Terjadi kesalahaan Pada : \n"+a);
        }
        
        /*try{
            String url, user, password;
                url = "jdbc:mysql://localhost:3306/ezak?autoReconnect=true&useSSL=false"; //alamat DB
                user = "root";
                password = "1234567890";
                connection = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null,"Koneksi Berhasil");
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Terjadi kesalahaan Pada : \n"+a);
        } */
    }
    
    public List tampil(){
        List pengguna = new ArrayList();
        
        sql= "select idpengguna,username,password,hakakses from pengguna";
        try{
            rs=st.executeQuery(sql);
            
            while (rs.next()){
            EntitasPengguna ep= new EntitasPengguna();
            ep.setIdpengguna(rs.getInt("idpengguna"));
            ep.setUsername(rs.getString("username"));
            ep.setPassword(rs.getString("password"));
            ep.setHakakses(rs.getString("hakakses"));
            pengguna.add(ep);
           
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Terjadi kesalahan tampil, pada\n"+ex);
        }
        return pengguna;
    }
    public List cariId(int idpengguna){
        List logLogin=new ArrayList();
        int result;
        sql="select idpengguna from pengguna where idpengguna='"+idpengguna+"'";
        try {
            rs=st.executeQuery(sql);
            
            while (rs.next()){
                EntitasPengguna ep=new EntitasPengguna();
                ep.setIdpengguna(rs.getInt("idpengguna"));
                logLogin.add(ep);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null,"Terjadi kesalahan pencarian pada ID:\n"+a);   
        }
        return logLogin;
    }
    public List cariLogin(String username,String password){
        List logLogin = new ArrayList();
        int result;
        sql="select username,password,hakakses from pengguna where username='"+username+"', password='"+password+"' and password='"+password+"'";
        try{
            rs=st.executeQuery(sql);

            while(rs.next()){
                EntitasPengguna ep=new EntitasPengguna();
                ep.setUsername(rs.getString("username"));
                ep.setPassword(rs.getString("password"));
                ep.setHakakses(rs.getString("hakakses"));
                logLogin.add(ep);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan login, pada :\n"+a);
        }
        return logLogin;
}
    
    public int tambah(EntitasPengguna e){
        sql="insert into pengguna values('"+e.getPassword()+"','"+e.getHakakses()+"','"+e.getUsername()+"',null)";
        int hasil=0;
        try{
            hasil=st.executeUpdate(sql);
        } catch(SQLException a){
            Logger.getLogger(ZakatControl.class.getName()).log(Level.SEVERE,null,a);
        }
        return hasil;
    }
    public List cariPengguna(String cari){
        List logPengguna = new ArrayList();
        sql="select idpengguna,username,password,hakakses from pengguna where idpengguna like '%"+cari+"%' or username like '%"+cari+"%'";
        try{
            rs=st.executeQuery(sql);

            while(rs.next()){
                EntitasPengguna eb=new EntitasPengguna();
                eb.setIdpengguna(rs.getInt("idpengguna"));
                eb.setUsername(rs.getString("username"));
                eb.setPassword(rs.getString("password"));
                eb.setHakakses(rs.getString("hakakses"));
                logPengguna.add(eb);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan tampil, pada :\n"+a);
        }
        return logPengguna;
    }
  public int deletePengguna(EntitasPengguna e){
        sql="delete from Pengguna where username='"+e.getUsername()+"'";
        int hasil=0;
        try{
            hasil=st.executeUpdate(sql);
        } catch(SQLException a){
            Logger.getLogger(PenggunaControl.class.getName()).log(Level.SEVERE,null,a);
        }
        return hasil;
    }
  
    
    /*public static void main(String[] args) {
        // TODO code application logic here

    }*/


}
