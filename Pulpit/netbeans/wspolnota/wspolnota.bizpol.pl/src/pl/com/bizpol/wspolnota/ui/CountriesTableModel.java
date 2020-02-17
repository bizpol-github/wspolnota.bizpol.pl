package pl.com.bizpol.wspolnota.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pl.com.bizpol.wspolnota.core.Countries;

class CountriesTableModel extends AbstractTableModel {

	private static final int COUNTRIES_ID = 0;
	private static final int COUNTRIES_NAME = 1;
	private static final int COUNTRIES_ISO_CODE_2 = 2;
	private static final int COUNTRIES_ISO_CODE_3 = 3;
        private static final int ADDRESS_FORMAT = 4;

	private String[] columnNames = { "ID", "NAZWA", "ISO-2",
			"ISO-3", "FORMAT" };
	private List<Countries> countries;

	public CountriesTableModel(List<Countries> theCountries) {
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

		Countries tempCountries = countries.get(row);

		switch (col) {
		case COUNTRIES_ID:
			return tempCountries.getCountriesId();
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
