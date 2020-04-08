package pl.com.bizpol.wspolnota.ui;


import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pl.com.bizpol.wspolnota.core.Countries;
import pl.com.bizpol.wspolnota.core.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Archii
 */
public class MainWindow extends javax.swing.JFrame {

    CitiesIFrame citiesIFrame = new CitiesIFrame();
    LoginIFrame loginIFrame = new LoginIFrame(this);
    // LoginIFrame internalPanel = new InternalPanel();
    PropertyPanel propertyPanel;
    InternalPanel internalPanel = new InternalPanel();
    MsgPanel msgPanel = new MsgPanel();
    User connectedUser = null;
    Countries countries = null;
     

    /**
     * Creates new form MainWindow
     * @throws java.lang.Exception
     */
    public MainWindow() throws Exception {
        //icon to project
        URL url = getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/home_icon&16.png");
        ImageIcon imgicon = new ImageIcon(url);
        //add countries to panel
        countries = new Countries();
        
        super.setIconImage(imgicon.getImage());
        initComponents();
        //position oin screen
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainDesktopPane = new javax.swing.JDesktopPane();
        footerPanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        author = new javax.swing.JLabel();
        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loginItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        recordsMenu = new javax.swing.JMenu();
        propertiesItem = new javax.swing.JMenuItem();
        settingsMenu = new javax.swing.JMenu();
        countriesItem = new javax.swing.JMenuItem();
        zonesItem = new javax.swing.JMenuItem();
        citiesItem = new javax.swing.JMenuItem();
        logItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Moja wspólnota");
        setPreferredSize(new java.awt.Dimension(800, 600));

        mainPanel.setBackground(new java.awt.Color(224, 125, 26));
        mainPanel.setLayout(new java.awt.BorderLayout());

        mainDesktopPane.setBackground(new java.awt.Color(202, 34, 205));
        mainPanel.add(mainDesktopPane, java.awt.BorderLayout.CENTER);
        mainDesktopPane.getAccessibleContext().setAccessibleName("");

        footerPanel.setBackground(java.awt.SystemColor.controlLtHighlight);
        footerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        statusLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        statusLabel.setText("STATUS:");

        status.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        status.setText("nie połączono");

        author.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        author.setText("Projekt - AR-SYSTEMS");

        javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 560, Short.MAX_VALUE)
                .addComponent(author))
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(author)))
        );

        mainMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/2x2_grid_icon&16.png"))); // NOI18N
        fileMenu.setText("Program");

        loginItem.setFont(loginItem.getFont().deriveFont(loginItem.getFont().getSize()-1f));
        loginItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/connect_icon&16.png"))); // NOI18N
        loginItem.setText("Zaloguj się");
        loginItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginItemActionPerformed(evt);
            }
        });
        fileMenu.add(loginItem);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/on-off_icon&16.png"))); // NOI18N
        jMenuItem2.setText("Zakończ");
        jMenuItem2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        mainMenu.add(fileMenu);

        recordsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/align_just_icon&16.png"))); // NOI18N
        recordsMenu.setText("Ewidencja");

        propertiesItem.setFont(propertiesItem.getFont().deriveFont(propertiesItem.getFont().getSize()-1f));
        propertiesItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/home_icon&16.png"))); // NOI18N
        propertiesItem.setText("Nieruchomości");
        propertiesItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        propertiesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesItemActionPerformed(evt);
            }
        });
        recordsMenu.add(propertiesItem);

        mainMenu.add(recordsMenu);

        settingsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/cog_icon&16.png"))); // NOI18N
        settingsMenu.setText("Ustawienia");

        countriesItem.setFont(countriesItem.getFont().deriveFont(countriesItem.getFont().getSize()-1f));
        countriesItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/globe_3_icon&16.png")));
        countriesItem.setText("Kraje");
        countriesItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        countriesItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        countriesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countriesItemActionPerformed(evt);
            }
        });
        settingsMenu.add(countriesItem);

        zonesItem.setFont(zonesItem.getFont().deriveFont((float)11));
        zonesItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/globe_1_icon&16.png"))); // NOI18N
        zonesItem.setText("Województwa");
        zonesItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        settingsMenu.add(zonesItem);

        citiesItem.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        citiesItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/info_icon&16.png"))); // NOI18N
        citiesItem.setText("Miasta");
        citiesItem.setToolTipText("");
        citiesItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        citiesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citiesItemActionPerformed(evt);
            }
        });
        settingsMenu.add(citiesItem);

        logItem.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        logItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/notepad_icon&16.png"))); // NOI18N
        logItem.setText("Dziennik");
        logItem.setToolTipText("");
        logItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logItemActionPerformed(evt);
            }
        });
        settingsMenu.add(logItem);

        mainMenu.add(settingsMenu);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void propertiesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesItemActionPerformed
        // TODO add your handling code here:
        System.out.println("przycisk records");
        
        
        NewProperty newProperty = new NewProperty(this, true);
        newProperty.setVisible(true);
    }//GEN-LAST:event_propertiesItemActionPerformed

    private void loginItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginItemActionPerformed
        // TODO add your handling code here:
        
        if(connectedUser == null) {
            if (loginIFrame.isVisible()){
                if (loginIFrame.isIcon()){
                    try {
                        loginIFrame.setIcon(false);
                        loginIFrame.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else {
                int w = mainDesktopPane.getWidth();
                int h = mainDesktopPane.getHeight();
                

                mainDesktopPane.add(loginIFrame);
                System.out.println("else in login");
                
                loginIFrame.setVisible(true);
                
                loginIFrame.setLocation((int)(w-loginIFrame.getWidth())/2, (int)(h-loginIFrame.getHeight())/2);
            }
        } else {
            
            
            
            loginItem.setText("Zaloguj się");
            clearMainPanel();            
            mainPanel.add(mainDesktopPane);
            setMessage("Sukces", "Pomyślnie wylogowano użytkownika - " + connectedUser.getDisplayName());
            refresh();
           
            connectedUser = null;
            
            
            status.setText("Nie połączono");
        }
        refresh();
    }//GEN-LAST:event_loginItemActionPerformed

    private void countriesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countriesItemActionPerformed
        System.out.println("przycisk countries");
        
        CountriesJDialog countriesDialog = new CountriesJDialog(this, true);
        countriesDialog.setVisible(true);
    }//GEN-LAST:event_countriesItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void citiesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citiesItemActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_citiesItemActionPerformed

    private void logItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MainWindow().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel author;
    private javax.swing.JMenuItem citiesItem;
    private javax.swing.JMenuItem countriesItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem logItem;
    private javax.swing.JMenuItem loginItem;
    private javax.swing.JDesktopPane mainDesktopPane;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem propertiesItem;
    private javax.swing.JMenu recordsMenu;
    private javax.swing.JMenu settingsMenu;
    private javax.swing.JLabel status;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JMenuItem zonesItem;
    // End of variables declaration//GEN-END:variables
    
    /**
     *
     */
    public void logged() {
        //setup new window with tree and database content
//        PropertyPanel propPanel = new PropertyPanel();
//        
//        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(jDesktopPane1);
//        jDesktopPane1.setLayout(mainPanelLayout);
//        mainPanelLayout.setHorizontalGroup(
//            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(propPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
//                .addContainerGap())
//        );
//        
//        mainPanelLayout.setVerticalGroup(
//            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(propPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
//                .addContainerGap())
//        );
//        
        
    }
    
    /**
     *
     * @param title
     * @param msg
     */
    public void setMessage(String title, String msg) {
        
        JOptionPane.showMessageDialog(this, msg, title, JOptionPane.INFORMATION_MESSAGE);
        
                
//        loginIFrame.setVisible(false);
//        mainDesktopPane.remove(loginIFrame);       
//        Rectangle b = mainDesktopPane.getBounds();
//        msgPanel.setBounds(b);        
//        msgPanel.setTitleMsg(title, msg);
//        mainDesktopPane.add(msgPanel);
//        System.out.println("test");   
//        msgPanel.setVisible(true);
        
//        Runnable runnable = () -> {
//            try {
//                for (int i = 0; i <= 100; i++) {
//                    Thread.sleep(15);
//                   // msgPanel.getProgressBar().setValue(i);
//                }
//
//            } catch (InterruptedException e) {
//                throw new IllegalStateException(e);
//            }
//            msgPanel.setVisible(false);
//            mainDesktopPane.remove(msgPanel);
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();

        
    }
    
    /**
     *
     */
    public void clearMainPanel() {
        mainDesktopPane.removeAll();
        mainPanel.removeAll();
        refresh();
    }
    
    /**
     *
     * @throws java.lang.Exception
     */
    public void setPropertyPanel() throws Exception {
       
        propertyPanel = new PropertyPanel(this);
        Rectangle b;
        b = mainDesktopPane.getBounds();        
        propertyPanel.setBounds(b);
       // propertyPanel.getTree();
        mainPanel.add(propertyPanel);       
        
        System.out.println("Property Panel wystartował");
       // LayoutManager l = mainDesktopPane.getLayout();
        
        //propertyPanel.setLayout(l);
        
       // mainDesktopPane.add(propertyPanel);
        propertyPanel.setVisible(true);
        refresh();
        
    }
    
    /**
     *
     * @param user
     */
    public void setConnectedUser(User user){
        connectedUser = user;
        status.setText("Połączono - " + user.getDisplayName());
        loginItem.setText("Wyloguj");
        System.out.println("Ustawiam użytkownika " + user);
    }
    
     /**
     *
     * @return 
     */
    public Countries getCountries(){
        return countries;
    }
    
    private void refresh(){
        this.validate();
        this.repaint();
    }
}
