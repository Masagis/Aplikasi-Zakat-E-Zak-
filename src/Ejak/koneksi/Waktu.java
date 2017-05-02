/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejak.koneksi;

import java.util.Calendar;

/**
 *
 * @author dimasgs
 */
public class Waktu {
    public Waktu(){};
private Calendar calendar = Calendar.getInstance();

public String getWaktu() {

String hari;
String tanggal;
String bulan;
String tahun;
//hari = getHari();
tanggal = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
bulan = String.valueOf(calendar.get(Calendar.MONTH));
int bln = Integer.parseInt(bulan);
int bul = bln+1;
tahun = String.valueOf(calendar.get(Calendar.YEAR));
//return (hari + ", " + tanggal + " " + bulan + " " + tahun);
return (tanggal + "-" + bul + "-" + tahun);

}
}
