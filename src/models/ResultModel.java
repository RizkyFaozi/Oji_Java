/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ASUS
 */
public class ResultModel {
    private String[] columnsName;
    private String[] tableData;
    
    public ResultModel(String cName[], String tData[]) {
        this.columnsName = cName;
        this.tableData = tData;
    }
    
    public String dByIndex(int index) {
        return this.tableData[ index ];
    }
    
    private int getIndexColumn(String columnName) {
        for(int i=0; i < this.columnsName.length; i++) {
            String cColumn = this.columnsName[ i ];
            if(cColumn.equals(columnName)) {
                return i;
            }
        }
        
        return -1;
    }
    
    public String dByColumn(String columnName) {
        int indexColumn = this.getIndexColumn(columnName);
        if(indexColumn < 0) {
            return null;
        }
        
        return this.dByIndex(indexColumn);
    }
    
    public String[] all() {
        return this.tableData;
    }
}
