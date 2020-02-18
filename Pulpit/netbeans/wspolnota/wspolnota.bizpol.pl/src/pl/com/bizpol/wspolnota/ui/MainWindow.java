package pl.com.bizpol.wspolnota.ui;


import java.net.URL;
import javax.swing.ImageIcon;

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
    
    
    LoginIFrame loginIFrame = new LoginIFrame();

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        //icon to project
        URL url = getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/home_icon&16.png");
        ImageIcon imgicon = new ImageIcon(url);
        super.setIconImage(imgicon.getImage());
        
        
        initComponents();       
       
        //newConnection1.setVisible(false);
        //position oin screen
        this.setLocationRelativeTo(null);
       // this.logged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jSplitPane1 = new javax.swing.JSplitPane();
        mainPanel = new javax.swing.JPanel();
        footerPanel = new javax.swing.JPanel();
        ststusLabel = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        author = new javax.swing.JLabel();
        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        connectItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        recordsMenu = new javax.swing.JMenu();
        propertiesItem = new javax.swing.JMenuItem();
        settingsMenu = new javax.swing.JMenu();
        countriesItem = new javax.swing.JMenuItem();
        zonesItem = new javax.swing.JMenuItem();
        citiesItem = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Moja wspólnota");
        setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        footerPanel.setBackground(java.awt.SystemColor.controlLtHighlight);
        footerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ststusLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ststusLabel.setText("STATUS:");

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
                .addComponent(ststusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addComponent(author))
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ststusLabel)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(author)))
        );

        mainMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/2x2_grid_icon&16.png"))); // NOI18N
        fileMenu.setText("Program");

        connectItem.setFont(connectItem.getFont().deriveFont(connectItem.getFont().getSize()-1f));
        connectItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/com/bizpol/wspolnota/icons/cc/black/png/connect_icon&16.png"))); // NOI18N
        connectItem.setText("Zaloguj się");
        connectItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        connectItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectItemActionPerformed(evt);
            }
        });
        fileMenu.add(connectItem);

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
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void connectItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectItemActionPerformed
        // TODO add your handling code here:
        
        System.out.println("przycisk connect");        
        
        loginIFrame.setVisible(true);
        mainPanel.add(loginIFrame);       
        
        
        //conect.main(['archii','lewiss']);
    }//GEN-LAST:event_connectItemActionPerformed

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
        // 
        System.out.println("przycisk cities");
        citiesIFrame.setVisible(true);
        
        mainPanel.add(citiesIFrame);
    }//GEN-LAST:event_citiesItemActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel author;
    private javax.swing.JMenuItem citiesItem;
    private javax.swing.JMenuItem connectItem;
    private javax.swing.JMenuItem countriesItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem propertiesItem;
    private javax.swing.JMenu recordsMenu;
    private javax.swing.JMenu settingsMenu;
    private javax.swing.JLabel status;
    private javax.swing.JLabel ststusLabel;
    private javax.swing.JMenuItem zonesItem;
    // End of variables declaration//GEN-END:variables
    
    public void logged() {
        //setup new window with tree and database content
        PropertyPanel propPanel = new PropertyPanel();
        
        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(propPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(propPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        
    }
}
