package pl.com.bizpol.wspolnota.ui;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pl.com.bizpol.wspolnota.core.Community;
import pl.com.bizpol.wspolnota.core.Country;
import pl.com.bizpol.wspolnota.dao.CommunityDAO;
import pl.com.bizpol.wspolnota.dao.LogDAO;
import static pl.com.bizpol.wspolnota.util.TextConv.colNameToMethod;

/**
 *
 * @author netcom
 */
public class CommunityTableModel extends AbstractTableModel {

	private static final int DATA = 0;
	private static final int VALUE = 1;

	private final String[] columnNames = { "DANE", "WARTOŚĆ"};
	private Community community;
        private final Community changedCommunity = new Community();
        private final Object[][] data;

    /**
     *
     * @param community
     */
    public CommunityTableModel(Community community) {
		this.community = community;  
                data = community.getTableArray();
	}

    /**
     *
     * @return
     */
    @Override
	public int getColumnCount() {
		return columnNames.length;
	}

    /**
     *
     * @return
     */
    @Override
	public int getRowCount() {
		return data.length;
	}

    /**
     *
     * @param col
     * @return
     */
    @Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

    /**
     *
     * @param row
     * @param col
     * @return
     */
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

    /**
     *
     * @param c
     * @return
     */
    @Override
	public Class getColumnClass(int c) {
           // return getValueAt(0, c).getClass();
           return Object.class;
        }
        
    /**
     *
     * @param aValue
     * @param row
     * @param col
     */
    @Override
        public void setValueAt(Object aValue, int row, int col)
        {
            if (1 == col && !aValue.equals(data[row][col])){
                System.out.println("nie zmieniono nic");

                data[row][col] =  aValue;
                System.out.println("Zmieniono dane w kolumnie " + col + ", wiersz " + row);
                community.setChanged(false);
                //super.setValueAt(col == 0 ? aValue.toString() : aValue, row, col);

                try {
                    getChangedCommunity();

                    //Tworzenie zmienionego community
                    //changedCommunity = 
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CommunityTableModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException | NoSuchMethodException ex) {
                    Logger.getLogger(CommunityTableModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(CommunityTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }



                //Informacja do obiektu o zmianie
                if (!community.isChanged()){
                    community.setChanged(true);
                    System.out.println(community.toStringAll());
                   // System.out.println("Array " + Arrays.toString(data));
                }
            }
        }
        
    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws Exception
     */
    public Community getChangedCommunity() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, Exception{
                    
            for (Object[] string : data) {
                
                String name = (String) string[0];
                name = colNameToMethod("set", name);
                Object value = string[1];
                String type = (String) string[2];
                
                //System.out.println("ID: " + id + " " + value);
                try {
                    Method method;
                    switch (type) {
                        case "int":
                            System.out.println("Numer " + name + " " + value);
                            method = changedCommunity.getClass().getMethod(name, int.class);
                            method.invoke(changedCommunity, (int)value);
                            break;
                        case "String":
                            System.out.println("Tekst " + name + " " + value);
                            method = changedCommunity.getClass().getMethod(name, String.class);
                            method.invoke(changedCommunity, value.toString());
                            break;
                        case "boolean":
                            System.out.println("Logiczne " + name + " " + value);
                            method = changedCommunity.getClass().getMethod(name, boolean.class);
                            if ((boolean)value){
                                 method.invoke(changedCommunity, true);
                            } else {
                                method.invoke(changedCommunity, false);
                            }
                            break;
                        case "Country":
                            System.out.println("Kraj " + name + " " + value);
                            method = changedCommunity.getClass().getMethod(name, Country.class);
                            method.invoke(changedCommunity, value);
                           
                            break;
                        default:
                            break;
                    }
                    
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(CommunityTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            //Uzyskanie dostępu do bazy danych i zapisanie zmian
            
            CommunityDAO cDAO = new CommunityDAO();
            cDAO.updateCommunity(changedCommunity);
            
            LogDAO logDAO = new LogDAO();
            logDAO.EnterLog(1, "community", community.getId(), community, changedCommunity);
            
            
            System.out.println("---------------------------------------");
            
            //System.out.println(changedCommunity.toStringAll());
            
            community = changedCommunity;
            
             
            
            
            return changedCommunity;
        }
        
    /**
     *
     * @param row
     * @param col
     * @return
     */
    @Override
    public boolean isCellEditable(int row, int col) {        
        return !(col==0 || row==0 || row==9);
    }            
}
