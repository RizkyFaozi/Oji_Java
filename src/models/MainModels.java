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
public class MainModels {
    public Connection conn;
            
    public MainModels() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pengaduan_masyarakat", "root", "");
            
        } catch(SQLException e) {
            System.out.println("eror");
            System.out.println(e.getMessage());
        }
    }
    
    public ResultSet querySelect(String sql) {
        try {
            Statement stmt = this.conn.createStatement();
            return stmt.executeQuery(sql);
            
        } catch(SQLException e) {
            System.out.println("Gagal Koneksinya, " + e.getMessage());
            return null;
        }
    }
    
    public boolean queryManipulation(String sql) {
        try {
            Statement stmt = this.conn.createStatement();
            stmt.executeUpdate(sql);
            return true;
            
        } catch(SQLException e) {
            System.out.println("Gagal Load data, " + e.getMessage());
            return false;
        }
    } 
    
    public int numRows(String sql) {
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet exec = stmt.executeQuery(sql);
            int rows = 0;
            
            while(exec.next()) {
                rows++;
            }
            
            return rows;
            
        } catch(SQLException e) {
            System.out.println("Gagal Koneksi, " + e.getMessage());
            return 0;
        }
    }
}
