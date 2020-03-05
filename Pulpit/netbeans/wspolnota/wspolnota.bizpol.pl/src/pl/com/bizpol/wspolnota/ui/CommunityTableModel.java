package pl.com.bizpol.wspolnota.ui;


import javax.swing.table.AbstractTableModel;
import pl.com.bizpol.wspolnota.core.Community;


class CommunityTableModel extends AbstractTableModel {

	private static final int DATA = 0;
	private static final int VALUE = 1;

	private String[] columnNames = { "DANE", "WARTOŚĆ"};
	private Community community;
        private String[][] data;

	public CommunityTableModel(Community community) {
		this.community = community;  
                data = community.getTableArray();
                
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
            
            switch (col) {
            case DATA:
                    return data[row][0];
            case VALUE:
                    return data[row][1];
            default:
                    return data[row][0];
            }
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
        
        @Override
        public void setValueAt(Object aValue, int row, int col)
        {
            if(1 == col) {
                data[row][col] =  (String) aValue;
                System.out.println("Zmieniono dane w kolumnie " + col + ", wiersz " + row);
                
                //Informacja do obiektu o zmianie
                if (!community.isChanged()){
                    community.setChanged(false);
                    System.out.println(community.toString2());
                }
            }
        }
        
        @Override
        public boolean isCellEditable(int row, int col)
        {
            return true;
        }
}
