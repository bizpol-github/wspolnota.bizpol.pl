/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Archii
 */
public class LogTableRenderer extends JTextArea implements TableCellRenderer {
//    DateFormat formatter;
    int rowHeight = 0;
    
    public LogTableRenderer() {
        super();
        
        
    }
//
//    public void setValue(Object value) {
//        if (formatter==null) {
//            formatter = DateFormat.getDateInstance();
//        }
//        setText((value == null) ? "" : formatter.format(value));
//    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        String text = value.toString();
        
        setText((value == null) ? "" : text);       
        setWrapStyleWord(true);
        setLineWrap(true);
        setFont(table.getFont());
        setBorder(null);
        setBackground(null);
        
        Insets m = new Insets(5,5,5,5);
        setMargin(m);
        
        
        //setSize(new Dimension(colWidth, 1));
// get the text area preferred height and add the row margin
        //int height = getPreferredSize().height;
        
        FontMetrics fm = getFontMetrics(this.getFont());
    int fontHeight = fm.getHeight() + table.getRowMargin();
    int textLength = fm.stringWidth(getText());  // length in pixels
    int colWidth = table.getColumnModel().getColumn(column).getWidth();
    int lines = textLength / colWidth +3; // +1, because we need at least 1 row.
    int height = fontHeight * lines;
        
        
        if (column == 0 || height > rowHeight) {
            table.setRowHeight(row, height);
            
            System.out.println("Wiersz: " + row + " Text: " + text.length() + " H: " + height);
            rowHeight = height;
        }
        
        return this;
        
    }
}
