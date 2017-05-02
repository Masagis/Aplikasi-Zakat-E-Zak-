/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejak.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author dimasgs
 */
public class ReportControl {
    Connection conn=null;
    Statement st=null;
    ResultSet rs=null;
    String sql=null;
    public Connection connection;
    
       public void ReportControl(){
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
       
       public void cetakSeleruhBarang(){
        try{
        String sumber;
        String tujuan;
        sumber= "src/Ejak/ReportSumber/HargaZakat.jrxml";
        tujuan = "src/Ejak/ReportHasil/HargaZakat.html";
        Map params = new HashMap();
        JasperReport jr = JasperCompileManager.compileReport(sumber);
        JasperPrint jp = JasperFillManager.fillReport(jr,params,connection);
        JasperExportManager.exportReportToHtmlFile(jp, tujuan);
        JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Gagal tampilakn report"+ex);
        }
    
    
}
   public void cetakNota(String nonota){
         try{
        String sumber;
        String tujuan;
        sumber= "src/Ejak/ReportSumber/kwitansi.jrxml";
        tujuan = "src/Ejak/ReportHasil/kwitansi.html";
        Map params = new HashMap();
        params.put("beli_nonota", nonota);
        JasperReport jr = JasperCompileManager.compileReport(sumber);
        JasperPrint jp = JasperFillManager.fillReport(jr,params,conn);
        JasperExportManager.exportReportToHtmlFile(jp, tujuan);
        JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Gagal tampilakn report"+ex);
        }
    }
           public static void main(String[] args) {
        // TODO code application logic here

    }
    
}
