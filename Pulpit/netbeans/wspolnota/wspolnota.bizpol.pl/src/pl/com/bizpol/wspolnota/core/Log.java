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
    
    /**
     *
     * @param id
     * @param userId
     * @param tableName
     * @param dataId
     * @param oldValues
     * @param newValues
     * @param date
     */
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
    
    /**
     *
     * @return
     */
    public int getId(){
        return id;
    }
    
    /**
     *
     * @param id
     */
    public void setId(int id){
        this.id=id;
    }
    
    /**
     *
     * @return
     */
    public int getUserId(){
        return userId;
    }
    
    /**
     *
     * @param userId
     */
    public void setUserId(int userId){
        this.userId=userId;
    }
    
    /**
     *
     * @return
     */
    public String getUserName(){
        return userName;
    }
    
    /**
     *
     * @param userName
     */
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    /**
     *
     * @return
     */
    public String getTableName(){
        return tableName;
    }
    
    /**
     *
     * @param tableName
     */
    public void setTableName(String tableName){
        this.tableName=tableName;
    }
    
    /**
     *
     * @return
     */
    public int getDataId(){
        return dataId;
    }
    
    /**
     *
     * @param dataId
     */
    public void setDataId(int dataId){
        this.dataId = dataId;
    }
    
    /**
     *
     * @return
     */
    public Object getOldValues(){
        return oldValues;
    }
    
    /**
     *
     * @param oldValues
     */
    public void setOldValues(Object oldValues){
        this.oldValues = oldValues;
    }
    
    /**
     *
     * @return
     */
    public Object getNewValues(){
        return newValues;
    }
    
    /**
     *
     * @param newValues
     */
    public void setNewValues(Object newValues){
        this.newValues = newValues;
    }
    
    /**
     *
     * @return
     */
    public Timestamp getDate(){
        return date;
    }
    
    /**
     *
     * @param date
     */
    public void setDate(Timestamp date){
        this.date = date;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String
                .format("Log [id=%s, userId=%s, userName=%s, tableName=%s, dataId=%s, oldValues=%s, newValues=%s, date=%s]", id, userId, userName, tableName, dataId, oldValues, newValues, date);
    }
    
}
