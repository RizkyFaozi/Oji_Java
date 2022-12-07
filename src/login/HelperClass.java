/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Component;
import java.awt.Dimension;
import java.sql.Date;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author ASUS
 */
public class HelperClass {
    public static void centerTabelCell(JTable table) {
        int columnLength = table.getColumnCount();
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);
            
        for(int i=0; i < columnLength; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        
        table.selectAll();
        table.clearSelection();
    }
    
    public static void autoScroll(Component element, int elemetWidth, JFrame elementFrame) {
        final int MAX_HEIGHT = 504;
        
        JScrollPane scrollPane = new JScrollPane(element);
        scrollPane.setPreferredSize(new Dimension(elemetWidth, MAX_HEIGHT));
        elementFrame.setContentPane(scrollPane);
        elementFrame.pack();
    }
    
    public static void showAlert(JFrame parentFrame, int status, String message) {
        String titleDialog = (status == 1) ? "BERHASIL!" : "GAGAL";
        int dialogIcon = (status == 1) ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        JOptionPane.showMessageDialog(parentFrame, message, titleDialog, dialogIcon);
    }
    
    public static void logout(JFrame currentFrame) {
        showAlert(currentFrame, 0, "Logout berhasil!");
        currentFrame.setVisible(false);
        new loginn().setVisible(true);
    }
    
    public static void deleteRowTable(JTable table, int rowIndex) {
        DefaultTableModel tModel = (DefaultTableModel) table.getModel();
        tModel.removeRow(rowIndex);
    }
    
    public static String dateNow() {
        return new Date(System.currentTimeMillis()).toString();
    }
}
