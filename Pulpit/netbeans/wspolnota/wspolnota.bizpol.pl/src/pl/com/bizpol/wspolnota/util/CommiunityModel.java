/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Archii
 */
public class CommiunityModel implements TreeModel{
    
    int level = 0;
    DefaultMutableTreeNode commiunity;
    
    DefaultTreeModel innerModel;

  DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("UIDefaults");

  DefaultMutableTreeNode colorNode = new DefaultMutableTreeNode("Color Resources");

  DefaultMutableTreeNode borderNode = new DefaultMutableTreeNode("Border Resources");

  DefaultMutableTreeNode fontNode = new DefaultMutableTreeNode("Font Resources");

  DefaultMutableTreeNode iconNode = new DefaultMutableTreeNode("Icon Resources");

  DefaultMutableTreeNode otherNode = new DefaultMutableTreeNode("Other Resources");
    
    public CommiunityModel(){
        //commiunity = new DefaultMutableTreeNode("Wspólnoty");
        
        innerModel = new DefaultTreeModel(rootNode);
    innerModel.insertNodeInto(colorNode, rootNode, 0);
    innerModel.insertNodeInto(borderNode, rootNode, 1);
    innerModel.insertNodeInto(fontNode, rootNode, 2);
    innerModel.insertNodeInto(iconNode, rootNode, 3);
    innerModel.insertNodeInto(otherNode, rootNode, 4);
    UIDefaults defaults = UIManager.getDefaults();
    Enumeration elems = defaults.keys();
    String keyName;
    Object valueForKey;
    while (elems.hasMoreElements()) {
      DefaultMutableTreeNode newKeyNode;
      DefaultMutableTreeNode newValueNode;
      try {
        keyName = elems.nextElement().toString();
        valueForKey = defaults.get(keyName);

        newKeyNode = new DefaultMutableTreeNode(keyName);
        newValueNode = new DefaultMutableTreeNode(valueForKey);

        if (valueForKey instanceof java.awt.Color) {
          innerModel.insertNodeInto(newKeyNode, colorNode, 0);
        } else if (valueForKey instanceof javax.swing.border.Border) {
          innerModel.insertNodeInto(newKeyNode, borderNode, 0);
        } else if (valueForKey instanceof java.awt.Font) {
          innerModel.insertNodeInto(newKeyNode, fontNode, 0);
        } else if (valueForKey instanceof javax.swing.Icon) {
          innerModel.insertNodeInto(newKeyNode, iconNode, 0);
        } else {
          innerModel.insertNodeInto(newKeyNode, otherNode, 0);
        }
        innerModel.insertNodeInto(newValueNode, newKeyNode, 0);
      } catch (NullPointerException e) {
      }
    }
    }
    
    public DefaultMutableTreeNode getCommiunityModel() {
        return commiunity;
    }

    @Override
    public Object getRoot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getChild(Object parent, int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getChildCount(Object parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLeaf(Object node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
