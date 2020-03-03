package pl.com.bizpol.wspolnota.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import pl.com.bizpol.wspolnota.core.Community;

import pl.com.bizpol.wspolnota.core.Countries;

class CommunityTableModel extends AbstractTableModel {

	private static final int DATA = 0;
	private static final int VALUE = 1;
	private static final int ACTIONS = 2;

	private String[] columnNames = { "DANE", "WARTOŚĆ", "AKCJE"};
	private Community community;
        private List<String> list;

	public CommunityTableModel(Community community) {
		this.community = community;               
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Countries tempCountries = list.get(row);

		switch (col) {
		case DATA:
			return tempCountries.getCountriesId();
		case VALUE:
			return tempCountries.getCountriesName();
		case ACTIONS:
			return tempCountries.getIsoCode2();                
		default:
			return tempCountries.getCountriesId();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
