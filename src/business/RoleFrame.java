/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import beans.EmployeeBean;
import beans.PermissionBean;
import beans.RoleBean;
import dao.RoleDao;
import daoimpl.RoleDaoImpl;
import daoimpl.RolePermissionDaoImpl;
import utility.CurrentDate;
import utility.UtilityMethods;

/**
 *
 * @author Amjad Ali Dahri
 */
public class RoleFrame extends javax.swing.JFrame {

    /**
     * Creates new form RoleFrame
     */
    RoleDao roleDao = new RoleDaoImpl();
    EmployeeBean emp = null;

    public RoleFrame() {
        initComponents();
        this.emp = LoginFrame.userBean;
        Toolkit t = Toolkit.getDefaultToolkit();
        this.setSize(t.getScreenSize().width, t.getScreenSize().height);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        roletable.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,16));
        hideAllButtons();
        checkPermissions();
        populateRoleTable();
        clearFields();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        close = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        roletxt = new javax.swing.JTextField();
        addlbl = new javax.swing.JLabel();
        updatelbl = new javax.swing.JLabel();
        deletelbl = new javax.swing.JLabel();
        resetlbl = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roletable = new javax.swing.JTable();
        roleHeader = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        searchLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setText("X");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 20, 20, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roletxt.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        roletxt.setText("Enter role name here");
        roletxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        roletxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                roletxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                roletxtFocusLost(evt);
            }
        });
        roletxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roletxtMouseClicked(evt);
            }
        });
        jPanel1.add(roletxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 44, 280, 40));

        addlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addbtn.png"))); // NOI18N
        addlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addlblMouseClicked(evt);
            }
        });
        jPanel1.add(addlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 164, -1));

        updatelbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updatebtn.png"))); // NOI18N
        updatelbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatelblMouseClicked(evt);
            }
        });
        jPanel1.add(updatelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        deletelbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deletebtn.png"))); // NOI18N
        deletelbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletelblMouseClicked(evt);
            }
        });
        jPanel1.add(deletelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        resetlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/resetbtn.png"))); // NOI18N
        resetlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetlblMouseClicked(evt);
            }
        });
        jPanel1.add(resetlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        roleLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        roleLabel.setText("Role");
        jPanel1.add(roleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 350, 420));

        roletable.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        roletable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Role ID", "Role Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roletable.setRowHeight(20);
        roletable.setRowMargin(2);
        roletable.setSelectionBackground(new java.awt.Color(0, 102, 0));
        roletable.getTableHeader().setResizingAllowed(false);
        roletable.getTableHeader().setReorderingAllowed(false);
        roletable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roletableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(roletable);
        if (roletable.getColumnModel().getColumnCount() > 0) {
            roletable.getColumnModel().getColumn(0).setResizable(false);
            roletable.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 970, 420));

        roleHeader.setBackground(new java.awt.Color(0, 102, 0));
        roleHeader.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        roleHeader.setForeground(new java.awt.Color(255, 255, 255));
        roleHeader.setText("                                                                                             ROLE");
        roleHeader.setOpaque(true);
        getContentPane().add(roleHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 70));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1159, 100, 200, 30));

        searchLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        searchLabel.setText("Search");
        getContentPane().add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1095, 100, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        new MainFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void roletxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roletxtFocusGained
        if (roletxt.getText().equals("Enter role name here")) {
            roletxt.setText("");
        }
    }//GEN-LAST:event_roletxtFocusGained

    private void roletxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roletxtFocusLost
        if (roletxt.getText().isEmpty()) {
            roletxt.setText("Enter role name here");
        }
    }//GEN-LAST:event_roletxtFocusLost

    private void addlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addlblMouseClicked
        if (roletable.getSelectedRow() == -1) {
            RoleBean role = new RoleBean();
            if (!roletxt.getText().isEmpty() && !roletxt.getText().equalsIgnoreCase("Enter role name here")) {
                role.setRole(roletxt.getText());
                role.setCreatedBy(emp.getEmpId());
                role.setCreatedDate(CurrentDate.getCurrentDate() + "");
                if (roleDao.addRole(role) > 0) {
                    populateRoleTable();
                    roletxt.setText("Enter role name here");
                } else {
                    new MessageForm("Error", "Role not added", "error.png").setVisible(true);
                }
            }
        } else {
            new MessageForm("Error", "Record is duplicate", "error.png").setVisible(true);
        }
    }//GEN-LAST:event_addlblMouseClicked

    private void updatelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatelblMouseClicked
        if (roletable.getSelectedRow() != -1) {
            RoleBean role = new RoleBean();
            if (!roletxt.getText().isEmpty() && !roletxt.getText().equalsIgnoreCase("Enter role name here")) {
                role.setRoleId(Integer.parseInt(roletable.getValueAt(roletable.getSelectedRow(), 0).toString()));
                role.setRole(roletxt.getText());
                role.setModifiedBy(emp.getEmpId());
                role.setModifiedDate(CurrentDate.getCurrentDate() + "");
                if (roleDao.updateRole(role) > 0) {
                    populateRoleTable();
                    clearFields();
                } else {
                    new MessageForm("Error", "Role not updated", "error.png");
                }
            }
        } else {
            new MessageForm("Error", "Record not selected", "error.png").setVisible(true);
        }
    }//GEN-LAST:event_updatelblMouseClicked

    private void deletelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletelblMouseClicked
        if (roletable.getSelectedRow() != -1) {
            RoleBean role = new RoleBean();
            role.setRoleId(Integer.parseInt(roletable.getValueAt(roletable.getSelectedRow(), 0).toString()));
            role.setModifiedBy(emp.getEmpId());
            role.setModifiedDate(CurrentDate.getCurrentDate() + "");
            if (roleDao.deleteRole(role) > 0) {
                populateRoleTable();
                clearFields();
            } else {
                new MessageForm("Error", "Role not deleted", "error.png").setVisible(true);
            }
        } else {
            new MessageForm("Error", "Record not selected", "error.png").setVisible(true);
        }
    }//GEN-LAST:event_deletelblMouseClicked

    private void roletableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roletableMouseClicked
        roletxt.setText(roletable.getValueAt(roletable.getSelectedRow(), 1).toString());

    }//GEN-LAST:event_roletableMouseClicked

    private void roletxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roletxtMouseClicked
        if (roletxt.getText().equalsIgnoreCase("Enter role name here")) {
            roletxt.setText("");
        }
    }//GEN-LAST:event_roletxtMouseClicked

    private void resetlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetlblMouseClicked
        clearFields();
    }//GEN-LAST:event_resetlblMouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        UtilityMethods.searchDataFromTable(roletable, jTextField1);
    }//GEN-LAST:event_jTextField1KeyPressed

    private void populateRoleTable() {
        List<RoleBean> roles = roleDao.getAllRoles();
        DefaultTableModel dtm = (DefaultTableModel) roletable.getModel();
        dtm.setRowCount(0);
        for (RoleBean role : roles) {
            Object[] values = {role.getRoleId(), role.getRole()};
            dtm.addRow(values);
        }
        //UtilityMethods.fillDataIntoTables(rs, batchtable, jScrollPane1, this);
    }

    private void clearFields() {
        roletxt.setText("Enter role name here");
        roletable.clearSelection();
    }

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
            java.util.logging.Logger.getLogger(RoleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoleFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addlbl;
    private javax.swing.JLabel close;
    private javax.swing.JLabel deletelbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel resetlbl;
    private javax.swing.JLabel roleHeader;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JTable roletable;
    private javax.swing.JTextField roletxt;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel updatelbl;
    // End of variables declaration//GEN-END:variables

    private void hideAllButtons() {
        addlbl.setVisible(false);
        updatelbl.setVisible(false);
        deletelbl.setVisible(false);
    }

    private void checkPermissions() {
        List<PermissionBean> permissions = new RolePermissionDaoImpl().getAssignedPermissions(LoginFrame.userBean.getRole());
        for (PermissionBean pb : permissions) {
            if (pb.getPermission().equals("add")) {
                addlbl.setVisible(true);
            }
            if (pb.getPermission().equals("update")) {
                updatelbl.setVisible(true);
            }
            if (pb.getPermission().equals("delete")) {
                deletelbl.setVisible(true);
            }
        }
    }
}
