/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

/**
 *
 * @author Archii
 */
public class TextConv {
    
    /**
     *
     * @param setget
     * @param name
     * @return
     */
    public static String colNameToMethod(String setget, String name) {
        String method = "";        
        int idx = name.indexOf("_");
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
                
        if (idx > 0) {            
            String firstPart = name.substring(0, idx);
            String restPart = name.substring(idx+1);
            String up = restPart.substring(0,1).toUpperCase() + restPart.substring(1);
            
            method = firstPart + up;
            
            colNameToMethod(setget, method);
            
        } else {            
            
            method = name;
        }
        
        return setget+method;
    }
    
}
