/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import pl.com.bizpol.wspolnota.core.Community;
import pl.com.bizpol.wspolnota.core.CommunityTenant;
import pl.com.bizpol.wspolnota.dao.CommunityTenantDAO;

/**
 *
 * @author Archii
 */
public final class CommunityTreeModel implements TreeModel{
    
   
    List<Community> communityList;    
    DefaultTreeModel innerModel;    
    DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Wspólnoty");
    

    public CommunityTreeModel(List<Community> list) {
        this.communityList = list;
    }
 
    @Override
    public Object getRoot() {
        return rootNode;
    }

    @Override
    public Object getChild(Object parent, int index) { 

        return communityList.get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        int size = 0;
        
        if (parent.equals(rootNode)) {
            size = communityList.size();
        } else {
            System.out.println(parent.getClass());
        }
        
//            List<CommunityTenant> children = ((Community)parent).getTenants();
//            
//            //jezeli nie ma sprawdz w bazie czy są lokatorzy
//            if (children.equals(parent)) {
//                System.out.println("Parent = " + parent + " " + "childs = " + children.size());
//            }
//            
//            System.out.println("Children = " + parent + " " + "childs = " + children.size());
//            
//            if (children == null) return 0;
//            //return children.size();
            
          return size;
    }

    @Override
    public boolean isLeaf(Object node) {
        return false;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
//        List<CommunityTenant> children = ((Community)parent).getTenants();
//        if (children.size() < 1) return -1;
//        String childname = ((CommunityTenant)child).toString();
//        for(int i = 0; i < children.size(); i++) {
//            if (childname.equals(children.get(i).toString())) return i;
//        }
        System.out.println("Index of child:" + parent);
        return 0;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
    }
    
    


}