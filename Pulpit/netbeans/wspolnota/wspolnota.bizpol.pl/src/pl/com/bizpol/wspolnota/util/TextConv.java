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
    
    public static String colNameToMethod(String setget, String name) {
        String method = setget;
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        int idx = name.indexOf("_");
        
        if (idx > 0) {
            String firstPart = name.substring(0, idx);
            String nextPart = name.substring(idx);            
            String up = nextPart.substring(0,1).toUpperCase() + nextPart.substring(1);            
            
            method = firstPart + up;
            
        } else {
            
            method += name;
        }
        
        return method;
    }
    
}
