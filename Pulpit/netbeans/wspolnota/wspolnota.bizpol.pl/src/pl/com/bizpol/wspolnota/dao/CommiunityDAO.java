package pl.com.bizpol.wspolnota.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import pl.com.bizpol.wspolnota.core.Commiunity;
import pl.com.bizpol.wspolnota.core.User;
import pl.com.bizpol.wspolnota.util.PasswordUtils;

public class CommiunityDAO {

	private final Connection myConn;
	
	public CommiunityDAO() throws Exception {
		
		// get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("src/pl/com/bizpol/wspolnota/dao/db.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("CommiunityDAO - DB connection successful to: " + dburl);
	}
	
	private Commiunity convertRowToCommiunity(ResultSet myRs) throws SQLException {
		
            
        int id = myRs.getInt("id");
	String name = myRs.getString("user_login");
	String short_name = myRs.getString("user_login");
	String street = myRs.getString("user_login");
	String street_no = myRs.getString("user_login");
	int city_id = myRs.getInt("city_id");
        int zone_id = myRs.getInt("zone_id");
        int country_id = myRs.getInt("country_id");
        int enabled = myRs.getInt("enabled");
                
		Commiunity commiunity = new Commiunity(id, name, short_name, street, street_no, city_id, zone_id, country_id, enabled);
		
		return commiunity;
	}
        
        public Commiunity getCommiunity(int id) throws Exception {
		
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
                        Commiunity commiunity = new Commiunity();
			myStmt = myConn.createStatement();
			
			String sql = "select * from commiunity where id=" + id + " limit 1";
			
			
			myRs = myStmt.executeQuery(sql);
                        
                        while (myRs.next()) {
                        
                            commiunity = convertRowToCommiunity(myRs);
                        
                        }

			return commiunity;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}
	}	
	
	public List<Commiunity> getAllCommiunity() throws Exception {
		List<Commiunity> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			
			String sql = "select * from commiunity";			
			
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				Commiunity commiunity = convertRowToCommiunity(myRs);
				list.add(commiunity);
			}

			return list;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}
	}	
	
//	public void addUser(User theUser) throws Exception {
//		PreparedStatement myStmt = null;
//
//		try {
//			// prepare statement
//			myStmt = myConn.prepareStatement("insert into users"
//					+ " (user_login, user_pass, user_nicename, user_email, user_status)"
//					+ " values (?, ?, ?, ?, ?)");
//			
//			// set params
//			myStmt.setString(1, theUser.getLogin());
//			myStmt.setString(2, theUser.getPass());
//                        myStmt.setString(3, theUser.getNicename());                        
//			myStmt.setString(3, theUser.getEmail());
//			myStmt.setInt(4, theUser.getStatus());
//			
//			// encrypt password
//			String encryptedPassword = PasswordUtils.encryptPassword(theUser.getPass());
//			myStmt.setString(5, encryptedPassword);
//			
//			// execute SQL
//			myStmt.executeUpdate();				
//		}
//		finally {
//			DAOUtils.close(myStmt);
//		}
//		
//	}
//		
//	
//	public void updateUser(User theUser) throws Exception {
//		PreparedStatement myStmt = null;
//
//		try {
//			// prepare statement
//			myStmt = myConn.prepareStatement("update users"
//					+ " set user_login=?, user_nicename=?, user_email=?, user_status=?"
//					+ " where ID=?");
//			
//			// set params
//			myStmt.setString(1, theUser.getLogin());
//                        myStmt.setString(2, theUser.getNicename());                        
//			myStmt.setString(3, theUser.getEmail());
//			myStmt.setInt(4, theUser.getStatus());
//			myStmt.setInt(5, theUser.getId());
//			
//			// execute SQL
//			myStmt.executeUpdate();
//
//		}
//		finally {
//			DAOUtils.close(myStmt);
//		}		
//	}
}
