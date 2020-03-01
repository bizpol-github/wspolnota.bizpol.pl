package pl.com.bizpol.wspolnota.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import pl.com.bizpol.wspolnota.core.CommiunityTenant;

public class CommiunityTenantDAO {

	private final Connection myConn;
	
	public CommiunityTenantDAO() throws Exception {
		
		// get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("src/pl/com/bizpol/wspolnota/dao/db.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("CommiunityTenantDAO - DB connection successful to: " + dburl);
	}
	
	private CommiunityTenant convertRowToCommiunityTenant(ResultSet myRs) throws SQLException {
		
            
        int id = myRs.getInt("id");
        int commiunity_id = myRs.getInt("commiunity_id");
	String name = myRs.getString("name");
	String last_name = myRs.getString("last_name");
	String email = myRs.getString("email");
	String tel = myRs.getString("tel");
                
		CommiunityTenant commiunityTenant = new CommiunityTenant(id, commiunity_id, name, last_name, email, tel);
		
		return commiunityTenant;
	}
        
        public CommiunityTenant getCommiunityTenant(int id) throws Exception {
		
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
                        CommiunityTenant commiunityTenant = new CommiunityTenant();
			myStmt = myConn.createStatement();
			
			String sql = "select * from commiunity_tenants"
                                + " where id=" + id + " limit 1";			
			
			myRs = myStmt.executeQuery(sql);
                        
                        while (myRs.next()) {
                        
                            commiunityTenant = convertRowToCommiunityTenant(myRs);
                        
                        }

			return commiunityTenant;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}
	}	
	
	public List<CommiunityTenant> getAllCommiunityTenants(int id) throws Exception {
		List<CommiunityTenant> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			
			String sql = "select * from commiunity_tenants where commiunity_id=" + id;			
			
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				CommiunityTenant commiunityTenant = convertRowToCommiunityTenant(myRs);
				list.add(commiunityTenant);
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
