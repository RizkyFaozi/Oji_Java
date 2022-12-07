/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.*;

/**
 *
 * @author ASUS
 */
public class Masyarakat extends MainModels {
    private final String[] columns = {
        "nik",
        "nama",
        "username",
        "password",
        "telp"
    };
    
    public ResultModel dataAkun(String username) {
        ResultSet dataMasyarakat = this.querySelect("SELECT * FROM masyarakat WHERE username = '" +username+ "'");
        
        try {
            if(!dataMasyarakat.next()) {
                return null;
            }
            
            return new ResultModel(this.columns, new String[] {
                dataMasyarakat.getString("nik"),
                dataMasyarakat.getString("nama"),
                dataMasyarakat.getString("username"),
                dataMasyarakat.getString("password"),
                dataMasyarakat.getString("telp"),
            });
            
        } catch(SQLException e) {
            System.out.println("P, " + e.getMessage());
            return null;
        }
    }
    
    public boolean register(String akun[]) {
        return this.queryManipulation("INSERT INTO masyarakat (nik, nama, username, password, telp) VALUES ('"
            + akun[0] + "', '"
            + akun[1] + "', '"
            + akun[2] + "', '"
            + akun[3] + "', '"
            + akun[4] + "')");
    }
}
