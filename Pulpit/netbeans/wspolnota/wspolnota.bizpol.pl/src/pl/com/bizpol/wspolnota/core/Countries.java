/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.core;

import pl.com.bizpol.wspolnota.dao.CountriesDAO;
import java.util.List;
import javax.swing.JComboBox;
import pl.com.bizpol.wspolnota.util.CountryComboBoxModel;
import pl.com.bizpol.wspolnota.util.CountryComboBoxRenderer;

/**
 *
 * @author Archii
 */
public class Countries {
    private final List<Country> list;
    private final CountriesDAO countriesDAO;
    
    /**
     *
     * @throws java.lang.Exception
     */
    public Countries() throws Exception{
        super();
        countriesDAO = new CountriesDAO();
        list = countriesDAO.getAllCountries();        
    }
    
    /**
     *
     * @return
     */
    public List<Country> getCountriesList(){                
        return list;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Country getCountryById(int id){
        Country country = null;        
        for (Country item : list) {
            //if(item.getCountriesId() == 10) {                
                country = item;
                break;
           // }            
        }
        return country;
    }
    
    /**
     *
     * @return
     */
    public JComboBox getCountriesComboBox(){
        JComboBox countries = new JComboBox(new CountryComboBoxModel(list));
        countries.setRenderer(new CountryComboBoxRenderer());
        //countries.setMaximumRowCount(3);
        
        return countries;
    }
}