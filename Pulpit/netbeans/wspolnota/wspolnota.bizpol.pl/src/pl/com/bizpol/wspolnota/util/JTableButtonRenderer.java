/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.awt.Component;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author netcom
 */
public class JTableButtonRenderer implements TableCellRenderer {        
    
    URL url;
    
    
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        JButton button = (JButton)value;
        ImageIcon imgicon = new ImageIcon(url);
        button.setIcon(imgicon);
        button.setText("");
        button.setSize(70, 20);
        
        return button;  
    }
    
    public void setImageToButton(URL url){
        this.url = url;
        
    }
}
