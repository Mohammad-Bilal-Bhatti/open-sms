/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.List;
import beans.PermissionBean;
import daoimpl.RolePermissionDaoImpl;
import utility.UtilityMethods;

/**
 *
 * @author Javed Ali Dahri
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        Toolkit t = Toolkit.getDefaultToolkit();
        usernamelbl.setText(LoginFrame.userBean.getUserName());
        this.setSize(t.getScreenSize().width, t.getScreenSize().height);
        this.setLocationRelativeTo(null);
        hideAllButtonsAndMenuItems();
        checkPermissions();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutlbl = new javax.swing.JLabel();
        passchangelbl = new javax.swing.JLabel();
        studentlbl = new javax.swing.JLabel();
        emplbl = new javax.swing.JLabel();
        courselbl = new javax.swing.JLabel();
        batchlbl = new javax.swing.JLabel();
        shiftlbl = new javax.swing.JLabel();
        feeslbl = new javax.swing.JLabel();
        permissionlbl = new javax.swing.JLabel();
        exptypelbl = new javax.swing.JLabel();
        expenselbl = new javax.swing.JLabel();
        profitlbl = new javax.swing.JLabel();
        rolelbl = new javax.swing.JLabel();
        courseassignmentlbl = new javax.swing.JLabel();
        usernamelbl = new javax.swing.JLabel();
        userlbl2 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        studentMenuItem = new javax.swing.JMenuItem();
        BatchMenuItem = new javax.swing.JMenuItem();
        ExpensesMenuItem = new javax.swing.JMenuItem();
        ProfitMenuItem = new javax.swing.JMenuItem();
        EmployeeMenuItem = new javax.swing.JMenuItem();
        ShiftMenuItem = new javax.swing.JMenuItem();
        ExpenseTypeMenuItem = new javax.swing.JMenuItem();
        CourseAssignmentMenuItem = new javax.swing.JMenuItem();
        CoursesMenuItem = new javax.swing.JMenuItem();
        FeesMenuItem = new javax.swing.JMenuItem();
        PermissionsMenuItem = new javax.swing.JMenuItem();
        RoleMenuItem = new javax.swing.JMenuItem();
        logoutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoutbutn.png"))); // NOI18N
        logoutlbl.setToolTipText("Logout Here");
        logoutlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutlbl.setFocusable(false);
        logoutlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutlblMouseClicked(evt);
            }
        });
        getContentPane().add(logoutlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 130, 130));

        passchangelbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/passbtn.png"))); // NOI18N
        passchangelbl.setToolTipText("Change Password");
        passchangelbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        passchangelbl.setFocusable(false);
        passchangelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passchangelblMouseClicked(evt);
            }
        });
        getContentPane().add(passchangelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 160, -1, -1));

        studentlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stdbtn.png"))); // NOI18N
        studentlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentlblMouseClicked(evt);
            }
        });
        getContentPane().add(studentlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 200, 120));

        emplbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/employeebtn.png"))); // NOI18N
        emplbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        emplbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emplblMouseClicked(evt);
            }
        });
        getContentPane().add(emplbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 200, -1));

        courselbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coursebtn.png"))); // NOI18N
        courselbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        courselbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courselblMouseClicked(evt);
            }
        });
        getContentPane().add(courselbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, 200, 120));

        batchlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/batchbtn.png"))); // NOI18N
        batchlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        batchlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batchlblMouseClicked(evt);
            }
        });
        getContentPane().add(batchlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 200, 120));

        shiftlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shiftbtn.png"))); // NOI18N
        shiftlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shiftlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shiftlblMouseClicked(evt);
            }
        });
        getContentPane().add(shiftlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 200, -1));

        feeslbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Feesbtn.png"))); // NOI18N
        feeslbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        feeslbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feeslblMouseClicked(evt);
            }
        });
        getContentPane().add(feeslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 200, 120));

        permissionlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/permissionbtn.png"))); // NOI18N
        permissionlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        permissionlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                permissionlblMouseClicked(evt);
            }
        });
        getContentPane().add(permissionlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, 200, 120));

        exptypelbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/expense_typebtn.png"))); // NOI18N
        exptypelbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exptypelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exptypelblMouseClicked(evt);
            }
        });
        getContentPane().add(exptypelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 200, -1));

        expenselbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/expensebtn.png"))); // NOI18N
        expenselbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        expenselbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expenselblMouseClicked(evt);
            }
        });
        getContentPane().add(expenselbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 200, 120));

        profitlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profit.png"))); // NOI18N
        profitlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profitlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profitlblMouseClicked(evt);
            }
        });
        getContentPane().add(profitlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, -1, 120));

        rolelbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rolebtn.png"))); // NOI18N
        rolelbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rolelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rolelblMouseClicked(evt);
            }
        });
        getContentPane().add(rolelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 540, 200, 120));

        courseassignmentlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/courseassignmentbtn.png"))); // NOI18N
        courseassignmentlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        courseassignmentlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseassignmentlblMouseClicked(evt);
            }
        });
        getContentPane().add(courseassignmentlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, 190, 130));

        usernamelbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        usernamelbl.setForeground(new java.awt.Color(0, 153, 0));
        getContentPane().add(usernamelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 170, 30));

        userlbl2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        userlbl2.setText("Username :");
        getContentPane().add(userlbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 100, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1370, 810));

        jMenu1.setText("File");

        studentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        studentMenuItem.setText("Student");
        studentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(studentMenuItem);

        BatchMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        BatchMenuItem.setText("Batch");
        BatchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatchMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(BatchMenuItem);

        ExpensesMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        ExpensesMenuItem.setText("Expenses");
        ExpensesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpensesMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(ExpensesMenuItem);

        ProfitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        ProfitMenuItem.setText("Profit");
        ProfitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(ProfitMenuItem);

        EmployeeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        EmployeeMenuItem.setText("Employee");
        EmployeeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(EmployeeMenuItem);

        ShiftMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        ShiftMenuItem.setText("Shift");
        ShiftMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShiftMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(ShiftMenuItem);

        ExpenseTypeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        ExpenseTypeMenuItem.setText("Expense Type");
        ExpenseTypeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpenseTypeMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(ExpenseTypeMenuItem);

        CourseAssignmentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        CourseAssignmentMenuItem.setText("Course Assignment");
        CourseAssignmentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseAssignmentMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(CourseAssignmentMenuItem);

        CoursesMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        CoursesMenuItem.setText("Courses");
        CoursesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoursesMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(CoursesMenuItem);

        FeesMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        FeesMenuItem.setText("Fees");
        FeesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeesMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(FeesMenuItem);

        PermissionsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        PermissionsMenuItem.setText("Permissions");
        PermissionsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PermissionsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(PermissionsMenuItem);

        RoleMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        RoleMenuItem.setText("Role");
        RoleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoleMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(RoleMenuItem);

        logoutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        logoutMenuItem.setText("Logout");
        logoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(logoutMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutlblMouseClicked
        logout();
    }//GEN-LAST:event_logoutlblMouseClicked

    private void passchangelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passchangelblMouseClicked
        new ChangePassword().setVisible(true);    
    }//GEN-LAST:event_passchangelblMouseClicked

    private void batchlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batchlblMouseClicked
        new BatchFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_batchlblMouseClicked

    private void expenselblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenselblMouseClicked
        new ExpenseFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_expenselblMouseClicked

    private void exptypelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exptypelblMouseClicked
        new ExpenseTypeFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_exptypelblMouseClicked

    private void courselblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courselblMouseClicked
        new CourseFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_courselblMouseClicked

    private void permissionlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_permissionlblMouseClicked
        new PermissionFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_permissionlblMouseClicked

    private void rolelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rolelblMouseClicked
        new RoleFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_rolelblMouseClicked

    private void studentlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentlblMouseClicked
        new StudentAdmissionFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_studentlblMouseClicked

    private void profitlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profitlblMouseClicked
        new AnalyzeProfit().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_profitlblMouseClicked

    private void emplblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emplblMouseClicked
        new EmployeeEntryFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_emplblMouseClicked

    private void shiftlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shiftlblMouseClicked
        new ShiftFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_shiftlblMouseClicked

    private void feeslblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_feeslblMouseClicked
//        new StudentFeeFrame().setVisible(true);
//         this.dispose();
    }//GEN-LAST:event_feeslblMouseClicked

    private void studentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentMenuItemActionPerformed
        new StudentAdmissionFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_studentMenuItemActionPerformed

    private void BatchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatchMenuItemActionPerformed
        new BatchFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_BatchMenuItemActionPerformed

    private void ExpensesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpensesMenuItemActionPerformed
        new ExpenseFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_ExpensesMenuItemActionPerformed

    private void ProfitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfitMenuItemActionPerformed
        new AnalyzeProfit().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_ProfitMenuItemActionPerformed

    private void EmployeeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeMenuItemActionPerformed
        new EmployeeEntryFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_EmployeeMenuItemActionPerformed

    private void ShiftMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShiftMenuItemActionPerformed
        new ShiftFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_ShiftMenuItemActionPerformed

    private void ExpenseTypeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpenseTypeMenuItemActionPerformed
        new ExpenseTypeFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_ExpenseTypeMenuItemActionPerformed

    private void CourseAssignmentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseAssignmentMenuItemActionPerformed
        new StudentCourseAssignmentFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_CourseAssignmentMenuItemActionPerformed

    private void CoursesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoursesMenuItemActionPerformed
        new CourseFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_CoursesMenuItemActionPerformed

    private void FeesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeesMenuItemActionPerformed
//        new StudentFeeFrame().setVisible(true);
//         this.dispose();
    }//GEN-LAST:event_FeesMenuItemActionPerformed

    private void PermissionsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PermissionsMenuItemActionPerformed
        new PermissionFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_PermissionsMenuItemActionPerformed

    private void RoleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleMenuItemActionPerformed
        new RoleFrame().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_RoleMenuItemActionPerformed

    private void logoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuItemActionPerformed
        logout();
    }//GEN-LAST:event_logoutMenuItemActionPerformed

    private void courseassignmentlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseassignmentlblMouseClicked
        new StudentCourseAssignmentFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_courseassignmentlblMouseClicked

    private void logout() {
        try {
            UtilityMethods.copyDatabaseFile();
        } catch (IOException ex) {
            new MessageForm("Error", ex.toString(), "error.png").setVisible(true);
        }
        this.dispose();
        System.exit(0);
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BatchMenuItem;
    private javax.swing.JMenuItem CourseAssignmentMenuItem;
    private javax.swing.JMenuItem CoursesMenuItem;
    private javax.swing.JMenuItem EmployeeMenuItem;
    private javax.swing.JMenuItem ExpenseTypeMenuItem;
    private javax.swing.JMenuItem ExpensesMenuItem;
    private javax.swing.JMenuItem FeesMenuItem;
    private javax.swing.JMenuItem PermissionsMenuItem;
    private javax.swing.JMenuItem ProfitMenuItem;
    private javax.swing.JMenuItem RoleMenuItem;
    private javax.swing.JMenuItem ShiftMenuItem;
    private javax.swing.JLabel batchlbl;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel courseassignmentlbl;
    private javax.swing.JLabel courselbl;
    private javax.swing.JLabel emplbl;
    private javax.swing.JLabel expenselbl;
    private javax.swing.JLabel exptypelbl;
    private javax.swing.JLabel feeslbl;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem logoutMenuItem;
    private javax.swing.JLabel logoutlbl;
    private javax.swing.JLabel passchangelbl;
    private javax.swing.JLabel permissionlbl;
    private javax.swing.JLabel profitlbl;
    private javax.swing.JLabel rolelbl;
    private javax.swing.JLabel shiftlbl;
    private javax.swing.JMenuItem studentMenuItem;
    private javax.swing.JLabel studentlbl;
    private javax.swing.JLabel userlbl2;
    private javax.swing.JLabel usernamelbl;
    // End of variables declaration//GEN-END:variables

    private void hideAllButtonsAndMenuItems() {
        studentlbl.setEnabled(false);
        studentMenuItem.setEnabled(false);
        batchlbl.setEnabled(false);
        BatchMenuItem.setEnabled(false);
        expenselbl.setEnabled(false);
        ExpensesMenuItem.setEnabled(false);
        profitlbl.setEnabled(false);
        ProfitMenuItem.setEnabled(false);
        emplbl.setEnabled(false);
        EmployeeMenuItem.setEnabled(false);
        shiftlbl.setEnabled(false);
        ShiftMenuItem.setEnabled(false);
        exptypelbl.setEnabled(false);
        ExpenseTypeMenuItem.setEnabled(false);
        courseassignmentlbl.setEnabled(false);
        CourseAssignmentMenuItem.setEnabled(false);
        courselbl.setEnabled(false);
        CoursesMenuItem.setEnabled(false);
        feeslbl.setEnabled(false);
        FeesMenuItem.setEnabled(false);
        permissionlbl.setEnabled(false);
        PermissionsMenuItem.setEnabled(false);
        rolelbl.setEnabled(false);
        RoleMenuItem.setEnabled(false);
    }

    private void checkPermissions() {
        List<PermissionBean> permissions = new RolePermissionDaoImpl().getAssignedPermissions(LoginFrame.userBean.getRole());
        for (PermissionBean pb : permissions) {
            if (pb.getPermission().equals("student")) {
                studentlbl.setEnabled(true);
                studentMenuItem.setEnabled(true);
            }
            if (pb.getPermission().equals("batch")) {
                batchlbl.setEnabled(true);
                BatchMenuItem.setEnabled(true);
            }
            if (pb.getPermission().equals("expenses")) {
                expenselbl.setEnabled(true);
                ExpensesMenuItem.setEnabled(true);
            }
            if (pb.getPermission().equals("profit")) {
                profitlbl.setEnabled(true);
                ProfitMenuItem.setEnabled(true);
            }
            if (pb.getPermission().equals("employee")) {
                emplbl.setEnabled(true);
                EmployeeMenuItem.setEnabled(true);
            }
            if (pb.getPermission().equals("shift")) {
                shiftlbl.setEnabled(true);
                ShiftMenuItem.setEnabled(true);
            }
            if (pb.getPermission().equals("expenseType")) {
                exptypelbl.setEnabled(true);
                ExpenseTypeMenuItem.setEnabled(true);
            }
            if (pb.getPermission().equals("courseAssignment")) {
                courseassignmentlbl.setEnabled(true);
                CourseAssignmentMenuItem.setEnabled(true);
            }
            if (pb.getPermission().equals("course")) {
                courselbl.setEnabled(true);
                CoursesMenuItem.setEnabled(true);
            }
            if (pb.getPermission().equals("fees")) {
                feeslbl.setEnabled(true);
                FeesMenuItem.setEnabled(true);
            }
            if (pb.getPermission().equals("permissions")) {
                permissionlbl.setEnabled(true);
                PermissionsMenuItem.setEnabled(true);
            }
            if (pb.getPermission().equals("role")) {
                rolelbl.setEnabled(true);
                RoleMenuItem.setEnabled(true);
            }
        }
    }

}