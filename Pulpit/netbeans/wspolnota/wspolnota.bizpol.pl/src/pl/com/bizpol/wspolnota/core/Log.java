/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.core;

import java.sql.Timestamp;

/**
 *
 * @author Archii
 */
public class Log {
    private int id;
    private int userId;
    private String tableName;
    private int dataId;
    private String oldValues;
    private String newValues;
    private Timestamp date;
    
    public Log(int id, int userId, String tableName, int dataId, String oldValues, String newValues , Timestamp date){
        super();
         this.id = id;
         this.userId = userId;
         this.tableName = tableName;
         this.dataId = dataId;
         this.oldValues = oldValues;
         this.newValues = newValues;
         this.date = date;
    }
    
    public int getId(){
        return id;
    }
    
    public int setId(){
        return this.id;
    }
    
    public int getUserId(){
        return userId;
    }
    
    public int setUserId(){
        return this.userId;
    }
    
    public String getTableName(){
        return tableName;
    }
    
    public String setTableName(){
        return this.tableName;
    }
    
    public int getDataId(){
        return dataId;
    }
    
    public int setDataId(){
        return this.dataId;
    }
    
    public String getOldValues(){
        return oldValues;
    }
    
    public String setOldValues(){
        return this.oldValues;
    }
    
    public String getNewValues(){
        return newValues;
    }
    
    public String setNewValues(){
        return this.newValues;
    }
    
    public Timestamp getDate(){
        return date;
    }
    
    public Timestamp setDate(){
        return this.date;
    }
    
    @Override
    public String toString() {
        return String
                .format("Log [id=%s, userId=%s, tableName=%s, dataId=%s, oldValues=%s, newValues=%s, date=%s]", id, userId, tableName, dataId, oldValues, newValues, date);
    }
    
}
