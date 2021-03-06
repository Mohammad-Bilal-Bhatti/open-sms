/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import beans.PermissionBean;
import beans.RoleBean;
import dao.RolePermissionDao;
import daoimpl.RoleDaoImpl;
import daoimpl.RolePermissionDaoImpl;

/**
 *
 * @author Amjad Ali Dahri
 */
public class PermissionFrame extends javax.swing.JFrame {

    /**
     * Creates new form PermissionFrame
     */
    RolePermissionDao rolePermissionDao = new RolePermissionDaoImpl();
    DefaultListModel model1, model2;
    List<PermissionBean> assignPermissionList = new ArrayList<>();
    List<PermissionBean> revokePermissionList = new ArrayList<>();

    public PermissionFrame() {
        initComponents();
        Toolkit t = Toolkit.getDefaultToolkit();
        this.setSize(t.getScreenSize().width, t.getScreenSize().height);
        this.setLocationRelativeTo(null);
        updatelbl.setVisible(false);
        checkPermissions();
        model1 = new DefaultListModel();
        model2 = new DefaultListModel();
        assignedlist.setModel(model2);
        unassignedlist.setModel(model1);
        populateRoleCombo();
        populateAllPermissions();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cutlbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rolecombo = new javax.swing.JComboBox<>();
        assignedPermissionLabel = new javax.swing.JLabel();
        unassignedPermisstionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        unassignedlist = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        assignedlist = new javax.swing.JList<>();
        updatelbl = new javax.swing.JLabel();
        forwardlbl = new javax.swing.JLabel();
        forwardlbl1 = new javax.swing.JLabel();
        backwardlbl = new javax.swing.JLabel();
        backwardlbl1 = new javax.swing.JLabel();
        selectRoleLabel = new javax.swing.JLabel();
        permissionHeader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cutlbl.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        cutlbl.setForeground(new java.awt.Color(255, 255, 255));
        cutlbl.setText("X");
        cutlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cutlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cutlblMouseClicked(evt);
            }
        });
        getContentPane().add(cutlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 20, 30, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rolecombo.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        rolecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Role", " " }));
        rolecombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rolecomboItemStateChanged(evt);
            }
        });
        jPanel1.add(rolecombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 310, 40));

        assignedPermissionLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        assignedPermissionLabel.setText("Assigned Permissions");
        jPanel1.add(assignedPermissionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 210, 40));

        unassignedPermisstionLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        unassignedPermisstionLabel.setText("Un_Assigned Permissions");
        jPanel1.add(unassignedPermisstionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 210, 40));

        unassignedlist.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        unassignedlist.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(unassignedlist);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 250, 400));

        assignedlist.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jScrollPane2.setViewportView(assignedlist);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 250, 400));

        updatelbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updatebtn.png"))); // NOI18N
        updatelbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatelblMouseClicked(evt);
            }
        });
        jPanel1.add(updatelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 610, 170, 50));

        forwardlbl.setBackground(new java.awt.Color(51, 102, 0));
        forwardlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forwardbtn.png"))); // NOI18N
        forwardlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forwardlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forwardlblMouseClicked(evt);
            }
        });
        jPanel1.add(forwardlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 70, 70));

        forwardlbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forwardbtn1.png"))); // NOI18N
        forwardlbl1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forwardlbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forwardlbl1MouseClicked(evt);
            }
        });
        jPanel1.add(forwardlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 70, 70));

        backwardlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backwardbtn.png"))); // NOI18N
        backwardlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backwardlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backwardlblMouseClicked(evt);
            }
        });
        jPanel1.add(backwardlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 70, 70));

        backwardlbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backwardbtn1.png"))); // NOI18N
        backwardlbl1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backwardlbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backwardlbl1MouseClicked(evt);
            }
        });
        jPanel1.add(backwardlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, 70, 70));

        selectRoleLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        selectRoleLabel.setText("Select Role");
        jPanel1.add(selectRoleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1370, 690));

        permissionHeader.setBackground(new java.awt.Color(0, 102, 0));
        permissionHeader.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        permissionHeader.setForeground(new java.awt.Color(255, 255, 255));
        permissionHeader.setText("                                                                                    PERMISSIONS");
        permissionHeader.setOpaque(true);
        getContentPane().add(permissionHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 1370, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cutlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutlblMouseClicked
        new MainFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cutlblMouseClicked

    private void rolecomboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rolecomboItemStateChanged
        RoleBean role = null;
        if (rolecombo.getSelectedIndex() > 0) {
            List<RoleBean> roles = new RoleDaoImpl().getAllRoles();
            for (RoleBean r : roles) {
                if (r.getRole().equalsIgnoreCase(rolecombo.getSelectedItem().toString())) {
                    role = r;
                    break;
                }
            }
            populateAssignedPermissions(role);
            populateUnAssignedPermissions(role);
        } else {
            populateAllPermissions();
        }
    }//GEN-LAST:event_rolecomboItemStateChanged

    private void forwardlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwardlblMouseClicked
        String permission = unassignedlist.getSelectedValue();
        assignPermissionList.add(rolePermissionDao.getPermissionByName(permission));
        model2.addElement(permission);
        model1.removeElement(permission);
    }//GEN-LAST:event_forwardlblMouseClicked

    private void backwardlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backwardlblMouseClicked
        String permission = assignedlist.getSelectedValue();
        revokePermissionList.add(rolePermissionDao.getPermissionByName(permission));
        model1.addElement(permission);
        model2.removeElement(permission);
    }//GEN-LAST:event_backwardlblMouseClicked

    private void forwardlbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwardlbl1MouseClicked
        PermissionBean permission = null;
        for (int i = 0; i < model1.getSize(); i++) {
            permission = rolePermissionDao.getPermissionByName(model1.getElementAt(i).toString());
            model2.addElement(permission.getPermission());
            assignPermissionList.add(permission);
        }
        model1.removeAllElements();
    }//GEN-LAST:event_forwardlbl1MouseClicked

    private void backwardlbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backwardlbl1MouseClicked
        PermissionBean permission = null;
        for (int i = 0; i < model2.getSize(); i++) {
            permission = rolePermissionDao.getPermissionByName(model2.getElementAt(i).toString());
            model1.addElement(permission.getPermission());
            revokePermissionList.add(permission);
        }
        model2.removeAllElements();
    }//GEN-LAST:event_backwardlbl1MouseClicked

    private void updatelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatelblMouseClicked
        if (rolecombo.getSelectedIndex() > 0) {
            int check1 = 0, check2 = 0;
            RoleBean roleBean = LoginFrame.userBean.getRole();
            if (assignPermissionList.size() > 0) {
                check1 = rolePermissionDao.assignPermissions(assignPermissionList, roleBean);
            }
            if (revokePermissionList.size() > 0) {
                check2 = rolePermissionDao.revokePermissions(revokePermissionList, roleBean);
            }
            if (check1 > 0 || check2 > 0) {
                assignPermissionList.clear();
                revokePermissionList.clear();
                new MessageForm("Success", "Permissions updated", "success.png").setVisible(true);
            }
        } else {
            new MessageForm("Warning", "Select any role", "error.png").setVisible(true);
        }
    }//GEN-LAST:event_updatelblMouseClicked

    private void populateRoleCombo() {
        List<RoleBean> roles = new RoleDaoImpl().getAllRoles();
        rolecombo.removeAllItems();
        rolecombo.addItem("Select Role");
        for (RoleBean role : roles) {
            rolecombo.addItem(role.getRole());
        }
    }

    private void populateAllPermissions() {
        List<PermissionBean> permissions = rolePermissionDao.getAllPermissions();
        model1.removeAllElements();
        model2.removeAllElements();
        for (PermissionBean permission : permissions) {
            model1.addElement(permission.getPermission());
        }
    }

    private void populateAssignedPermissions(RoleBean role) {
        List<PermissionBean> assignedPermissions = rolePermissionDao.getAssignedPermissions(role);
        model2.removeAllElements();
        for (PermissionBean permission : assignedPermissions) {
            model2.addElement(permission.getPermission());
        }
    }

    private void populateUnAssignedPermissions(RoleBean role) {
        List<PermissionBean> unAssignedPermissions = rolePermissionDao.getUnassigndPermissios(role);
        model1.removeAllElements();
        for (PermissionBean permission : unAssignedPermissions) {
            model1.addElement(permission.getPermission());
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
            java.util.logging.Logger.getLogger(PermissionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PermissionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PermissionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PermissionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PermissionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assignedPermissionLabel;
    private javax.swing.JList<String> assignedlist;
    private javax.swing.JLabel backwardlbl;
    private javax.swing.JLabel backwardlbl1;
    private javax.swing.JLabel cutlbl;
    private javax.swing.JLabel forwardlbl;
    private javax.swing.JLabel forwardlbl1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel permissionHeader;
    private javax.swing.JComboBox<String> rolecombo;
    private javax.swing.JLabel selectRoleLabel;
    private javax.swing.JLabel unassignedPermisstionLabel;
    private javax.swing.JList<String> unassignedlist;
    private javax.swing.JLabel updatelbl;
    // End of variables declaration//GEN-END:variables

    private void checkPermissions() {
        List<PermissionBean> permissions = new RolePermissionDaoImpl().getAssignedPermissions(LoginFrame.userBean.getRole());
        for (PermissionBean pb : permissions) {
            if (pb.getPermission().equals("update")) {
                updatelbl.setVisible(true);
            }
        }
    }
}
