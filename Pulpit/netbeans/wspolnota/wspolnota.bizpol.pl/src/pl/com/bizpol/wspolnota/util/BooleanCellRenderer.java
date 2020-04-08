/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import pl.com.bizpol.wspolnota.core.Country;

/**
 *
 * @author Archii
 */
public class BooleanCellRenderer extends DefaultTableCellRenderer {
     
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Boolean) {
            
            if ((Boolean) value) {
                setText("Tak");
            } else {
                setText("Nie");
            }
            
        }
        
        setBackground(Color.GREEN);
         
//        if (isSelected) {
//            setBackground(table.getSelectionBackground());
//        } else {
//            setBackground(table.getSelectionForeground());
//        }
         
        return this;
    }
     
}
