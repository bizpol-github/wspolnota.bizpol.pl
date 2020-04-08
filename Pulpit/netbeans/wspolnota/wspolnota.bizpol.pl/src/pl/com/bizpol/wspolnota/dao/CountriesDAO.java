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
import java.util.Vector;
import pl.com.bizpol.wspolnota.core.Country;

/**
 *
 * @author Archii
 */
public class CountriesDAO {
    private final Connection myConn;
    
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
    public void addCountry(Country theCountry) throws SQLException {
        
        PreparedStatement myStmt = null;
        
        try {
            myStmt = myConn.prepareStatement("insert into countries" + " (countries_name, countries_iso_code_2, countries_iso_code_3, address_format)" + " values (?, ?, ?, ?)");
            myStmt.setString(1, theCountry.getCountriesName());
            myStmt.setString(1, theCountry.getIsoCode2());
            myStmt.setString(1, theCountry.getIsoCode3());
            myStmt.setString(1, theCountry.getAddressFormat());
            myStmt.executeUpdate();            
                        
        } finally {
            DAOUtils.close(myStmt);          
        }    
        
    }
    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Country getCountry(int id) throws Exception {
        
        Statement myStmt = null;
        ResultSet myRs = null;
        
        
        try {
            Country tempCountries = null;
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from countries where countries_id=" + id + " limit 1");
            
            while (myRs.next()) {
                tempCountries = convertRowToCountries(myRs);                
            }                      
            return tempCountries;
        } finally {
            DAOUtils.close(myStmt, myRs);            
        }    
    }
    
    
    /**
     *
     * @return
     * @throws Exception
     */
    public List<Country> getAllCountries() throws Exception {
        List<Country> list = new ArrayList<>();
        
        Statement myStmt = null;
        ResultSet myRs = null;        
        
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from countries");
            
            while (myRs.next()) {
                Country tempCountries = convertRowToCountries(myRs);
                list.add(tempCountries);                
            }
            
            return list;
            
        } finally {
            DAOUtils.close(myStmt, myRs);            
        }    
    }
    
    /**
     *
     * @return
     * @throws Exception
     */
    public Vector getVectorCountries() throws Exception {
        return convertListToVector(getAllCountries());
    }
    
    /**
     *
     * @param countriesName
     * @return
     * @throws Exception
     */
    public List<Country> searchCountries(String countriesName) throws Exception {
        List<Country> list = new ArrayList<>();
        
        PreparedStatement myStmt = null;
        ResultSet myRs = null;        
        
        try {
            countriesName += "%";
            myStmt = myConn.prepareStatement("select * from countries where countries_name like ?");
            myStmt.setString(1, countriesName);            
            myRs = myStmt.executeQuery();
            
            while (myRs.next()) {
                Country tempCountries = convertRowToCountries(myRs);
                list.add(tempCountries);                
            }
            
            return list;
            
        } finally {
            DAOUtils.close(myStmt, myRs);            
        }    
    }

    private Country convertRowToCountries(ResultSet myRs) throws SQLException {
        int id = myRs.getInt("countries_id");
        String countriesName = myRs.getString("countries_name");
        String isoCode2 = myRs.getString("countries_iso_code_2");
        String isoCode3 = myRs.getString("countries_iso_code_3");
        String addressFormat = myRs.getString("address_format");
    	Country tempCountries = new Country(id, countriesName, isoCode2, isoCode3, addressFormat);
		
        return tempCountries;
    }
    
    private Vector convertListToVector(List list) throws SQLException {
        
        Vector model = new Vector();
        
        int i=0;
        
        for (Object country : list) {
            
            model.add(i, country);
            i++;
        }
		
        return model;
    }   

}
