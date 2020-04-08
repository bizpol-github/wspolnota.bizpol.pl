/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import pl.com.bizpol.wspolnota.core.Country;

/**
 *
 * @author Archii
 */
/**
 * A custom editor for cells in the Country column.
 * @author www.codejava.net
 *
 */
public class BooleanCellEditor extends AbstractCellEditor
        implements TableCellEditor, ActionListener {
 
    private boolean bool;
    private final JComboBox comboYesNo;
     
    public BooleanCellEditor(JComboBox<Country> comboCountry) {        
        String[] yesNo = {"Tak", "Nie"};
        comboYesNo = new JComboBox(yesNo);
    }
     
    @Override
    public Object getCellEditorValue() {
        return this.bool;
    }
 
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (value instanceof Boolean) {
            this.bool = (Boolean) value;
            
            if ((Boolean)value) {
                comboYesNo.setSelectedIndex(0);
            } else {
                comboYesNo.setSelectedIndex(1);
            }
        }
            
        comboYesNo.addActionListener(this);
         
        if (isSelected) {
            comboYesNo.setBackground(table.getSelectionBackground());
        } else {
            comboYesNo.setBackground(table.getSelectionForeground());
        }
         
        return comboYesNo;
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox combo = (JComboBox) event.getSource();
        String selected = (String) combo.getSelectedItem();
        this.bool = selected.equals("Tak");
    }
 
}
