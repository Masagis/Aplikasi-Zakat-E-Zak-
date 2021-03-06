/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejak.GUI;

import Ejak.koneksi.Waktu;
import com.mysql.jdbc.Connection;
import connection.koneksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dimasgs
 */
public class Zakater extends javax.swing.JFrame {
    private Connection koneksi;
        private final koneksi db = new koneksi();
        private DefaultTableModel Tabelcd;
    /**
     * Creates new form ReportBarang
     */
    public Zakater() {
        initComponents();
        waktu();
        setLocationRelativeTo(null);
        Tabelcd = new DefaultTableModel();
        Tabelcd.addColumn("Nama");
        Tabelcd.addColumn("Jumlah Zakat");
        Tabelcd.addColumn("Tipe Zakat");
    }
    void waktu ()
    {
        try
        {
            Waktu objwaktu = new Waktu();
            //System.out.println ( "bisa mengambil waktu ");
            tanggal.setText(objwaktu.getWaktu());
        }
        catch (Exception e)
        {
            System.out.println ("Gagal ambil waktu"+e);
        }
      ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        String nol_jam = "";
        String nol_menit = "";
        String nol_detik = "";
        Date dt = new Date();
        int nilai_jam = dt.getHours();
        int nilai_menit = dt.getMinutes();
        int nilai_detik = dt.getSeconds();
        // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
        if (nilai_jam <= 9) {
          // Tambahkan "0" didepannya
          nol_jam = "0";
        }
        // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
        if (nilai_menit <= 9) {
          // Tambahkan "0" didepannya
          nol_menit = "0";
        }
        // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
        if (nilai_detik <= 9) {
          // Tambahkan "0" didepannya
          nol_detik = "0";
        }
        // Membuat String JAM, MENIT, DETIK
        String jam = nol_jam + Integer.toString(nilai_jam);
        String menit = nol_menit + Integer.toString(nilai_menit);
        String detik = nol_detik + Integer.toString(nilai_detik);
        // Menampilkan pada Layar
        tampil_jam.setText("" + jam + " : " + menit + " : " + detik + "  ");
    }
    };
      new Timer(1000, taskPerformer).start();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        tampil_jam = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        user = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tampil = new javax.swing.JButton();
        hapusAll = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        back = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(431, 354));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(87, 188, 188));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Waree", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Zakater");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 50));

        tanggal.setFont(new java.awt.Font("Liberation Sans Narrow", 1, 18)); // NOI18N
        tanggal.setText("Tanggal");
        jPanel1.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        tampil_jam.setFont(new java.awt.Font("Liberation Sans Narrow", 1, 18)); // NOI18N
        tampil_jam.setText("Jam");
        jPanel1.add(tampil_jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 60));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama ", "Jumlah Zakat", "Tipe Zakat"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 390, 100));
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 140, 30));

        jLabel4.setText("Nama Pengguna");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 30));

        tampil.setText("Tampil");
        tampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilActionPerformed(evt);
            }
        });
        getContentPane().add(tampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        hapusAll.setText("Hapus Semua");
        hapusAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusAllActionPerformed(evt);
            }
        });
        getContentPane().add(hapusAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });
        getContentPane().add(Hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        back.setForeground(new java.awt.Color(1, 1, 1));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ejak/gambar/User-Interface-Logout-icon.png"))); // NOI18N
        back.setText("Kembali");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ejak/gambar/backgroud login.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 360));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ejak/gambar/backgroud login.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, -2, 230, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        MenuUtama a = new MenuUtama();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_backMouseClicked

    private void tampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilActionPerformed
        // TODO add your handling code here:
        db.dbConnection();
        Tabelcd.getDataVector().removeAllElements();
        try{
            Statement st = db.getConnection().createStatement();
            String sql =  " SELECT * FROM bayar";
            JOptionPane.showMessageDialog(null,"Sukses");
            java.sql.ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Object [] data = new Object[3];
                data[0] = res.getString("pembayar");
                data[1] = res.getString("total");
                data[2] = res.getString("tipe_zakat");
                for (int i = 0; i<3; i++){
                    System.out.println("Array "+i+" = " +data [i]);
                }
                Tabelcd.addRow(data);
            }
            res.close();
            st.close();
         } catch (SQLException ex) {
            Logger.getLogger(ezak.Daftar.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTable1.setModel(Tabelcd);
    }//GEN-LAST:event_tampilActionPerformed

    private void hapusAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusAllActionPerformed
        // TODO add your handling code here:
        db.dbConnection();
        Tabelcd.getDataVector().removeAllElements();
        try{
            String sql = " DELETE FROM bayar"; 
            Statement st = db.getConnection().createStatement();
            int confirm =JOptionPane.showConfirmDialog(this,
            "Yakin untuk menghapus data ini?",
            "Konfirmasi Hapus ",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if (confirm==JOptionPane.YES_OPTION) {
            st.executeUpdate(sql);
            }
            JOptionPane.showMessageDialog(null, "Hapus Berhasil");
            String sql2 =  " SELECT * FROM bayar";
            //JOptionPane.showMessageDialog(null,"Sukses");
            Statement st2 = db.getConnection().createStatement();
            java.sql.ResultSet res1 = st2.executeQuery(sql2);
            while(res1.next()){
                Object [] data1 = new Object[2];
                data1[0] = res1.getString("user");
                data1[1] = res1.getString("jumlah_zakat");
                data1[2] = res1.getString("tipe_zakat");
                for (int i = 0; i<3; i++){    
                    System.out.println("Array "+i+" = " +data1 [i]);
                }
                Tabelcd.addRow(data1);
            }
            res1.close();
            st.close();
             
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Penghapusan gagal"+e);
}jTable1.setModel(Tabelcd);
    }//GEN-LAST:event_hapusAllActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        // TODO add your handling code here:
     try
        {
            Ejak.koneksi.koneksi objkoneksi = new Ejak.koneksi.koneksi();
            java.sql.Connection con = objkoneksi.bukakoneksi();
            Statement st = db.getConnection().createStatement();
            String sql = "delete from bayar where pembayar= '"+user.getText()+"'";
            int confirm =JOptionPane.showConfirmDialog(this,
            "Yakin untuk menghapus data ini?",
            "Konfirmasi Hapus ",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if (confirm==JOptionPane.YES_OPTION) {
            int row = st.executeUpdate(sql);
            if (row ==1)
            {
                JOptionPane.showMessageDialog(null,"data sudah dihapus dari database","informasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }}}

        catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null, "data tidak dihapus"+e,"informasi",JOptionPane.INFORMATION_MESSAGE);
        }   
    }//GEN-LAST:event_HapusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Zakater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Zakater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Zakater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Zakater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Zakater().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hapus;
    private javax.swing.JLabel back;
    private javax.swing.JButton hapusAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton tampil;
    private javax.swing.JLabel tampil_jam;
    private javax.swing.JLabel tanggal;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
