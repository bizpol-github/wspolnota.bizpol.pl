/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.core;

/**
 *
 * @author Archii
 */
public class Countries {
    private int id;
    private String countriesName;
    private String isoCode2;
    private String isoCode3;
    private String addressFormat;
    
    /**
     *
     * @param id
     * @param countriesName
     * @param isoCode2
     * @param isoCode3
     * @param addressFormat
     */
    public Countries(int id, String countriesName, String isoCode2, String isoCode3, String addressFormat){
        super();
         this.id = id;
         this.countriesName = countriesName;
         this.isoCode2 = isoCode2;
         this.isoCode3 = isoCode3;
         this.addressFormat = addressFormat;
    }
    
    /**
     *
     * @return
     */
    public int getCountriesId(){
        return id;
    }
    
    /**
     *
     * @return
     */
    public int setCountriesId(){
        return this.id;
    }
    
    /**
     *
     * @return
     */
    public String getCountriesName(){
        return countriesName;
    }
    
    /**
     *
     * @return
     */
    public String setCountriesName(){
        return this.countriesName;
    }
    
    /**
     *
     * @return
     */
    public String getIsoCode2(){
        return isoCode2;
    }
    
    /**
     *
     * @return
     */
    public String setIsoCode2(){
        return this.isoCode2;
    }
    
    /**
     *
     * @return
     */
    public String getIsoCode3(){
        return isoCode3;
    }
    
    /**
     *
     * @return
     */
    public String setIsoCode3(){
        return this.isoCode3;
    }
    
    /**
     *
     * @return
     */
    public String getAddressFormat(){
        return addressFormat;
    }
    
    /**
     *
     * @return
     */
    public String setAddressFormat(){
        return this.addressFormat;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String
                .format("Country [id=%s, countriesName=%s, isoCode2=%s, isoCode3=%s, addressFormat=%s]", id, countriesName, isoCode2, isoCode3, addressFormat);
    }
    
}
