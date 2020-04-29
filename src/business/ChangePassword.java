/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import daoimpl.EmployeeDaoImpl;

/**
 *
 * @author Javed Ali Dahri
 */
public class ChangePassword extends javax.swing.JFrame {

    /**
     * Creates new form ChangePassword
     */
    public ChangePassword() {
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

        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        headertext = new javax.swing.JLabel();
        closeBtn = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        newPassLabel = new javax.swing.JLabel();
        oldPassLabel = new javax.swing.JLabel();
        showpasswordcheck = new javax.swing.JCheckBox();
        changepasswordlbl = new javax.swing.JLabel();
        clearlbl = new javax.swing.JLabel();
        oldpasswordtxt = new javax.swing.JPasswordField();
        newpasswordtxt = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 153, 0));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headertext.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        headertext.setForeground(new java.awt.Color(255, 255, 255));
        headertext.setText("Change Password");
        header.add(headertext, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, 70));

        closeBtn.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        closeBtn.setForeground(new java.awt.Color(255, 255, 255));
        closeBtn.setText("X");
        closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
        });
        header.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 20, 30));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 390, -1));

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        newPassLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newPassLabel.setText("New Password");

        oldPassLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        oldPassLabel.setText("Old Password");

        showpasswordcheck.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showpasswordcheck.setText("Show Password");
        showpasswordcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpasswordcheckActionPerformed(evt);
            }
        });

        changepasswordlbl.setBackground(new java.awt.Color(0, 153, 0));
        changepasswordlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        changepasswordlbl.setForeground(new java.awt.Color(255, 255, 255));
        changepasswordlbl.setText("   Change Password");
        changepasswordlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changepasswordlbl.setOpaque(true);
        changepasswordlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changepasswordlblMouseClicked(evt);
            }
        });

        clearlbl.setBackground(new java.awt.Color(0, 153, 0));
        clearlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearlbl.setForeground(new java.awt.Color(255, 255, 255));
        clearlbl.setText("           Clear");
        clearlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearlbl.setOpaque(true);
        clearlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearlblMouseClicked(evt);
            }
        });

        oldpasswordtxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oldpasswordtxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        newpasswordtxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newpasswordtxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(changepasswordlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(oldPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(oldpasswordtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(newPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(showpasswordcheck)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(newpasswordtxt))))
                .addGap(49, 49, 49))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldpasswordtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newpasswordtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showpasswordcheck)
                .addGap(18, 18, 18)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(changepasswordlbl, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(clearlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 390, 200));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        this.dispose();
    }//GEN-LAST:event_closeBtnMouseClicked

    private void showpasswordcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpasswordcheckActionPerformed
        if (showpasswordcheck.isSelected()) {
            oldpasswordtxt.setEchoChar((char) 0);
            newpasswordtxt.setEchoChar((char) 0);
        } else {
            oldpasswordtxt.setEchoChar('*');
            newpasswordtxt.setEchoChar('*');
        }
    }//GEN-LAST:event_showpasswordcheckActionPerformed

    private void clearlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearlblMouseClicked
        oldpasswordtxt.setText("");
        newpasswordtxt.setText("");
        showpasswordcheck.setSelected(false);
    }//GEN-LAST:event_clearlblMouseClicked

    private void changepasswordlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepasswordlblMouseClicked
        if (!oldpasswordtxt.getText().equals("") && !newpasswordtxt.getText().equals("")) {
            if (LoginFrame.userBean.getPassword().equals(oldpasswordtxt.getText())) {
                if (new EmployeeDaoImpl().changePassword(LoginFrame.userBean, newpasswordtxt.getText()) > 0) {
                    new LoginFrame().setVisible(true);
                } else {
                    new MessageForm("Error", "Password not changed", "error.png").setVisible(true);
                }
            } else {
                new MessageForm("Error", "Old password is wrong", "error.png").setVisible(true);
            }
        } else {
            new MessageForm("Error", "Fields are empty", "error.png").setVisible(true);
        }
    }//GEN-LAST:event_changepasswordlblMouseClicked

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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel changepasswordlbl;
    private javax.swing.JLabel clearlbl;
    private javax.swing.JLabel closeBtn;
    private javax.swing.JPanel header;
    private javax.swing.JLabel headertext;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel main;
    private javax.swing.JLabel newPassLabel;
    private javax.swing.JPasswordField newpasswordtxt;
    private javax.swing.JLabel oldPassLabel;
    private javax.swing.JPasswordField oldpasswordtxt;
    private javax.swing.JCheckBox showpasswordcheck;
    // End of variables declaration//GEN-END:variables
}