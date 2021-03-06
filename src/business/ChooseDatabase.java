/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import connection.DBConnection;
import utility.CustomFileFilter;

/**
 *
 * @author Javed Ali Dahri
 */
public class ChooseDatabase extends javax.swing.JFrame {

    /**
     * Creates new form ChooseDatabase
     */
    File choosedDBFile;

    public ChooseDatabase() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        chooseHeader = new javax.swing.JLabel();
        newLogin = new javax.swing.JLabel();
        chooseDb = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setText("X");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 10, 30));

        chooseHeader.setBackground(new java.awt.Color(0, 102, 0));
        chooseHeader.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        chooseHeader.setForeground(new java.awt.Color(255, 255, 255));
        chooseHeader.setText("               Choose Database");
        chooseHeader.setOpaque(true);
        jPanel1.add(chooseHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 440, 60));

        newLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newlogin.png"))); // NOI18N
        newLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newLoginMouseClicked(evt);
            }
        });
        jPanel1.add(newLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 220, 40));

        chooseDb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/choosebtn.png"))); // NOI18N
        chooseDb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseDb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseDbMouseClicked(evt);
            }
        });
        jPanel1.add(chooseDb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 220, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 444, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        this.dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void newLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newLoginMouseClicked
        if (DBConnection.checkDB()) {
            new LoginFrame().setVisible(true);
            this.dispose();
        } else {
            new MessageForm("Error", "Database not found...", "error.png").setVisible(true);
        }
    }//GEN-LAST:event_newLoginMouseClicked

    private void chooseDbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseDbMouseClicked
        JFileChooser fileChooser = new JFileChooser("D:\\");
        fileChooser.setFileFilter(new CustomFileFilter(new String[]{"sqlite"}));
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int check = fileChooser.showDialog(null, "Choose Database");
        if (check == JFileChooser.APPROVE_OPTION) {
            choosedDBFile = fileChooser.getSelectedFile();
            try {
                copyDatabaseFile(choosedDBFile);
            } catch (Exception ex) {
                new MessageForm("Error", "Please select valid file", "error.png").setVisible(true);
            }
        }
    }//GEN-LAST:event_chooseDbMouseClicked

    public static void copyDatabaseFile(File fileChoosed) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            File f = new File(fileChoosed.getAbsolutePath());
            File f2 = new File("star_academy_db.sqlite");

            is = new FileInputStream(f);
            os = new FileOutputStream(f2);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

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
            java.util.logging.Logger.getLogger(ChooseDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseDatabase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chooseDb;
    private javax.swing.JLabel chooseHeader;
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel newLogin;
    // End of variables declaration//GEN-END:variables

}
