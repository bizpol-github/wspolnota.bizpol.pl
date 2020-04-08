/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bizpol.wspolnota.util;

import java.awt.Component;
import java.awt.Font;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import javax.swing.border.EmptyBorder;
import pl.com.bizpol.wspolnota.core.Countries;
import pl.com.bizpol.wspolnota.core.Country;

/**
 *
 * @author Archii
 */
public class CountryComboBoxRenderer extends JLabel implements ListCellRenderer{

    private Font uhOhFont;

    public CountryComboBoxRenderer() {
        setOpaque(true);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
        setBorder(new EmptyBorder(1, 1, 1, 1));
    }

    /*
     * This method finds the image and text corresponding
     * to the selected value and returns the label, set up
     * to display the text and image.
     */
    @Override
    public Component getListCellRendererComponent(
                                       JList list,
                                       Object value,
                                       int index,
                                       boolean isSelected,
                                       boolean cellHasFocus) {
        //Get the selected index. (The index param isn't
        //always valid, so just use the value.)
        //int selectedIndex = ((Integer)value).intValue();

        Country country = (Country) value;

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        //Set the icon and text.  If icon was null, say so.
        //ImageIcon icon = images[selectedIndex];
        ImageIcon icon = null;
        try {
            icon = country.getIcon();
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(Countries.class.getName()).log(Level.SEVERE, null, ex);
        }
        //String pet = petStrings[selectedIndex];
        setIcon(icon);
        if (icon != null) {
            setText(country.getCountriesName());
            setFont(list.getFont());
        } else {
            setUhOhText(country.getCountriesName() + " (no image available)",
                        list.getFont());
        }

        return this;
    }

    //Set the font and text when no image was found.
    protected void setUhOhText(String uhOhText, Font normalFont) {
        if (uhOhFont == null) { //lazily create this font
            uhOhFont = normalFont.deriveFont(Font.ITALIC);
        }
        setFont(uhOhFont);
        setText(uhOhText);
    }
        
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Countries.class.getResource(path);        

        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
                return null;
        }
    }
}