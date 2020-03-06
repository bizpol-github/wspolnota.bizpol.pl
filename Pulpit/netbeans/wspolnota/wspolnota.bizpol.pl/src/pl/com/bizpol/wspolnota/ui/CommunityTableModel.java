package pl.com.bizpol.wspolnota.ui;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pl.com.bizpol.wspolnota.core.Community;


public class CommunityTableModel extends AbstractTableModel {

	private static final int DATA = 0;
	private static final int VALUE = 1;

	private String[] columnNames = { "DANE", "WARTOŚĆ"};
	private Community community;
        private Community changedCommunity = new Community();
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
                community.setChanged(false);
                
                try {
                    getChangedCommunity();
                    
                    //Tworzenie zmienionego community
                    //changedCommunity = 
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CommunityTableModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(CommunityTableModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(CommunityTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                //Informacja do obiektu o zmianie
                if (!community.isChanged()){
                    community.setChanged(true);
                  //  System.out.println(community.toStringAll());
                   // System.out.println("Array " + Arrays.toString(data));
                }
            }
        }
        
        public Community getChangedCommunity() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException{
            
            
            
            
            for (String[] string : data) {
                
                String id = string[0];
                String value = string[1];
                String type = string[2];
                
                Class[] classType = new Class[1];
                
                //System.out.println("ID: " + id + " " + value);
                
                
                if(type.equals("int")) {
                    System.out.println("Numer " + id + " " + value);
                    classType[0] = int.class; 
                } else if (type.equals("String")) {
                    System.out.println("Tekst " + id + " " + value);
                    classType[0] = String.class;
                    
                } else if (type.equals("boolean")) {
                    System.out.println("Logiczne " + id + " " + value);
                    classType[0] = boolean.class;
                }
                
                
                try {
                    Class c = changedCommunity.getClass();
                    Method method = changedCommunity.getClass().getMethod("set" + id.substring(0, 1).toUpperCase() + id.substring(1), classType[0]);
                    method.invoke(c, value);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(CommunityTableModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(CommunityTableModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(CommunityTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
            }
            
            System.out.println("---------------------------------------");
            
            System.out.println(changedCommunity);
            
             
            
            
            return changedCommunity;
        }
        
        @Override
        public boolean isCellEditable(int row, int col)
        {
            return true;
        }
        
        
}
