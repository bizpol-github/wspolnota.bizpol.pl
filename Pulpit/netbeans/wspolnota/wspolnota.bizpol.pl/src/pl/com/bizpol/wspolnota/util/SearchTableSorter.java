/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import pl.com.bizpol.wspolnota.ui.CommunityTableModel;

/**
 *
 * @author netcom
 */
public class SearchTableSorter extends TableRowSorter{
    
    final TableRowSorter<TableModel> sorter;
    
    /**
     *
     * @param table
     * @param model
     */
    public SearchTableSorter(JTable table, CommunityTableModel model){
        this.sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(this.sorter);
    }
    
    /**
     *
     * @return
     */
    public TableRowSorter getSorter(){
        return this.sorter;
    }
    
    /**
     *
     * @param search
     */
    public void sort(String search){
        
        if (search.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter(search));
        }
        
    }
}
