/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Archii
 */
public class CommunityTableRenderer extends JLabel implements TableCellRenderer {
//    DateFormat formatter;
    int rowHeight = 0;
    
    /**
     *
     */
    public CommunityTableRenderer() {
        super();
        
    }
//
//    public void setValue(Object value) {
//        if (formatter==null) {
//            formatter = DateFormat.getDateInstance();
//        }
//        setText((value == null) ? "" : formatter.format(value));
//    }

    /**
     *
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     * @return
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        //text fonts      
        String text = "";        
        if (value != null) {                
           text = value.toString();
        }
        setText((value == null) ? "" : text);
        setFont(table.getFont());
        
        
        //backgrounds
        if (column == 1) {
            setOpaque(true);
            setBackground(Color.RED);
            
            if (table.isCellEditable(row, column)) {
                setOpaque(true);
                setBackground(Color.GREEN);
            }            
            
        } else {
            setOpaque(false);
            setBackground(null);
        }     
        
        
        //borders    
        setBorder(new EmptyBorder(2, 3, 2, 3));
            
        //aligment
        setHorizontalAlignment(LEFT);
        
        //margins
            


            //setSize(new Dimension(colWidth, 1));
            // get the text area preferred height and add the row margin
            //int height = getPreferredSize().height;

//                FontMetrics fm = getFontMetrics(this.getFont());
//            int fontHeight = fm.getHeight() + table.getRowMargin();
//            int textLength = fm.stringWidth(getText());  // length in pixels
//            int colWidth = table.getColumnModel().getColumn(column).getWidth();
//            int lines = textLength / colWidth +1; // +1, because we need at least 1 row.
//            int height = fontHeight * lines;
//
//
//                if (height > rowHeight) {
//                    table.setRowHeight(row, height);
//
//                    rowHeight = height;
//                    System.out.println("Wiersz: " + value.getClass());
//                }

                

//
//        }
        
        
            
        
        return this;
        
    }
}
