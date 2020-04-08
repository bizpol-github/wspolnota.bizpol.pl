/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import pl.com.bizpol.wspolnota.core.Country;

/**
 *
 * @author Archii
 */
public final class CountryComboBoxModel extends AbstractListModel implements ComboBoxModel {
    
    private final List<Country> countries;
    
    Country selection = null;
    
    public CountryComboBoxModel(List<Country> list) {
        
        setSelectedItem(list.get(0));
        
        countries = list;
        
    }

    @Override
    public int getSize() {
        return countries.size();
    }

    @Override
    public Object getElementAt(int index) {
        return countries.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (Country) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }
    
}
