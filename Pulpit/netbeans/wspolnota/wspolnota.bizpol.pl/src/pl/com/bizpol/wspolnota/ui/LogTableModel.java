package pl.com.bizpol.wspolnota.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pl.com.bizpol.wspolnota.core.Log;

class LogTableModel extends AbstractTableModel {

	private static final int ID = 0;
	private static final int USER_NAME = 1;
	private static final int TABLE_NAME = 2;
        private static final int DATA_ID = 3;
	private static final int OLD_VALUE = 4;
        private static final int NEW_VALUE = 5;
        private static final int DATE = 6;
        

	private final String[] columnNames = { "ID", "USER_NAME", "TABLE_NAME", "DATA_ID", "OLD_VALUE", "NEW_VALUE", "DATE" };
	private final List<Log> log;

	public LogTableModel(List<Log> theLog) {
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

		Log tempLog = log.get(row);

		switch (col) {
		case ID:
			return tempLog.getId();
		case USER_NAME:
			return tempLog.getUserName() + "(ID:" + tempLog.getUserId() + ")";
		case TABLE_NAME:
			return tempLog.getTableName();
                case DATA_ID:
			return tempLog.getDataId();
		case OLD_VALUE:                    
			return tempLog.getOldValues();
                case NEW_VALUE:
			return tempLog.getNewValues();        
                case DATE:
			return tempLog.getDate().toString();        
		default:
			return tempLog.getId();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
