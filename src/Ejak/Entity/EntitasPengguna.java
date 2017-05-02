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
public class EntitasPengguna {
    String username,password,hakakses;
    int idpengguna;


public String getHakakses() {
        return hakakses;
    }

public void setHakakses(String hakakses) {
        this.hakakses = hakakses;
    }

public int getIdpengguna() {
        return idpengguna;
    }

public void setIdpengguna(int idpengguna) {
        this.idpengguna = idpengguna;
    }

public String getPassword() {
        return password;
    }

public void setPassword(String password) {
        this.password = password;
    }

public String getUsername() {
        return username;
    }

public void setUsername(String username) {
        this.username = username;
    }
}
