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
    private String userName = "";
    private String tableName;
    private int dataId;
    private Object oldValues;
    private Object newValues;
    private Timestamp date;
    
    public Log(int id, int userId, String tableName, int dataId, Object oldValues, Object newValues , Timestamp date){
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
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getUserId(){
        return userId;
    }
    
    public void setUserId(int userId){
        this.userId=userId;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getTableName(){
        return tableName;
    }
    
    public void setTableName(String tableName){
        this.tableName=tableName;
    }
    
    public int getDataId(){
        return dataId;
    }
    
    public void setDataId(int dataId){
        this.dataId = dataId;
    }
    
    public Object getOldValues(){
        return oldValues;
    }
    
    public void setOldValues(Object oldValues){
        this.oldValues = oldValues;
    }
    
    public Object getNewValues(){
        return newValues;
    }
    
    public void setNewValues(Object newValues){
        this.newValues = newValues;
    }
    
    public Timestamp getDate(){
        return date;
    }
    
    public void setDate(Timestamp date){
        this.date = date;
    }
    
    @Override
    public String toString() {
        return String
                .format("Log [id=%s, userId=%s, userName=%s, tableName=%s, dataId=%s, oldValues=%s, newValues=%s, date=%s]", id, userId, userName, tableName, dataId, oldValues, newValues, date);
    }
    
}
