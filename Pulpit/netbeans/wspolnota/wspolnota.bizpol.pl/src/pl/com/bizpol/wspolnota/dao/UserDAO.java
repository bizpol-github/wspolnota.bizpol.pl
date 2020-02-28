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
import pl.com.bizpol.wspolnota.core.User;
import pl.com.bizpol.wspolnota.util.PasswordUtils;

public class UserDAO {

	private Connection myConn;
	
	public UserDAO() throws Exception {
		
		// get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("src/pl/com/bizpol/wspolnota/dao/db.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("UserDAO - DB connection successful to: " + dburl);
	}
	
	private User convertRowToUser(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("ID");
		String login = myRs.getString("user_login");
		String pass = myRs.getString("user_pass");
                String nicename = myRs.getString("user_nicename");
                String email = myRs.getString("user_email");
                int status = myRs.getInt("user_status");
                String display_name = myRs.getString("display_name");
                int parent = myRs.getInt("user_parent");
                
		User tempUser = new User(id, login, pass, nicename, email, status, display_name, parent);
		
		return tempUser;
	}
        
        public User getUser(int id) throws Exception {
		
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
                        User user = new User();
			myStmt = myConn.createStatement();
			
			String sql = "select * from users where ID=" + id + " limit 1";
			
			
			myRs = myStmt.executeQuery(sql);
                        
                        while (myRs.next()) {
                        
                            user = convertRowToUser(myRs);
                        
                        }

			return user;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}
	}	
	
	public List<User> getUsers(int status, int id) throws Exception {
		List<User> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			
			String sql = null;
			
			if (status == 0) {
				// get all users
				sql = "select * from users";
			}
			else {
				// only the current user
				sql = "select * from users where ID=" + id;
			}
			
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				User tempUser = convertRowToUser(myRs);
				list.add(tempUser);
			}

			return list;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}
	}	
	
	public void addUser(User theUser) throws Exception {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into users"
					+ " (user_login, user_pass, user_nicename, user_email, user_status)"
					+ " values (?, ?, ?, ?, ?)");
			
			// set params
			myStmt.setString(1, theUser.getLogin());
			myStmt.setString(2, theUser.getPass());
                        myStmt.setString(3, theUser.getNicename());                        
			myStmt.setString(3, theUser.getEmail());
			myStmt.setInt(4, theUser.getStatus());
			
			// encrypt password
			String encryptedPassword = PasswordUtils.encryptPassword(theUser.getPass());
			myStmt.setString(5, encryptedPassword);
			
			// execute SQL
			myStmt.executeUpdate();				
		}
		finally {
			DAOUtils.close(myStmt);
		}
		
	}
		
	
	public void updateUser(User theUser) throws Exception {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update users"
					+ " set user_login=?, user_nicename=?, user_email=?, user_status=?"
					+ " where ID=?");
			
			// set params
			myStmt.setString(1, theUser.getLogin());
                        myStmt.setString(2, theUser.getNicename());                        
			myStmt.setString(3, theUser.getEmail());
			myStmt.setInt(4, theUser.getStatus());
			myStmt.setInt(5, theUser.getId());
			
			// execute SQL
			myStmt.executeUpdate();

		}
		finally {
			DAOUtils.close(myStmt);
		}		
	}
        
        public int checkLogin(String login) throws Exception {
            int loginExists = 0;		
            PreparedStatement myStmt = null;
            ResultSet myRs = null;

            try {
                    myStmt = myConn.prepareStatement("select ID from users where user_login=?");
                    
                    myStmt.setString(1, login);                    
                    myRs = myStmt.executeQuery();
                    
                    while (myRs.next()) {
                        loginExists = myRs.getInt("ID");
                    }
                    
                    return loginExists;		
            }
            finally {
                    DAOUtils.close(myStmt, myRs);
            }
        }
	
	/**
	 * Return true if user's password is authenticated.
	 * 
         * @param user
	 * @return
         * @throws java.lang.Exception
	 */
	public boolean authenticate(User user) throws Exception {
		boolean result = false;
		
		String plainTextPassword = user.getPass();
		
		// get the encrypted password from database for this user
		String encryptedPasswordFromDatabase = getEncrpytedPassword(user.getLogin());
		
		// compare the passwords
		result = PasswordUtils.checkPassword(plainTextPassword, encryptedPasswordFromDatabase);
		
		return result;
	}

	private String getEncrpytedPassword(String login) throws Exception {
		String encryptedPassword = null;
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select user_pass from users where user_login=" + login);
			
			if (myRs.next()) {
				encryptedPassword = myRs.getString("user_pass");
			}
			else {
				throw new Exception("User id not found: " + login);
			}

			return encryptedPassword;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}		
	}

	public void changePassword(User user) throws Exception {

		// get plain text password
		String plainTextPassword = user.getPass();
		
		// encrypt the password
		String encryptedPassword = PasswordUtils.encryptPassword(plainTextPassword);
		
		// update the password in the database
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update users"
					+ " set user_pass=?"
					+ " where ID=?");
			
			// set params
			myStmt.setString(1, encryptedPassword);
			myStmt.setInt(2, user.getId());
			
			// execute SQL
			myStmt.executeUpdate();

		}
		finally {
			DAOUtils.close(myStmt);
		}		

	}	
}
