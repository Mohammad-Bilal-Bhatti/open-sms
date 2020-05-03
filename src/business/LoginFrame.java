/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import beans.EmployeeBean;
import connection.DBConnection;
import dao.SystemDao;
import daoimpl.EmployeeDaoImpl;
import daoimpl.SystemDaoImpl;
import utility.Crypto;

/**
 *
 * @author Javed Ali Dahri
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public static EmployeeBean userBean;
    boolean check = true;

    public LoginFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        Toolkit t = Toolkit.getDefaultToolkit();
        this.setSize(t.getScreenSize().width, t.getScreenSize().height);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        endlbl = new javax.swing.JLabel();
        loginlbl = new javax.swing.JLabel();
        usernametxt = new javax.swing.JTextField();
        userFieldBg = new javax.swing.JLabel();
        passtxt = new javax.swing.JPasswordField();
        forgotPassword = new javax.swing.JLabel();
        eyeicon = new javax.swing.JLabel();
        passFieldBg = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        endlbl.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        endlbl.setForeground(new java.awt.Color(255, 255, 255));
        endlbl.setText("x");
        endlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        endlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endlblMouseClicked(evt);
            }
        });
        getContentPane().add(endlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 30, -1));

        loginlbl.setBackground(new java.awt.Color(0, 50, 0));
        loginlbl.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        loginlbl.setForeground(new java.awt.Color(255, 255, 255));
        loginlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        loginlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginlblMouseClicked(evt);
            }
        });
        getContentPane().add(loginlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 540, 220, 60));

        usernametxt.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        usernametxt.setForeground(new java.awt.Color(153, 153, 153));
        usernametxt.setText("Username");
        usernametxt.setBorder(null);
        usernametxt.setOpaque(false);
        usernametxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernametxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernametxtFocusLost(evt);
            }
        });
        usernametxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usernametxtMouseEntered(evt);
            }
        });
        getContentPane().add(usernametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 420, 60));

        userFieldBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userlbl.png"))); // NOI18N
        getContentPane().add(userFieldBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 500, 60));

        passtxt.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        passtxt.setForeground(new java.awt.Color(153, 153, 153));
        passtxt.setText("password");
        passtxt.setBorder(null);
        passtxt.setFocusAccelerator('V');
        passtxt.setOpaque(false);
        passtxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passtxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passtxtFocusLost(evt);
            }
        });
        passtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passtxtKeyPressed(evt);
            }
        });
        getContentPane().add(passtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 390, 380, 60));

        forgotPassword.setBackground(new java.awt.Color(0, 153, 0));
        forgotPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        forgotPassword.setForeground(new java.awt.Color(255, 255, 255));
        forgotPassword.setText("Forgot Password");
        forgotPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        forgotPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPasswordMouseClicked(evt);
            }
        });
        getContentPane().add(forgotPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 460, 110, 30));

        eyeicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye_open.png"))); // NOI18N
        eyeicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyeiconMouseClicked(evt);
            }
        });
        getContentPane().add(eyeicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 390, 40, 60));

        passFieldBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/passlbl.png"))); // NOI18N
        getContentPane().add(passFieldBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 390, 500, 60));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loginFrame.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1370, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void endlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endlblMouseClicked
        this.dispose();
    }//GEN-LAST:event_endlblMouseClicked

    private void loginlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseClicked
        login();
    }//GEN-LAST:event_loginlblMouseClicked

    private void usernametxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernametxtFocusGained
        if (usernametxt.getText().equalsIgnoreCase("Username")) {
            usernametxt.setText("");
        }
    }//GEN-LAST:event_usernametxtFocusGained

    private void usernametxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernametxtMouseEntered

    }//GEN-LAST:event_usernametxtMouseEntered

    private void usernametxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernametxtFocusLost
        if (usernametxt.getText().isEmpty()) {
            usernametxt.setText("Username");
        }
    }//GEN-LAST:event_usernametxtFocusLost

    private void passtxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passtxtFocusGained
        if (passtxt.getText().equalsIgnoreCase("Password")) {
            passtxt.setEchoChar('\u25cf');
            passtxt.setText("");
        }
        if (!passtxt.getText().equals("")) {

        }
    }//GEN-LAST:event_passtxtFocusGained

    private void passtxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passtxtFocusLost
        if (passtxt.getText().isEmpty()) {
            passtxt.setText("Password");
            passtxt.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_passtxtFocusLost

    private void passtxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passtxtKeyPressed
        if (evt.getKeyCode() == 10) {
            login();
        }
        if (!passtxt.getText().equals("")) {
            eyeicon.setIcon(new ImageIcon(getClass().getResource("/images/eye_close.png")));
        } else {
            eyeicon.setIcon(null);
            passtxt.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_passtxtKeyPressed

    private void forgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordMouseClicked
        new ForgotPassword().setVisible(true);
    }//GEN-LAST:event_forgotPasswordMouseClicked

    private void eyeiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeiconMouseClicked
        if (eyeicon.getIcon() != null) {
            if (check) {
                eyeicon.setIcon(new ImageIcon(getClass().getResource("/images/eye_open.png")));
                passtxt.setEchoChar((char) 0);
                check = false;
            } else {
                eyeicon.setIcon(new ImageIcon(getClass().getResource("/images/eye_close.png")));
                passtxt.setEchoChar('\u25cf');
                check = true;
            }
        }
    }//GEN-LAST:event_eyeiconMouseClicked

    private void login() {
        if (!usernametxt.getText().equals("") && !passtxt.getText().equals("")) {
            userBean = new EmployeeBean();
            userBean.setUserName(usernametxt.getText());
            userBean.setPassword(passtxt.getText());

            userBean = new EmployeeDaoImpl().checkLogin(userBean);
            if (userBean != null) {
                new MainFrame().setVisible(true);
                this.dispose();
            } else {
                new MessageForm("Error", "Wrong username or password", "error.png").setVisible(true);
            }
        } else {
            new MessageForm("Error", "Fields are empty", "error.png").setVisible(true);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        if (DBConnection.checkDB()) {
            SystemDao system = new SystemDaoImpl();
            String macAddress = Crypto.getEncryptedAddress(Crypto.getMacAddress());
            if (system.checkMacAddress(macAddress)) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new LoginFrame().setVisible(true);
                    }
                });
            } else {
                new RegisterationFrame().setVisible(true);
            }
        } else {
            new ChooseDatabase().setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel endlbl;
    private javax.swing.JLabel eyeicon;
    private javax.swing.JLabel forgotPassword;
    private javax.swing.JLabel loginlbl;
    private javax.swing.JLabel passFieldBg;
    private javax.swing.JPasswordField passtxt;
    private javax.swing.JLabel userFieldBg;
    private javax.swing.JTextField usernametxt;
    // End of variables declaration//GEN-END:variables
}
