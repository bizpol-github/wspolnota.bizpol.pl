/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import pl.com.bizpol.wspolnota.core.Commiunity;
import pl.com.bizpol.wspolnota.dao.CommiunityDAO;
import pl.com.bizpol.wspolnota.dao.UserDAO;

/**
 *
 * @author Archii
 */
public final class CommiunityTree {
    
    int level = 0;
    DefaultMutableTreeNode commiunity;
    
    DefaultTreeModel innerModel;
    DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Wspólnoty");
    
    public CommiunityTree(){
        //commiunity = new DefaultMutableTreeNode("Wspólnoty");
        
        innerModel = new DefaultTreeModel(rootNode);
        getCommiunites();
//    innerModel.insertNodeInto(colorNode, rootNode, 0);
//    innerModel.insertNodeInto(borderNode, rootNode, 1);
//    innerModel.insertNodeInto(fontNode, rootNode, 2);
//    innerModel.insertNodeInto(iconNode, rootNode, 3);
//    innerModel.insertNodeInto(otherNode, rootNode, 4);
//    UIDefaults defaults = UIManager.getDefaults();
//    Enumeration elems = defaults.keys();
//    String keyName;
//    Object valueForKey;
//    while (elems.hasMoreElements()) {
//      DefaultMutableTreeNode newKeyNode;
//      DefaultMutableTreeNode newValueNode;
//      try {
//        keyName = elems.nextElement().toString();
//        valueForKey = defaults.get(keyName);
//
//        newKeyNode = new DefaultMutableTreeNode(keyName);
//        newValueNode = new DefaultMutableTreeNode(valueForKey);
//
//        if (valueForKey instanceof java.awt.Color) {
//          innerModel.insertNodeInto(newKeyNode, colorNode, 0);
//        } else if (valueForKey instanceof javax.swing.border.Border) {
//          innerModel.insertNodeInto(newKeyNode, borderNode, 0);
//        } else if (valueForKey instanceof java.awt.Font) {
//          innerModel.insertNodeInto(newKeyNode, fontNode, 0);
//        } else if (valueForKey instanceof javax.swing.Icon) {
//          innerModel.insertNodeInto(newKeyNode, iconNode, 0);
//        } else {
//          innerModel.insertNodeInto(newKeyNode, otherNode, 0);
//        }
//        innerModel.insertNodeInto(newValueNode, newKeyNode, 0);
//      } catch (NullPointerException e) {
//      }
//    }
    }
    
    public void getCommiunites(){      
        System.out.println("Commiunity");       
        
        try {            
            CommiunityDAO cDAO = new CommiunityDAO();
            List<Commiunity> cList = new ArrayList<>();
            cList = cDAO.getAllCommiunities();
            
            System.out.println("1. Tworze drzewo");
            
            int i = 0;
            
            for (Commiunity comm : cList) {
                
                System.out.println(comm.getShortName());
                innerModel.insertNodeInto(new DefaultMutableTreeNode(comm), rootNode, i);
                i++;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Błąd połączenia", ex);
        }
    }
    
    public DefaultTreeModel getCommiunityModel() {
        return innerModel;
    }


}