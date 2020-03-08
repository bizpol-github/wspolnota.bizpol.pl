package pl.com.bizpol.wspolnota.ui;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pl.com.bizpol.wspolnota.core.Community;
import static pl.com.bizpol.wspolnota.util.TextConv.colNameToMethod;


public class CommunityTableModel extends AbstractTableModel {

	private static final int DATA = 0;
	private static final int VALUE = 1;

	private final String[] columnNames = { "DANE", "WARTOŚĆ"};
	private final Community community;
        private final Community changedCommunity = new Community();
        private final String[][] data;

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
                id = colNameToMethod("set", id);
                String value = string[1];
                String type = string[2];
                
                Class[] classType = new Class[1];
                
                //System.out.println("ID: " + id + " " + value);
                try {
                    Method method;
                    switch (type) {
                        case "int":
                            System.out.println("Numer " + id + " " + value);
                            method = changedCommunity.getClass().getMethod(id, int.class);
                            method.invoke(changedCommunity, Integer.parseInt(value));
                            break;
                        case "String":
                            System.out.println("Tekst " + id + " " + value);
                            method = changedCommunity.getClass().getMethod(id, String.class);
                            method.invoke(changedCommunity, value);
                            break;
                        case "boolean":
                            System.out.println("Logiczne " + id + " " + value);
                            method = changedCommunity.getClass().getMethod(id, boolean.class);
                            if ("0".equals(value)){
                                 method.invoke(changedCommunity, false);
                            } else {
                                method.invoke(changedCommunity, true);
                            }
                            break;
                        default:
                            break;
                    }
                
                
               
                    
                    
                    
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(CommunityTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
            }
            
            System.out.println("---------------------------------------");
            
            System.out.println(changedCommunity.toStringAll());
            
             
            
            
            return changedCommunity;
        }
        
        @Override
        public boolean isCellEditable(int row, int col)
        {
            return true;
        }
        
        
}
