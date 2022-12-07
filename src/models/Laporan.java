/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.*;

/**
 *
 * @author PC-12
 */
public class Laporan extends MainModels {
    private final String[] columns = {
        "id_pengaduan",
        "nik",
        "tgl_pengaduan",
        "subjek",
        "isi_laporan",
        "status",
        "nama_masyarakat",
    };
    
    public ResultModel[] allLaporan() {
        String sql = "SELECT * FROM pengaduan";
        int countLaporan = this.numRows(sql);
        ResultSet dataLaporan = this.querySelect(sql);
        
        ResultModel[] result = new ResultModel[countLaporan];
        int i=0;
        
        try {
            while(dataLaporan.next()) {
                result[i] = new ResultModel(this.columns, new String[] {
                    dataLaporan.getString("id_pengaduan"),
                    dataLaporan.getString("nik"),
                    dataLaporan.getString("tgl_pengaduan"),
                    dataLaporan.getString("subjek"),
                    dataLaporan.getString("isi_laporan"),
                    dataLaporan.getString("status"),
                });
            
                i++;
            }
            
            return result;
        } catch(SQLException e) {
            System.out.println("Gagal mendapatkan seluruh data laporan, " + e.getMessage());
            return null;
        }
    }
    
    public ResultModel[] allLaporanPetugas() {
        String sql = "SELECT pengaduan.*, masyarakat.nama AS nama_masyarakat FROM pengaduan LEFT JOIN masyarakat ON masyarakat.nik = pengaduan.nik";
        int countLaporan = this.numRows(sql);
        ResultSet dataLaporan = this.querySelect(sql);
        
        ResultModel[] result = new ResultModel[countLaporan];
        int i=0;
        
        try {
            while(dataLaporan.next()) {
                result[i] = new ResultModel(this.columns, new String[] {
                    dataLaporan.getString("id_pengaduan"),
                    dataLaporan.getString("nik"),
                    dataLaporan.getString("tgl_pengaduan"),
                    dataLaporan.getString("subjek"),
                    dataLaporan.getString("isi_laporan"),
                    dataLaporan.getString("status"),
                    dataLaporan.getString("nama_masyarakat"),
                });
            
                i++;
            }
            
            return result;
        } catch(SQLException e) {
            System.out.println("Gagal mendapatkan seluruh data laporan, " + e.getMessage());
            return null;
        }
    }
    
    public boolean tambah(String[] dataLaporan) {
        return this.queryManipulation("INSERT INTO pengaduan (nik, tgl_pengaduan, subjek, isi_laporan, status) VALUES ('"
            + dataLaporan[0] + "', '"
            + dataLaporan[1] + "', '"
            + dataLaporan[2] + "', '"
            + dataLaporan[3] + "', '"
            + dataLaporan[4] + "')");
    }
    
    public boolean delete(String id) {
        this.queryManipulation("DELETE FROM tanggapan WHERE id_pengaduan = '" +id+ "'");
        return this.queryManipulation("DELETE FROM pengaduan WHERE id_pengaduan = '" +id+ "'");
    }
    
    public boolean verifikasi(String id) {
        return this.queryManipulation("UPDATE pengaduan SET status = 'proses' WHERE id_pengaduan = '" +id+ "'");
    }
}
