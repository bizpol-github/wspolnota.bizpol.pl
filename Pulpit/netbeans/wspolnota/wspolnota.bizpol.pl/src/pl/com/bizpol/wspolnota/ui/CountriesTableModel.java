package pl.com.bizpol.wspolnota.ui;

import java.awt.Image;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import javax.swing.table.AbstractTableModel;

import pl.com.bizpol.wspolnota.core.Country;

class CountriesTableModel extends AbstractTableModel {

	private static final int COUNTRIES_ID = 0;
        private static final int COUNTRIES_ICON = 1;
	private static final int COUNTRIES_NAME = 2;
	private static final int COUNTRIES_ISO_CODE_2 = 3;
	private static final int COUNTRIES_ISO_CODE_3 = 4;
        private static final int ADDRESS_FORMAT = 5;

	private String[] columnNames = { "ID", "IKONA", "NAZWA", "ISO-2",
			"ISO-3", "FORMAT" };
	private List<Country> countries;

	public CountriesTableModel(List<Country> theCountries) {
		countries = theCountries;               
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return countries.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Country tempCountries = countries.get(row);
                ImageIcon icon,newIcon;
                Image img;
                
                
		switch (col) {
		case COUNTRIES_ID:
			return tempCountries.getCountriesId();
                case COUNTRIES_ICON:                   
                {
                    try {
                        return (tempCountries.getIcon() != null) ? tempCountries.getIcon() : "brak";
                    } catch (IOException ex) {
                        Logger.getLogger(CountriesTableModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(CountriesTableModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
		case COUNTRIES_NAME:
			return tempCountries.getCountriesName();
		case COUNTRIES_ISO_CODE_2:
			return tempCountries.getIsoCode2();
                case COUNTRIES_ISO_CODE_3:
			return tempCountries.getIsoCode3();
		case ADDRESS_FORMAT:
			return tempCountries.getAddressFormat();
		default:
			return tempCountries.getCountriesId();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
