package pl.com.bizpol.wspolnota.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pl.com.bizpol.wspolnota.core.Log;

class LogTableModel1 extends AbstractTableModel {

	private static final int ID = 0;
	private static final int USER_ID = 1;
	private static final int TABLE_NAME = 2;
        private static final int DATA_ID = 3;
	private static final int OLD_VALUE = 4;
        private static final int NEW_VALUE = 5;

	private String[] columnNames = { "ID", "USER_NAME", "TABLE_NAME", "OLD_VALUE", "NEW_VALUE" };
	private List<Log> log;

	public LogTableModel1(List<Log> theLog) {
		log = theLog;               
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return log.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Log tempCountries = log.get(row);

		switch (col) {
		case ID:
			return tempCountries.getId();
		case USER_ID:
			return tempCountries.getUserId();
		case TABLE_NAME:
			return tempCountries.getTableName();
                case DATA_ID:
			return tempCountries.getDataId();
		case OLD_VALUE:
			return tempCountries.getOldValues();
                case NEW_VALUE:
			return tempCountries.getNewValues();        
		default:
			return tempCountries.getId();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
