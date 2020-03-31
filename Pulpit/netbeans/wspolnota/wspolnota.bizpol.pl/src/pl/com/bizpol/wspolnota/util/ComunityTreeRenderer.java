/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import pl.com.bizpol.wspolnota.core.Community;
import pl.com.bizpol.wspolnota.core.CommunityTenant;

/**
 *
 * @author Archii
 */
public class ComunityTreeRenderer extends DefaultTreeCellRenderer {
    
    Icon commLeafIcon, commOpenIcon, commCloseIcon, icon, tenantLeafIcon;

    /**
     *
     */
    public ComunityTreeRenderer() {
        commCloseIcon = new ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/white/png/home_icon&16.png"));
        commOpenIcon = new ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/home_icon&16.png"));
        commLeafIcon = new ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/white/png/home_icon&16.png"));
        
        icon = new ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/db_icon&16.png"));
        tenantLeafIcon = new ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/white/png/contact_card_icon&16.png"));
        
        
    }

    /**
     *
     * @param tree
     * @param value
     * @param sel
     * @param expanded
     * @param leaf
     * @param row
     * @param hasFocus
     * @return
     */
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        setOpenIcon(commOpenIcon);
        setClosedIcon(commCloseIcon);
        setLeafIcon(commLeafIcon);
        //DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;            

        if(value instanceof Community){
            Community nodeInfo = (Community) (value);
            String text = nodeInfo.getShortName(); 
            setText(text);
            setOpenIcon(commOpenIcon);
            setToolTipText("This book is in the Tutorial series.");

        } else if (value instanceof CommunityTenant) {
            setIcon(tenantLeafIcon);
            setClosedIcon(commCloseIcon);

        }

        return this;
    }

//    protected boolean isTutorialBook(Object value) {
//        DefaultMutableTreeNode node =
//                (DefaultMutableTreeNode)value;
//        BookInfo nodeInfo =
//                (BookInfo)(node.getUserObject());
//        String title = nodeInfo.bookName;
//        if (title.indexOf("Tutorial") >= 0) {
//            return true;
//        }
//
//        return false;
//    }
}