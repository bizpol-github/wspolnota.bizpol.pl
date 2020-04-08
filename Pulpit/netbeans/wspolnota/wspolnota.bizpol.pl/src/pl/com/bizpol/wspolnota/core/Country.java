/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.core;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Archii
 */
public class Country implements Serializable{
    private final int id;
    private final String countriesName;
    private final String isoCode2;
    private final String isoCode3;
    private final String addressFormat;
    
    /**
     *
     * @param id
     * @param countriesName
     * @param isoCode2
     * @param isoCode3
     * @param addressFormat
     */
    public Country(int id, String countriesName, String isoCode2, String isoCode3, String addressFormat){
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
    public ImageIcon getIcon() throws IOException, URISyntaxException{
        
        ImageIcon icon,newIcon;
        Image img;
        
        double percent = 0.25;
        File inputFile;
        inputFile = new File(getClass().getResource("/pl/com/bizpol/wspolnota/icons/flags/png100px/" + getIsoCode2().toLowerCase() + ".png").toURI());
        BufferedImage inputImage = ImageIO.read(inputFile);
        
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        
        
//        icon = new ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/flags/png100px/" + getIsoCode2().toLowerCase() + ".png"));
//        img = icon.getImage();
        
        Image newImg = inputImage.getScaledInstance(scaledWidth, scaledHeight, java.awt.Image.SCALE_SMOOTH);
        newIcon = new ImageIcon(newImg);
        return newIcon;
    }
    
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
       
        return this.countriesName;
        // return String
       //         .format("Country [id=%s, countriesName=%s, isoCode2=%s, isoCode3=%s, addressFormat=%s]", id, countriesName, isoCode2, isoCode3, addressFormat);
    }
    
}
