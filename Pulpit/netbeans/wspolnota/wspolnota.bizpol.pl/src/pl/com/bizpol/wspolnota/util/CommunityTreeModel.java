/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import pl.com.bizpol.wspolnota.core.Community;
import pl.com.bizpol.wspolnota.core.CommunityTenant;

/**
 *
 * @author Archii
 */
public final class CommunityTreeModel extends DefaultTreeModel implements TreeModel{
    
   
    List<Community> community;
    
    public CommunityTreeModel (){
        
    }
    
    public CommunityTreeModel(List<Community> community){
        
        this.community = community;        

    }  

    @Override
    public Object getRoot() {
        return community;
    }

    @Override
    public Object getChild(Object parent, int index) {
        
        List<CommunityTenant> children = ((Community)parent).getTenants();
        if ((children == null) || (index >= children.size())) return null;
        return children.get(index); 
    }

    @Override
    public int getChildCount(Object parent) {
        List<CommunityTenant> children = ((Community)parent).getTenants();
        if (children == null) return 0;
        return children.size();
    }

    @Override
    public boolean isLeaf(Object node) {
        return true;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        List<CommunityTenant> children = ((Community)parent).getTenants();
        if (children.size() < 1) return -1;
        String childname = ((CommunityTenant)child).toString();
        for(int i = 0; i < children.size(); i++) {
            if (childname.equals(children.get(i).toString())) return i;
        } 
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
    }
    
    


}