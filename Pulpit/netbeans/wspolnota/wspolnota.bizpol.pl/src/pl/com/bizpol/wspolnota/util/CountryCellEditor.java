/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import pl.com.bizpol.wspolnota.core.Countries;
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
public class CountryCellEditor extends AbstractCellEditor
        implements TableCellEditor, ActionListener {
 
    private Country country;
    private final JComboBox comboCountry;
     
    public CountryCellEditor(JComboBox<Country> comboCountry) {
        this.comboCountry = comboCountry;
    }
     
    @Override
    public Object getCellEditorValue() {
        return this.country;
    }
 
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (value instanceof Country) {
            this.country = (Country) value;
        }
        comboCountry.setRenderer(new CountryComboBoxRenderer());
      
        
        
        //listCountry.forEach(comboCountry::addItem);
         
//        for (Country aCountry : listCountry) {
//            comboCountry.addItem(aCountry);
//        }
         
        comboCountry.setSelectedItem(country);
        System.out.println("Combo index: " + comboCountry.getSelectedItem().toString() + " id:" + country.getCountriesId());
        comboCountry.addActionListener(this);
         
        if (isSelected) {
            comboCountry.setBackground(table.getSelectionBackground());
        } else {
            comboCountry.setBackground(table.getSelectionForeground());
        }
         
        return comboCountry;
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox<Country> comboCountry = (JComboBox<Country>) event.getSource();
        this.country = (Country) comboCountry.getSelectedItem();
    }
 
}
