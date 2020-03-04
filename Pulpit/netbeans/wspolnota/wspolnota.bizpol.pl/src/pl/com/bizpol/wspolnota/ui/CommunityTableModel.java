package pl.com.bizpol.wspolnota.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.table.AbstractTableModel;
import pl.com.bizpol.wspolnota.core.Community;

import pl.com.bizpol.wspolnota.core.Countries;

class CommunityTableModel extends AbstractTableModel {

	private static final int DATA = 0;
	private static final int VALUE = 1;
	private static final int ACTIONS = 2;

	private String[] columnNames = { "DANE", "WARTOŚĆ", "AKCJE"};
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
		case ACTIONS:
			final JButton button = new JButton(columnNames[col]);
                        button.addActionListener(new ActionListener() {
                             @Override
                            public void actionPerformed(ActionEvent arg0) {
                                JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button), 
                                        "Button clicked for row "+row);
                            }

                    
                        });
                        return button;               
		default:
			return data[row][0];
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
