/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import pl.com.bizpol.wspolnota.core.Countries;

/**
 *
 * @author Archii
 */
public class CountriesDAO {
    private Connection myConn;
    
    /**
     *
     * @throws Exception
     */
    public CountriesDAO() throws Exception {
        
        //get db propereties
        Properties props = new Properties();
        props.load(new FileInputStream("src/pl/com/bizpol/wspolnota/dao/db.properties"));
        
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String dburl = props.getProperty("dburl");
        
        System.out.println("Użytkownik -> " + user);
        
        //connect
        myConn = DriverManager.getConnection(dburl,user,password);
        System.out.println("Countries DAO Połączony z: " + dburl);
        
    }
    
    /**
     *
     * @param theCountry
     * @throws SQLException
     */
    public void addCountry(Countries theCountry) throws SQLException {
        
        PreparedStatement myStmt = null;
        
        try {
            myStmt = myConn.prepareStatement("insert into countries" + " (countries_name, countries_iso_code_2, countries_iso_code_3, address_format)" + " values (?, ?, ?, ?)");
            myStmt.setString(1, theCountry.getCountriesName());
            myStmt.setString(1, theCountry.getIsoCode2());
            myStmt.setString(1, theCountry.getIsoCode3());
            myStmt.setString(1, theCountry.getAddressFormat());
            myStmt.executeUpdate();            
                        
        } finally {
            close(myStmt);            
        }    
        
    }
    
    /**
     *
     * @return
     * @throws Exception
     */
    public List<Countries> getAllCountries() throws Exception {
        List<Countries> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRs = null;        
        
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from countries");
            
            while (myRs.next()) {
                Countries tempCountries = convertRowToCountries(myRs);
                list.add(tempCountries);                
            }
            
            return list;
            
        } finally {
            close(myStmt, myRs);            
        }    
    }
    
    /**
     *
     * @param countriesName
     * @return
     * @throws Exception
     */
    public List<Countries> searchCountries(String countriesName) throws Exception {
        List<Countries> list = new ArrayList<>();
        
        PreparedStatement myStmt = null;
        ResultSet myRs = null;        
        
        try {
            countriesName += "%";
            myStmt = myConn.prepareStatement("select * from countries where countries_name like ?");
            myStmt.setString(1, countriesName);            
            myRs = myStmt.executeQuery();
            
            while (myRs.next()) {
                Countries tempCountries = convertRowToCountries(myRs);
                list.add(tempCountries);                
            }
            
            return list;
            
        } finally {
            close(myStmt, myRs);            
        }    
    }

    private Countries convertRowToCountries(ResultSet myRs) throws SQLException {
        int id = myRs.getInt("countries_id");
        String countriesName = myRs.getString("countries_name");
        String isoCode2 = myRs.getString("countries_iso_code_2");
        String isoCode3 = myRs.getString("countries_iso_code_3");
        String addressFormat = myRs.getString("address_format");
    	Countries tempCountries = new Countries(id, countriesName, isoCode2, isoCode3, addressFormat);
		
        return tempCountries;
    }

    private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {

        if (myRs != null) {
                myRs.close();
        }

        if (myStmt != null) {

        }

        if (myConn != null) {
                myConn.close();
        }
    }
    
    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }
    
    private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null);		
	}
    
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
		
        CountriesDAO dao = new CountriesDAO();
        System.out.println(dao.searchCountries("poland"));

        System.out.println(dao.getAllCountries());
    }
}
