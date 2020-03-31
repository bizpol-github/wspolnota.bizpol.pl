/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import pl.com.bizpol.wspolnota.core.Log;
import static pl.com.bizpol.wspolnota.dao.DAOUtils.close;

/**
 *
 * @author netcom
 */
public class LogDAO {
    
    private final Connection myConn;
    
    /**
     *
     * @throws Exception
     */
    public LogDAO() throws Exception{
        
        // get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("src/pl/com/bizpol/wspolnota/dao/db.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("LogDAO - DB connection successful to: " + dburl);
        
        
    }
    
    /**
     *
     * @param user_id
     * @param table_name
     * @param data_id
     * @param old_value
     * @param new_value
     * @throws Exception
     */
    public void EnterLog(int user_id, String table_name, int data_id, Object old_value, Object new_value) throws Exception{
        
        PreparedStatement myStmt = null;
        
        ByteArrayOutputStream baosOld, baosNew;
        ObjectOutputStream outOld, outNew;
        baosOld = new ByteArrayOutputStream();
        baosNew = new ByteArrayOutputStream();
        try {
            outOld = new ObjectOutputStream(baosOld);
            outOld.writeObject(old_value);
            outOld.close();
            outNew = new ObjectOutputStream(baosNew);
            outNew.writeObject(new_value);
            outNew.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] byteOld = baosOld.toByteArray();
        byte[] byteNew = baosNew.toByteArray();

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into log"
					+ " (user_id, table_name, data_id, old_values, new_values)"
					+ " values (?, ?, ?, ?, ?)");
			
			// set params
			myStmt.setInt(1, user_id);
			myStmt.setString(2, table_name);
                        myStmt.setInt(3, data_id);
                        myStmt.setObject(4, byteOld);                        
			myStmt.setObject(5, byteNew);
			
			// execute SQL
			myStmt.executeUpdate();				
		}
		finally {
			DAOUtils.close(myStmt);
		}
        
    }
    
    /**
     *
     * @param table_name
     * @param content_id
     * @return
     * @throws Exception
     */
    public List<Log> getAllLogsById(String table_name, int content_id) throws Exception {
        
        
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        List<Log> list = new ArrayList<>();
        
        try {
            myStmt = myConn.prepareStatement("select l.*, u.display_name as user_name from log l, users u "
                    + "where l.table_name=? and l.data_id=? and l.user_id=u.ID");            
            myStmt.setString(1, table_name);
            myStmt.setInt(2, content_id);
            myRs = myStmt.executeQuery();
            
            while (myRs.next()) {
              
                Log tempLog = convertRowToLogs(myRs);
                list.add(tempLog);                  
            }
            
            return list;
            
        } finally {
            close(myStmt, myRs);            
        }
        
    }
    
//    public List<Object> searchLogs(String countriesName) throws Exception {
//        List<Object> list = new ArrayList<>();
//        
//        PreparedStatement myStmt = null;
//        ResultSet myRs = null;        
//        
//        try {
//            countriesName += "%";
//            myStmt = myConn.prepareStatement("select * from log where countries_name like ?");
//            myStmt.setString(1, countriesName);            
//            myRs = myStmt.executeQuery();
//            
//            while (myRs.next()) {
//                Log tempLog = convertRowToLogs(myRs);
//                list.add(tempLog);                
//            }
//            
//            return list;
//            
//        } finally {
//            close(myStmt, myRs);            
//        }    
//    }

    /**
     *
     * @param myRs
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    
    public Log convertRowToLogs(ResultSet myRs) throws SQLException, ClassNotFoundException, IOException{
        
        ByteArrayInputStream baisOld, baisNew;
        ObjectInputStream inOld, inNew;     
        
        int id = myRs.getInt("id");
        int userId = myRs.getInt("user_id");
        int dataId = myRs.getInt("data_id");
        String userName = myRs.getString("user_name");
        String tableName = myRs.getString("table_name");
        
        String name = tableName.substring(0, 1).toUpperCase() + tableName.substring(1);
        Object objOld = Class.forName("pl.com.bizpol.wspolnota.core." + name);
        Object objNew = Class.forName("pl.com.bizpol.wspolnota.core." + name);        
        
        Object oldValues = myRs.getObject("old_values");
        baisOld = new ByteArrayInputStream((byte[]) oldValues);
        inOld = new ObjectInputStream(baisOld);
        objOld = inOld.readObject();
        
        Object newValues = myRs.getObject("new_values");
        baisNew = new ByteArrayInputStream((byte[]) newValues);
        inNew = new ObjectInputStream(baisNew);
        objNew = inNew.readObject();
        
        Timestamp date = myRs.getTimestamp("date");
        
        System.out.println("data: " + date);
    	Log tempLog = new Log(id, userId, tableName, dataId, objOld.toString(), objNew.toString(), date);
        tempLog.setUserName(userName);
		
        return tempLog;
    }
    
    /**
     *
     */
    public void logInsert(){
        
    }
    
    /**
     *
     */
    public void logUpdate(){
        
    }
    
    /**
     *
     */
    public void logDelete(){
        
    }
}
