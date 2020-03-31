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
    
    /**
     *
     * @param list
     */
    public CommunityTreeModel(List<Community> list) {
        this.communityList = list;
    }
 
    /**
     *
     * @return
     */
    @Override
    public Object getRoot() {
        return rootNode;
    }

    /**
     *
     * @param parent
     * @param index
     * @return
     */
    @Override
    public Object getChild(Object parent, int index) {
        
        if (parent instanceof Community) {
            int tenantId = (int) ((Community) parent).getTenants().get(index);
            
            try {
                CommunityTenantDAO tenantDAO = new CommunityTenantDAO();
                
                CommunityTenant tenant = tenantDAO.getCommunityTenant(tenantId);
                
                return tenant;
                
            } catch (Exception ex) {
                Logger.getLogger(CommunityTreeModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
        }

        return communityList.get(index);
    }

    /**
     *
     * @param parent
     * @return
     */
    @Override
    public int getChildCount(Object parent) {
        int size = 0;
        
        if (parent.equals(rootNode)) {
            size = communityList.size();
        } else if (parent instanceof Community) {
            size = ((Community) parent).getTenants().size();
        }
        
        return size;
    }

    /**
     *
     * @param node
     * @return
     */
    @Override
    public boolean isLeaf(Object node) {
        if (node instanceof Community) {
            return false;
        } else if (node instanceof CommunityTenant) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param path
     * @param newValue
     */
    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param parent
     * @param child
     * @return
     */
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

    /**
     *
     * @param l
     */
    @Override
    public void addTreeModelListener(TreeModelListener l) {
        System.out.println("listener");
    }

    /**
     *
     * @param l
     */
    @Override
    public void removeTreeModelListener(TreeModelListener l) {
    }
    
    


}