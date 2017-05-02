/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejak.koneksi;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author dimasgs
 */
public class koneksi {
    public Connection conn=null;
    public Statement st=null;
    public ResultSet hasil=null;
    String SQL;

    private Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //<-- nama driver untuk koneksi ke MySQL

            // Cek Database
            try {
                String url, user, password;
                url = "jdbc:mysql://localhost:3306/ezak?autoReconnect=true&useSSL=false"; //alamat DB
                user = "root";
                password = "1234567890";
                connection = DriverManager.getConnection(url, user, password);

                System.out.println("Koneksi Sukses");
            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal! " + se);
                System.exit(0);
            }
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!" + cnfe);
            System.exit(0);
        }
        return connection;
    }

    public void dbConnection() { //<-- untuk koneksi ke database
        // Cek Driver
        try {
            Class.forName("com.mysql.jdbc.Driver"); //<-- nama driver untuk koneksi ke MySQL

            // Cek Database
            try {
                String url, user, password;
                url = "jdbc:mysql://localhost:3306/ezak?autoReconnect=true&useSSL=false"; //alamat DB
                user = "root";
                password = "1234567890";
                connection = DriverManager.getConnection(url, user, password);

                System.out.println("Koneksi Sukses");
            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal! " + se);
                System.exit(0);
            }
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!" + cnfe);
            System.exit(0);
        }
    }
    public ResultSet querySelectAll(String namaTabel, String kondisi) {

        getConnection();
        SQL = "SELECT * FROM " + namaTabel + "WHERE" +kondisi;
        System.out.println(SQL);
        return this.eksekusiQuery(SQL);

    }
    public ResultSet eksekusiQuery(String sql) {
        getConnection();
        ResultSet resultSet = null;
        try {
            st = connection.createStatement();
            resultSet = st.executeQuery(sql);
            System.out.println(sql);
        } catch (SQLException ex) {
        }
        return resultSet;
    }

    public Connection bukakoneksi () throws SQLException{
        Connection con = null;
        try
        {
                String url, user, password;
                url = "jdbc:mysql://localhost:3306/ezak?autoReconnect=true&useSSL=false"; //alamat DB
                user = "root";
                password = "1234567890";
                connection = DriverManager.getConnection(url, user, password);

                System.out.println("Koneksi Sukses");}
        catch (SQLException se)
        {
            System.out.println("No Connection Open");
            return null;
        }
        catch (Exception ex)
        {
            System.out.println("Couldn't open connection"+ex);
        }
  return null; 
}
}
