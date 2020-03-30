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
import pl.com.bizpol.wspolnota.core.Community;

public class CommunityDAO {

    private final Connection myConn;

    public CommunityDAO() throws Exception {

        // get db properties
        Properties props = new Properties();
        props.load(new FileInputStream("src/pl/com/bizpol/wspolnota/dao/db.properties"));

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String dburl = props.getProperty("dburl");

        // connect to database
        myConn = DriverManager.getConnection(dburl, user, password);

        System.out.println("CommunityDAO - DB connection successful to: " + dburl);
    }

    private Community convertRowToCommunity(ResultSet myRs) throws SQLException, Exception {

        int id = myRs.getInt("id");
        String name = myRs.getString("name");
        String short_name = myRs.getString("short_name");
        String street = myRs.getString("street");
        String street_no = myRs.getString("street_no");
        int city_id = myRs.getInt("city_id");
        int zone_id = myRs.getInt("zone_id");
        int country_id = myRs.getInt("country_id");
        int enabled = myRs.getInt("enabled");
        List<Integer> tenants = getCommunitiyTenantsId(id);
        
        Community community = new Community(id, name, short_name, street, street_no, city_id, zone_id, country_id, enabled, tenants);

        return community;
    }

    public Community getCommunity(int id) throws Exception {

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            Community community = new Community();
            myStmt = myConn.createStatement();

            String sql = "select * from community where id=" + id + " limit 1";

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {
                community = convertRowToCommunity(myRs);
            }

            return community;		
        }
        finally {
            DAOUtils.close(myStmt, myRs);
        }
    }	

    public List<Community> getAllCommunities() throws Exception {
            List<Community> list = new ArrayList<>();

            Statement myStmt = null;
            ResultSet myRs = null;

            try {
                    myStmt = myConn.createStatement();

                    String sql = "select * from community";			

                    myRs = myStmt.executeQuery(sql);

                    while (myRs.next()) {
                            Community community = convertRowToCommunity(myRs);
                            list.add(community);
                    }

                    return list;		
            }
            finally {
                    DAOUtils.close(myStmt, myRs);
            }
    }
    
    public List<Integer> getCommunitiyTenantsId(int id) throws Exception {
            List<Integer> list = new ArrayList<>();

            Statement myStmt = null;
            ResultSet myRs = null;

            try {
                    myStmt = myConn.createStatement();

                    String sql = "select id from community_tenants where community_id=" + id;			

                    myRs = myStmt.executeQuery(sql);

                    while (myRs.next()) {                            
                            list.add(myRs.getInt("id"));
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
    public void updateCommunity(Community community) throws Exception {
            PreparedStatement myStmt = null;

            try {
                    // prepare statement
                    myStmt = myConn.prepareStatement("update community"
                                    + " set name=?, short_name=?, street=?, street_no=?, city_id=?, zone_id=?, country_id=?, enabled=?"
                                    + " where id=?");

                    // set params
                    myStmt.setString(1, community.getName());
                    myStmt.setString(2, community.getShortName());                        
                    myStmt.setString(3, community.getStreet());
                    myStmt.setString(4, community.getStreetNo());
                    myStmt.setInt(5, community.getCityId());
                    myStmt.setInt(6, community.getCountryId());
                    myStmt.setInt(7, community.getZoneId());
                    myStmt.setInt(8, community.getEnabled());
                    myStmt.setInt(9, community.getId());

                    // execute SQL
                    myStmt.executeUpdate();

            }
            finally {
                    DAOUtils.close(myStmt);
            }		
    }
}
