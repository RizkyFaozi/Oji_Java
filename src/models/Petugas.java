package models;

import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Petugas extends MainModels {
    private final String[] columns = {
        "id_petugas",
        "nama_petugas",
        "username",
        "password",
        "telp",
        "level",
    };
    
    public ResultModel dataAkun(String username) {
        ResultSet dataPetugas = this.querySelect("SELECT * FROM petugas WHERE username = '" +username+ "'");
        try {
            if(!dataPetugas.next()) {
                return null;
            }
            
            return new ResultModel(this.columns, new String[] {
                dataPetugas.getString("id_petugas"),
                dataPetugas.getString("nama_petugas"),
                dataPetugas.getString("username"),
                dataPetugas.getString("password"),
                dataPetugas.getString("telp"),
                dataPetugas.getString("level"),
            });
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ResultModel[] allPetugas() {
        String sql = "SELECT * FROM petugas";
        int countPetugas = this.numRows(sql);
        ResultSet dataPetugas = this.querySelect(sql);
        
        ResultModel[] result = new ResultModel[countPetugas];
        int i=0;
        
        try {
            while(dataPetugas.next()) {
                result[i] = new ResultModel(this.columns, new String[] {
                    dataPetugas.getString("id_petugas"),
                    dataPetugas.getString("nama_petugas"),
                    dataPetugas.getString("username"),
                    dataPetugas.getString("password"),
                    dataPetugas.getString("telp"),
                    dataPetugas.getString("level"),
                });
            
                i++;
            }
            
            return result;
        } catch(SQLException e) {
            System.out.println("Gagal mendapatkan seluruh data petugas, " + e.getMessage());
            return null;
        }
    }
    
    public boolean tambah(String[] petugasBaru) {
        return this.queryManipulation("INSERT INTO petugas (nama_petugas, username, password, telp, level) VALUES ('"
                + petugasBaru[0] + "', '"
                + petugasBaru[1] + "', '"
                + petugasBaru[2] + "', '"
                + petugasBaru[3] + "', '"
                + petugasBaru[4] + "')");
    }
    
    public boolean edit(String id, String[] petugas) {
        return this.queryManipulation("UPDATE petugas SET nama_petugas = '"
                + petugas[0] + "', username = '"
                + petugas[1] + "', password = '"
                + petugas[2] + "', telp = '"
                + petugas[3] + "', level = '"
                + petugas[4] + "' WHERE id_petugas = '" +id+ "'");
    }
    
    public boolean delete(String id) {
        return this.queryManipulation("DELETE FROM petugas WHERE id_petugas = '" +id+ "'");
    }
}
