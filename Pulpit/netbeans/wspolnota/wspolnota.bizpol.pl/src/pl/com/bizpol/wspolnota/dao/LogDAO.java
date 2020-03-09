/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.dao;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 *
 * @author netcom
 */
public class LogDAO {
    
    private Connection myConn;
    
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
    
    public void EnterLog(int user_id, String table_name, Object old_value, Object new_value) throws Exception{
        
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
					+ " (user_id, table_name, old_values, new_values)"
					+ " values (?, ?, ?, ?)");
			
			// set params
			myStmt.setInt(1, user_id);
			myStmt.setString(2, table_name);
                        myStmt.setObject(3, byteOld);                        
			myStmt.setObject(4, byteNew);
			
			// execute SQL
			myStmt.executeUpdate();				
		}
		finally {
			DAOUtils.close(myStmt);
		}
        
    }
    
    public void logInsert(){
        
    }
    
    public void logUpdate(){
        
    }
    
    public void logDelete(){
        
    }
}
