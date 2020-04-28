/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import utility.DateFormatter;
import beans.EmployeeBean;
import beans.PermissionBean;
import beans.RoleBean;
import daoimpl.EmployeeDaoImpl;
import daoimpl.RoleDaoImpl;
import daoimpl.RolePermissionDaoImpl;
import utility.UtilityMethods;

/**
 *
 * @author Bilal Bhatti
 */
public class EmployeeEntryFrame extends javax.swing.JFrame {

    private File imageFile = null;
    private String searchPath = "C:\\";
    private final String employeeImgDir = "C:\\EMPLOYEEIMGDIR\\";

    private Color fg_color_on_focus_lost = new Color(153, 153, 153);
    private Font font_on_focus_lost = new Font("Century Gothic", Font.PLAIN, 18);
    private Color fg_color_on_focus_gain = new Color(120, 120, 120);
    private Font font_on_focus_gain = new Font("Tahoma", Font.PLAIN, 18);

    private Border redLineBroder = BorderFactory.createLineBorder(Color.RED, 1);
    private Border noBorder = null;

    private File prevImageFile;
    private boolean onUpdate;
    private Integer eIdOnUpdate;

    private static final String employeeNameTip = "Employee Name e.g[Ali]";
    private static final String employeeSurnameTip = "Employee Surname";
    private static final String employeeContactTip = "Employee Contact e.g[03001234567]";
    private static final String employeeCnicTip = "Employee CNIC e.g[12345-1234567-8]";
    private static final String employeeAddressTip = "Employee Home Address";
    private static final String employeeSpecializationTip = "Specilizaion Field";
    private static final String employeeExperienceTip = "Experience e.g[2 years]";
    private static final String employeeSalaryTip = "Salary e.g[5000]";
    private static final String employeeDobTip = "01 Jan 1995";
    private static final String userNameTip = "User Name";
    private static final String userNameAlreadyUsedTip = "User Name Already Used";
    private static final String questionAnswerTip = "Answer To the Security Question";
    private static final String userPasswordTip = "***********";

    private static final String employeeNameRequiredTip = "Employee Name Is Required";
    private static final String employeeSurnameRequiredTip = "Employee Surname Is Required";
    private static final String employeeContactRequiredTip = "Employee Contact Is Required";
    private static final String employeeCnicRequiredTip = "Employee CNIC Is Required";
    private static final String employeeAddressRequiredTip = "Employee Address Is Required";
    private static final String employeeSpecializationRequiredTip = "Employee Specilization is Required";
    private static final String employeeExperienceRequiredTip = "Employee Expreience is Required";
    private static final String employeeSalaryRequiredTip = "Employee Salary is Required";
    private static final String employeeDobRequiredTip = "Employee DOB Is Required";
    private static final String userNameRequiredTip = "User Name Is Required";
    private static final String userPasswordRequiredTip = "User Password is Required";
    private static final String questionAnswerRequiredTip = "Answer Of The Question Is Required";
    private static final String searchTip = "Search by keyword";

    private List<RoleBean> employeeRolesList;
    private DefaultTableModel tableModel;

    /**
     * Creates new form EmployeeEntryFrame
     */
    public EmployeeEntryFrame() {
        this.setUndecorated(true);
        initComponents();
        Toolkit t = Toolkit.getDefaultToolkit();
        this.setSize(t.getScreenSize().width, t.getScreenSize().height);
        this.getContentPane().setBackground(Color.white);
        employeetable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        hideAllButtons();
        checkPermissions();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        employeeDobField.requestFocus();

        searchField.requestFocus();
        //       table.getTableHeader().setFont(new Font("Dialog", Font.PLAIN, 18));
        tableModel = (DefaultTableModel) employeetable.getModel();
        updateTable();
        populateEmployeeRolesCombo();
        onUpdate = false;

    }

    public EmployeeEntryFrame(EmployeeBean employee) {
        this.setUndecorated(true);
        initComponents();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        employeeDobField.requestFocus();

        addlbl.setEnabled(false);

        populateEmployeeRolesCombo();
        employee = new EmployeeDaoImpl().getEmployeeById(employee.getEmpId());
        setFields(employee);
        onUpdate = true;
        eIdOnUpdate = employee.getEmpId();
    }

    private void setFields(EmployeeBean employee) {
        employeeNameField.setText(employee.getEmpName());
        employeeSurnameField.setText(employee.getEmpSurname());
        employeeContactField.setText(employee.getContact());
        employeeCnicField.setText(employee.getEmpNic());
        employeeAddressField.setText(employee.getAddress());

        employeeSpecilizationField.setText(employee.getSpecialization());
        employeeExperienceField.setText(employee.getExperience());
        employeeDobField.setDate(DateFormatter.parseDate(employee.getDob()));

        RoleBean role = employee.getRole();

        System.out.println("Role: " + role.getRole());
        employeeTypeCombo.setSelectedItem(role.getRole());
        if (role.getRole().equalsIgnoreCase("user")) {
            userNameField.setText(employee.getUserName());
            userPasswordField.setText(employee.getPassword());
            questionField.setSelectedItem(employee.getqId());
            answerField.setText(employee.getAnswer());
        } else {
            userNameField.setText(userNameTip);
            userPasswordField.setText(userPasswordTip);
            questionField.setSelectedIndex(0);
            answerField.setText(questionAnswerTip);
        }

        salaryTypeCombo.setSelectedItem(employee.getSalType());
        employeeSalaryField.setText(employee.getSalary() + "");

        boolean isMale = employee.getGender().equalsIgnoreCase("Male");
        if (isMale) {
            maleRadio.setSelected(true);
        } else {
            femaleRadio.setSelected(true);
        }
        /*
        ImagesHandler handler = new ImagesHandler(employeeImgDir);
        ImageIcon img = handler.loagImage(employee.getPicPath());
        profileIcon.setIcon(img);
        imageFile = new File(employee.getPicPath());
        prevImageFile = new File(employee.getPicPath());
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        tablePanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        tableScorllPanel = new javax.swing.JScrollPane();
        employeetable = new javax.swing.JTable();
        searchLabel = new javax.swing.JLabel();
        deletelbl = new javax.swing.JLabel();
        addlbl = new javax.swing.JLabel();
        updatelbl = new javax.swing.JLabel();
        resetlbl = new javax.swing.JLabel();
        userInfoPanel = new javax.swing.JPanel();
        answerField = new javax.swing.JTextField();
        questionField = new javax.swing.JComboBox<>();
        userPasswordField = new javax.swing.JPasswordField();
        userNameField = new javax.swing.JTextField();
        empUsernameLabel = new javax.swing.JLabel();
        empPassLabel = new javax.swing.JLabel();
        empSecurityLabel = new javax.swing.JLabel();
        empAnswerLabel = new javax.swing.JLabel();
        salaryPanel = new javax.swing.JPanel();
        employeeSalaryField = new javax.swing.JFormattedTextField();
        salaryTypeCombo = new javax.swing.JComboBox<>();
        empSalaryLabel = new javax.swing.JLabel();
        empAmountLabel = new javax.swing.JLabel();
        employeeInfoPanel = new javax.swing.JPanel();
        employeeTypeCombo = new javax.swing.JComboBox<>();
        employeeExperienceField = new javax.swing.JTextField();
        employeeSpecilizationField = new javax.swing.JTextField();
        femaleRadio = new javax.swing.JRadioButton();
        maleRadio = new javax.swing.JRadioButton();
        employeeDobField = new com.toedter.calendar.JDateChooser();
        employeeAddressField = new javax.swing.JTextField();
        employeeCnicField = new javax.swing.JFormattedTextField();
        employeeContactField = new javax.swing.JFormattedTextField();
        employeeSurnameField = new javax.swing.JTextField();
        employeeNameField = new javax.swing.JTextField();
        empNameLabel = new javax.swing.JLabel();
        empSurnameLabel = new javax.swing.JLabel();
        empPhoneLabel = new javax.swing.JLabel();
        empCnicLabel = new javax.swing.JLabel();
        empAddressLabel = new javax.swing.JLabel();
        empFieldLabel = new javax.swing.JLabel();
        empExpLabel = new javax.swing.JLabel();
        empDobLabel = new javax.swing.JLabel();
        empRoleLabel = new javax.swing.JLabel();
        empGenderLabel = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        crossBtn = new javax.swing.JLabel();
        empHeader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(1365, 715));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchField.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        searchField.setForeground(new java.awt.Color(153, 153, 153));
        searchField.setToolTipText("Search Field");
        searchField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFieldFocusLost(evt);
            }
        });
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        tablePanel.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 180, 30));

        employeetable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "E_ID", "Roll_ID", "Employee Name", "Surname", "CNIC", "Salary Type", "Salary", "Contact", "Gender", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeetable.setToolTipText("Employee Record Table");
        employeetable.setRowHeight(20);
        employeetable.setRowMargin(2);
        employeetable.setSelectionBackground(new java.awt.Color(0, 102, 0));
        employeetable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        employeetable.getTableHeader().setResizingAllowed(false);
        employeetable.getTableHeader().setReorderingAllowed(false);
        employeetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                employeetableMouseReleased(evt);
            }
        });
        tableScorllPanel.setViewportView(employeetable);

        tablePanel.add(tableScorllPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 680, 430));

        searchLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        searchLabel.setText("Search");
        tablePanel.add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 60, 30));

        deletelbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deletebtn.png"))); // NOI18N
        deletelbl.setToolTipText("Delete Button");
        deletelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletelblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletelblMouseEntered(evt);
            }
        });
        tablePanel.add(deletelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, -1, 50));

        addlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addbtn.png"))); // NOI18N
        addlbl.setToolTipText("Add Button");
        addlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addlblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addlblMouseEntered(evt);
            }
        });
        tablePanel.add(addlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        updatelbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updatebtn.png"))); // NOI18N
        updatelbl.setToolTipText("Update Button");
        updatelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatelblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatelblMouseEntered(evt);
            }
        });
        tablePanel.add(updatelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 170, 50));

        resetlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/resetbtn.png"))); // NOI18N
        resetlbl.setToolTipText("Reset Button");
        resetlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetlblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetlblMouseEntered(evt);
            }
        });
        tablePanel.add(resetlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, -1, -1));

        getContentPane().add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 710, 650));

        userInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        userInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "User Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N
        userInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        answerField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        answerField.setText("Answer To the Security Question");
        answerField.setToolTipText("Security Question Answer");
        answerField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        answerField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answerFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answerFieldFocusLost(evt);
            }
        });
        answerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerFieldActionPerformed(evt);
            }
        });
        userInfoPanel.add(answerField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 190, 40));

        questionField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        questionField.setMaximumRowCount(5);
        questionField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Security Question", "Nick Name?", "Best Teacher Name?", "Best Friend Name?", "Favourite Subject?", "Favourite Game?", " " }));
        questionField.setToolTipText("Security Questions");
        questionField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        questionField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                questionFieldFocusGained(evt);
            }
        });
        userInfoPanel.add(questionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 190, 40));

        userPasswordField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        userPasswordField.setText("jPasswordField1");
        userPasswordField.setToolTipText("User Password");
        userPasswordField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        userPasswordField.setCaretPosition(3);
        userPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userPasswordFieldFocusLost(evt);
            }
        });
        userInfoPanel.add(userPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 40));

        userNameField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        userNameField.setText("User Name");
        userNameField.setToolTipText("User Name");
        userNameField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        userNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userNameFieldFocusLost(evt);
            }
        });
        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });
        userInfoPanel.add(userNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 190, 40));

        empUsernameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empUsernameLabel.setText("Username");
        userInfoPanel.add(empUsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 40));

        empPassLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empPassLabel.setText("Password");
        userInfoPanel.add(empPassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 90, 40));

        empSecurityLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empSecurityLabel.setText("Security");
        userInfoPanel.add(empSecurityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 70, 40));

        empAnswerLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empAnswerLabel.setText("Answer");
        userInfoPanel.add(empAnswerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 70, 40));

        getContentPane().add(userInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 310, 460));

        salaryPanel.setBackground(new java.awt.Color(255, 255, 255));
        salaryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Salary Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N
        salaryPanel.setAutoscrolls(true);
        salaryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeSalaryField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employeeSalaryField.setText("Salary e.g[5000]");
        employeeSalaryField.setToolTipText("Employee Salary");
        employeeSalaryField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        employeeSalaryField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeSalaryFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                employeeSalaryFieldFocusLost(evt);
            }
        });
        employeeSalaryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeSalaryFieldActionPerformed(evt);
            }
        });
        salaryPanel.add(employeeSalaryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 200, 40));

        salaryTypeCombo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        salaryTypeCombo.setMaximumRowCount(2);
        salaryTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Salary Type", "Fixed", "Percentage" }));
        salaryTypeCombo.setToolTipText("Salary Type of Employee");
        salaryTypeCombo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        salaryTypeCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                salaryTypeComboFocusGained(evt);
            }
        });
        salaryPanel.add(salaryTypeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 200, 40));

        empSalaryLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empSalaryLabel.setText("Salary ");
        salaryPanel.add(empSalaryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 40));

        empAmountLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empAmountLabel.setText("Amount");
        salaryPanel.add(empAmountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 70, 40));

        getContentPane().add(salaryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 310, 190));

        employeeInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        employeeInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Personal Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N
        employeeInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeTypeCombo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        employeeTypeCombo.setMaximumRowCount(2);
        employeeTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Role", "Teacher", "User", "Admin", "Moderator", "Operator", "Security Guard", "Peon" }));
        employeeTypeCombo.setToolTipText("Employee Role");
        employeeTypeCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeTypeComboFocusGained(evt);
            }
        });
        employeeTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeTypeComboActionPerformed(evt);
            }
        });
        employeeInfoPanel.add(employeeTypeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 220, 40));

        employeeExperienceField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        employeeExperienceField.setText("Experience e.g[2 years]");
        employeeExperienceField.setToolTipText("Experience of Employee");
        employeeExperienceField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employeeExperienceField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeExperienceFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                employeeExperienceFieldFocusLost(evt);
            }
        });
        employeeExperienceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeExperienceFieldActionPerformed(evt);
            }
        });
        employeeInfoPanel.add(employeeExperienceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 220, 40));

        employeeSpecilizationField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        employeeSpecilizationField.setText("Specilizaion Field");
        employeeSpecilizationField.setToolTipText("Employee Specilization Field");
        employeeSpecilizationField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employeeSpecilizationField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeSpecilizationFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                employeeSpecilizationFieldFocusLost(evt);
            }
        });
        employeeSpecilizationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeSpecilizationFieldActionPerformed(evt);
            }
        });
        employeeInfoPanel.add(employeeSpecilizationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 220, 40));

        femaleRadio.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        femaleRadio.setText("Female");
        femaleRadio.setToolTipText("Gender");
        femaleRadio.setOpaque(false);
        femaleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioActionPerformed(evt);
            }
        });
        employeeInfoPanel.add(femaleRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 590, -1, -1));

        maleRadio.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        maleRadio.setSelected(true);
        maleRadio.setText("Male");
        maleRadio.setToolTipText("Gender");
        maleRadio.setOpaque(false);
        employeeInfoPanel.add(maleRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, -1, -1));

        employeeDobField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employeeDobField.setToolTipText("Employee Date of Birth");
        employeeDobField.setDate(new java.util.Date(85,1,1));
        employeeDobField.setDateFormatString("dd MMMM yyyy");
        employeeDobField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        employeeInfoPanel.add(employeeDobField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 220, 40));

        employeeAddressField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        employeeAddressField.setText("Employee Home Address");
        employeeAddressField.setToolTipText("Employee Address");
        employeeAddressField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employeeAddressField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeAddressFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                employeeAddressFieldFocusLost(evt);
            }
        });
        employeeAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeAddressFieldActionPerformed(evt);
            }
        });
        employeeInfoPanel.add(employeeAddressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 220, 40));

        employeeCnicField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        try {
            employeeCnicField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        employeeCnicField.setToolTipText("Employee CNIC Number");
        employeeCnicField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        employeeCnicField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeCnicFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                employeeCnicFieldFocusLost(evt);
            }
        });
        employeeInfoPanel.add(employeeCnicField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 220, 40));

        employeeContactField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        try {
            employeeContactField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        employeeContactField.setToolTipText("Employee Contact Number");
        employeeContactField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        employeeContactField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeContactFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                employeeContactFieldFocusLost(evt);
            }
        });
        employeeInfoPanel.add(employeeContactField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 220, 40));

        employeeSurnameField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        employeeSurnameField.setText("Employee Surname");
        employeeSurnameField.setToolTipText("Employee Surname");
        employeeSurnameField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employeeSurnameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeSurnameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                employeeSurnameFieldFocusLost(evt);
            }
        });
        employeeSurnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeSurnameFieldActionPerformed(evt);
            }
        });
        employeeInfoPanel.add(employeeSurnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 220, 40));

        employeeNameField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        employeeNameField.setText("Employee Name e.g[Ali]");
        employeeNameField.setToolTipText("Employee Name e.g[Ali]");
        employeeNameField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employeeNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                employeeNameFieldFocusLost(evt);
            }
        });
        employeeNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNameFieldActionPerformed(evt);
            }
        });
        employeeInfoPanel.add(employeeNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 220, 40));

        empNameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empNameLabel.setText("Name");
        employeeInfoPanel.add(empNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, 40));

        empSurnameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empSurnameLabel.setText("Surname");
        employeeInfoPanel.add(empSurnameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 80, 40));

        empPhoneLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empPhoneLabel.setText("Phone");
        employeeInfoPanel.add(empPhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 70, 40));

        empCnicLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empCnicLabel.setText("CNIC");
        employeeInfoPanel.add(empCnicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 70, 40));

        empAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empAddressLabel.setText("Address");
        employeeInfoPanel.add(empAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 70, 40));

        empFieldLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empFieldLabel.setText("Field");
        employeeInfoPanel.add(empFieldLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 70, 40));

        empExpLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empExpLabel.setText("Exp");
        employeeInfoPanel.add(empExpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 70, 40));

        empDobLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empDobLabel.setText("DOB");
        employeeInfoPanel.add(empDobLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 70, 40));

        empRoleLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empRoleLabel.setText("Role");
        employeeInfoPanel.add(empRoleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 70, 40));

        empGenderLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        empGenderLabel.setText("Gender");
        employeeInfoPanel.add(empGenderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 70, 30));

        getContentPane().add(employeeInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 320, 650));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        crossBtn.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        crossBtn.setForeground(new java.awt.Color(255, 255, 255));
        crossBtn.setText("X");
        crossBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crossBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crossBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crossBtnMouseEntered(evt);
            }
        });
        getContentPane().add(crossBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 20, -1, 30));

        empHeader.setBackground(new java.awt.Color(0, 102, 0));
        empHeader.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        empHeader.setForeground(new java.awt.Color(255, 255, 255));
        empHeader.setText("                                                                                           EMPLOYEE");
        empHeader.setOpaque(true);
        getContentPane().add(empHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 1380, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateTable() {
        tableModel.setNumRows(0);
        employeetable.getColumnModel().getColumn(0).setWidth(0);
        employeetable.getColumnModel().getColumn(0).setMinWidth(0);
        employeetable.getColumnModel().getColumn(0).setMaxWidth(0);

        employeetable.getColumnModel().getColumn(1).setWidth(0);
        employeetable.getColumnModel().getColumn(1).setMinWidth(0);
        employeetable.getColumnModel().getColumn(1).setMaxWidth(0);

        ResultSet rs = new EmployeeDaoImpl().getAllEmployees();

        try {
            EmployeeBean employee;
            while (rs.next()) {
                employee = new EmployeeBean();

                employee.setEmpId(rs.getInt("emp_id"));
                employee.setEmpName(rs.getString("emp_name"));
                employee.setEmpSurname(rs.getString("surname"));
                employee.setEmpNic(rs.getString("cnic"));
                employee.setSalType(rs.getString("sal_type"));
                employee.setSalary(rs.getDouble("sal_value"));
                employee.setContact(rs.getString("contact"));
                employee.setDob(rs.getString("dob"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setSpecialization(rs.getString("specialization"));
                employee.setExperience(rs.getString("experience"));
                employee.setHiredate(rs.getString("hire_date"));
                Integer rollId = rs.getInt("role_id");
                RoleBean role = new RoleDaoImpl().getRoleById(rollId);
                employee.setRole(role);

                tableModel.addRow(new Object[]{
                    employee.getEmpId(),
                    employee.getRole().getRoleId(),
                    employee.getEmpName(),
                    employee.getEmpSurname(),
                    employee.getEmpNic(),
                    employee.getSalType(),
                    employee.getSalary(),
                    employee.getContact(),
                    employee.getGender(),
                    employee.getRole().getRole(),});
            }
        } catch (SQLException sqle) {
            System.out.println("Exception is Employee Record Selection Frame in updateTable() Method...");
            System.out.println(sqle.getMessage());
        }
    }

    private boolean checkForUniqueName() {
        boolean allowed = true;

        //If the selected item is not user then.
        //He is allowed to move forword.
        if (!employeeTypeCombo.getSelectedItem().toString().equalsIgnoreCase("user")) {
            return true;
        }

        ResultSet rs = new EmployeeDaoImpl().getAllEmployees();
        String userName = userNameField.getText();
        try {
            while (rs.next()) {
                String alreadyUsedName = rs.getString("user_name");
                if (userName.equals(alreadyUsedName)) {
                    userNameField.setBorder(redLineBroder);
                    userNameField.setText(userNameAlreadyUsedTip);
                    userNameField.setForeground(Color.RED);
                    return false;
                }
            }
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }

        return allowed;
    }

    private void employeeNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeNameFieldActionPerformed

    private void employeeSurnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeSurnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeSurnameFieldActionPerformed

    private void employeeAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeAddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeAddressFieldActionPerformed

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed

    private void answerFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answerFieldActionPerformed

    private void employeeSpecilizationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeSpecilizationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeSpecilizationFieldActionPerformed

    private void employeeTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeTypeComboActionPerformed
        // TODO add your handling code here:
        Object item = employeeTypeCombo.getSelectedItem();
        if (item != null && item.toString().equals("User")) {
            setUserFieldsEnabled(true);
        } else {
            setUserFieldsEnabled(false);
        }
    }//GEN-LAST:event_employeeTypeComboActionPerformed

    private void crossBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossBtnMouseEntered
        // TODO add your handling code here:
        crossBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_crossBtnMouseEntered

    private void addlblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addlblMouseEntered
        // TODO add your handling code here:
        addlbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_addlblMouseEntered

    private void crossBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossBtnMouseClicked
        // TODO add your handling code here:
//        new MainFrame().setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_crossBtnMouseClicked

    private void employeeSalaryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeSalaryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeSalaryFieldActionPerformed

    private void addlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addlblMouseClicked
        // TODO add your handling code here:
        if (employeetable.getSelectedRow() == -1) {
            employeeDobField.requestFocus();
            if (validateForm() && checkForUniqueName()) {
                EmployeeBean employee = new EmployeeBean();
                employee.setEmpName(employeeNameField.getText());
                employee.setEmpSurname(employeeSurnameField.getText());
                employee.setContact(employeeContactField.getText());
                employee.setEmpNic(employeeCnicField.getText());
                employee.setAddress(employeeAddressField.getText());
                employee.setSpecialization(employeeSpecilizationField.getText());
                String expr = employeeExperienceField.getText();
                employee.setExperience((expr.equals(employeeExperienceTip)) ? "" : expr);
                employee.setHiredate(DateFormatter.formatDate(new Date()));
                employee.setDob(DateFormatter.formatDate(employeeDobField.getDate()));
                String gender = (maleRadio.isSelected()) ? "Male" : "Female";
                employee.setGender(gender);

                //Critical Section...
                int selectedIndx = employeeTypeCombo.getSelectedIndex();
                RoleBean roll = employeeRolesList.get(selectedIndx - 1);

                employee.setRole(roll);
                //Cretical Section....

                employee.setSalType(salaryTypeCombo.getSelectedItem().toString());
                employee.setSalary(Double.valueOf(employeeSalaryField.getText()));

                if (employeeTypeCombo.getSelectedItem().toString().equalsIgnoreCase("User")) {
                    employee.setUserName(userNameField.getText());
                    String password = userPasswordField.getText();
                    employee.setPassword(password);
                    employee.setqId(questionField.getSelectedItem().toString());
                    employee.setAnswer(answerField.getText());
                } else {
                    employee.setUserName("");
                    employee.setPassword("");
                    employee.setqId("");
                    employee.setAnswer("");
                }

                /*
                ImagesHandler imgHandler = new ImagesHandler(this.employeeImgDir);
                //Real Path where the image is currently saved
                String realImagePath = imgHandler.addImage(imageFile.getAbsolutePath(), employee);
                employee.setPicPath(realImagePath);
                 */
                employee.setPicPath("");

                employee.setCreatedBy(41);
                employee.setCreatedDate(new Date() + "");

                // How to manage created by and modified by
                int what = new EmployeeDaoImpl().addEmployee(employee);
                if (what == 1) {
                    updateTable();
                    resetFields();
                }
            }
        } else {
//            new MessageForm("Error", "Record is duplicate", "error.png").setVisible(true);
        }
    }//GEN-LAST:event_addlblMouseClicked

    private void resetFields() {
        employeeNameField.setText(employeeNameTip);
        employeeSurnameField.setText(employeeSurnameTip);
        employeeContactField.setText("");
        employeeCnicField.setText("");
        employeeSpecilizationField.setText(employeeSpecializationTip);
        employeeExperienceField.setText(employeeExperienceTip);
        employeeAddressField.setText(employeeAddressTip);
        employeeSalaryField.setText(employeeSalaryTip);
        salaryTypeCombo.setSelectedIndex(0);
        employeeTypeCombo.setSelectedIndex(0);

        userNameField.setText(userNameTip);
        userPasswordField.setText(userPasswordTip);
        questionField.setSelectedIndex(0);
        answerField.setText(questionAnswerTip);
        employeetable.clearSelection();

    }

    private void setForegroundAndFontOnLost(JTextField textField) {
        textField.setForeground(fg_color_on_focus_lost);
        textField.setFont(font_on_focus_lost);
    }

    private void setForegroundAndFontOnLost(JFormattedTextField textField) {
        textField.setForeground(fg_color_on_focus_lost);
        textField.setFont(font_on_focus_lost);
    }

    private void setForegroundAndFontOnGain(JTextField textField) {
        textField.setForeground(fg_color_on_focus_gain);
        textField.setFont(font_on_focus_gain);
    }

    private void setForegroundAndFontOnGain(JFormattedTextField textField) {
        textField.setForeground(fg_color_on_focus_gain);
        textField.setFont(font_on_focus_gain);
    }

    private void setBorderAndForegroundOnMissingValue(JTextField textField) {
        textField.setBorder(redLineBroder);
        textField.setForeground(Color.RED);
    }

    private void setBorderAndForegroundOnMissingValue(JFormattedTextField textField) {
        textField.setBorder(redLineBroder);
        textField.setForeground(Color.RED);
    }


    private void employeeNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeNameFieldFocusGained
        // TODO add your handling code here:
        if (employeeNameField.getText().equals(employeeNameTip) || employeeNameField.getText().equals(employeeNameRequiredTip)) {
            employeeNameField.setText("");
        }
        setForegroundAndFontOnGain(employeeNameField);


    }//GEN-LAST:event_employeeNameFieldFocusGained

    private void employeeNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeNameFieldFocusLost
        // TODO add your handling code here:
        if (employeeNameField.getText().isEmpty()) {
            setForegroundAndFontOnLost(employeeNameField);
            employeeNameField.setText(employeeNameTip);
        }
    }//GEN-LAST:event_employeeNameFieldFocusLost

    private void employeeSurnameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeSurnameFieldFocusGained
        // TODO add your handling code here:
        if (employeeSurnameField.getText().equals(employeeSurnameTip) || employeeSurnameField.getText().equals(employeeSurnameRequiredTip)) {
            employeeSurnameField.setText("");
        }
        setForegroundAndFontOnGain(employeeSurnameField);


    }//GEN-LAST:event_employeeSurnameFieldFocusGained

    private void employeeSurnameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeSurnameFieldFocusLost
        // TODO add your handling code here:
        if (employeeSurnameField.getText().isEmpty()) {
            setForegroundAndFontOnLost(employeeSurnameField);
            employeeSurnameField.setText(employeeSurnameTip);
        }

    }//GEN-LAST:event_employeeSurnameFieldFocusLost

    private void employeeContactFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeContactFieldFocusGained
        // TODO add your handling code here:
        if (employeeContactField.getText().equals(employeeContactTip) || employeeContactField.getText().equals(employeeContactRequiredTip)) {
            employeeContactField.setText("");
        }
        setForegroundAndFontOnGain(employeeContactField);


    }//GEN-LAST:event_employeeContactFieldFocusGained

    private void employeeContactFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeContactFieldFocusLost
        // TODO add your handling code here:
        if (employeeContactField.getText().isEmpty()) {
            setForegroundAndFontOnLost(employeeContactField);
            employeeContactField.setText(employeeContactTip);
        }
    }//GEN-LAST:event_employeeContactFieldFocusLost

    private void employeeCnicFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeCnicFieldFocusGained
        // TODO add your handling code here:
        if (employeeCnicField.getText().equals(employeeCnicTip) || employeeCnicField.getText().equals(employeeCnicRequiredTip)) {
            employeeCnicField.setText("");
        }
        setForegroundAndFontOnGain(employeeCnicField);


    }//GEN-LAST:event_employeeCnicFieldFocusGained

    private void employeeCnicFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeCnicFieldFocusLost
        // TODO add your handling code here:
        if (employeeCnicField.getText().isEmpty()) {
            setForegroundAndFontOnLost(employeeCnicField);
            employeeCnicField.setText(employeeCnicTip);
        }

    }//GEN-LAST:event_employeeCnicFieldFocusLost

    private void employeeAddressFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeAddressFieldFocusGained
        // TODO add your handling code here:
        if (employeeAddressField.getText().equals(employeeAddressTip) || employeeAddressField.getText().equals(employeeAddressRequiredTip)) {
            employeeAddressField.setText("");
        }
        setForegroundAndFontOnGain(employeeAddressField);


    }//GEN-LAST:event_employeeAddressFieldFocusGained

    private void employeeAddressFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeAddressFieldFocusLost
        // TODO add your handling code here:
        if (employeeAddressField.getText().isEmpty()) {
            setForegroundAndFontOnLost(employeeAddressField);
            employeeAddressField.setText(employeeAddressTip);
        }

    }//GEN-LAST:event_employeeAddressFieldFocusLost

    private void employeeSpecilizationFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeSpecilizationFieldFocusGained
        // TODO add your handling code here:
        if (employeeSpecilizationField.getText().equals(employeeSpecializationTip) || employeeSpecilizationField.getText().equals(employeeSpecializationRequiredTip)) {
            employeeSpecilizationField.setText("");
        }
        setForegroundAndFontOnGain(employeeSpecilizationField);


    }//GEN-LAST:event_employeeSpecilizationFieldFocusGained

    private void employeeSpecilizationFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeSpecilizationFieldFocusLost
        // TODO add your handling code here:
        if (employeeSpecilizationField.getText().isEmpty()) {
            setForegroundAndFontOnLost(employeeSpecilizationField);
            employeeSpecilizationField.setText(employeeSpecializationTip);
        }

    }//GEN-LAST:event_employeeSpecilizationFieldFocusLost

    private void employeeSalaryFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeSalaryFieldFocusGained
        // TODO add your handling code here:
        if (employeeSalaryField.getText().equals(employeeSalaryTip) || employeeSalaryField.getText().equals(employeeSalaryRequiredTip)) {
            employeeSalaryField.setText("");
        }
        setForegroundAndFontOnGain(employeeSalaryField);


    }//GEN-LAST:event_employeeSalaryFieldFocusGained

    private void employeeSalaryFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeSalaryFieldFocusLost
        // TODO add your handling code here:
        if (employeeSalaryField.getText().isEmpty()) {
            setForegroundAndFontOnLost(employeeSalaryField);
            employeeSalaryField.setText(employeeSalaryTip);
        }

    }//GEN-LAST:event_employeeSalaryFieldFocusLost

    private void userNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFieldFocusGained
        // TODO add your handling code here:
        if (userNameField.getText().equals(userNameTip) || userNameField.getText().equals(userNameRequiredTip) || userNameField.getText().equals(userNameAlreadyUsedTip)) {
            userNameField.setText("");
        }
        setForegroundAndFontOnGain(userNameField);


    }//GEN-LAST:event_userNameFieldFocusGained

    private void userNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFieldFocusLost
        // TODO add your handling code here:
        if (userNameField.getText().isEmpty()) {
            setForegroundAndFontOnLost(userNameField);
            userNameField.setText(userNameTip);
        }

    }//GEN-LAST:event_userNameFieldFocusLost

    private void userPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPasswordFieldFocusGained
        // TODO add your handling code here:
        if (userPasswordField.getText().equals(userPasswordTip) || userPasswordField.getText().equals(userPasswordRequiredTip)) {
            userPasswordField.setText("");
        }
        setForegroundAndFontOnGain(userPasswordField);


    }//GEN-LAST:event_userPasswordFieldFocusGained

    private void userPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPasswordFieldFocusLost
        // TODO add your handling code here:
        if (userPasswordField.getText().isEmpty()) {
            setForegroundAndFontOnLost(userPasswordField);
            userPasswordField.setText(userPasswordTip);
        }

    }//GEN-LAST:event_userPasswordFieldFocusLost

    private void answerFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerFieldFocusGained
        // TODO add your handling code here:
        if (answerField.getText().equals(questionAnswerTip) || answerField.getText().equals(questionAnswerRequiredTip)) {
            answerField.setText("");
        }
        setForegroundAndFontOnGain(answerField);


    }//GEN-LAST:event_answerFieldFocusGained

    private void answerFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerFieldFocusLost
        // TODO add your handling code here:
        if (answerField.getText().isEmpty()) {
            setForegroundAndFontOnLost(answerField);
            answerField.setText(questionAnswerTip);
        }
    }//GEN-LAST:event_answerFieldFocusLost

    private void employeeExperienceFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeExperienceFieldFocusGained
        // TODO add your handling code here:
        if (!employeeExperienceField.getText().isEmpty()) {
            employeeExperienceField.setText("");
        }
        setForegroundAndFontOnGain(employeeExperienceField);


    }//GEN-LAST:event_employeeExperienceFieldFocusGained

    private void employeeExperienceFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeExperienceFieldFocusLost
        // TODO add your handling code here:
        if (employeeExperienceField.getText().isEmpty()) {
            setForegroundAndFontOnLost(employeeExperienceField);
            employeeExperienceField.setText(employeeExperienceTip);
        }

    }//GEN-LAST:event_employeeExperienceFieldFocusLost

    private void employeeExperienceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeExperienceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeExperienceFieldActionPerformed

    private void femaleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleRadioActionPerformed

    private void updateEmployeeRecord() {
        employeeDobField.requestFocus();
        int selectedRow = employeetable.getSelectedRow();
        if (selectedRow >= 0) {
            if (validateForm() && checkForUniqueName()) {
                EmployeeBean employee = new EmployeeBean();

                //employee.setEmpId(eIdOnUpdate);
                employee.setEmpId(new Integer(employeetable.getValueAt(selectedRow, 0).toString()));
                employee.setEmpName(employeeNameField.getText());
                employee.setEmpSurname(employeeSurnameField.getText());
                employee.setContact(employeeContactField.getText());
                employee.setEmpNic(employeeCnicField.getText());
                employee.setAddress(employeeAddressField.getText());
                employee.setSpecialization(employeeSpecilizationField.getText());
                String expr = employeeExperienceField.getText();
                employee.setExperience((expr.equals(employeeExperienceTip)) ? "" : expr);
                employee.setHiredate(DateFormatter.formatDate(new Date()));
                employee.setDob(DateFormatter.formatDate(employeeDobField.getDate()));
                String gender = (maleRadio.isSelected()) ? "Male" : "Female";
                employee.setGender(gender);

                //Critical Section...
                int selectedIndx = employeeTypeCombo.getSelectedIndex();
                RoleBean roll = employeeRolesList.get(selectedIndx - 1);

                employee.setRole(roll);
                //Cretical Section....

                employee.setSalType(salaryTypeCombo.getSelectedItem().toString());
                employee.setSalary(Double.valueOf(employeeSalaryField.getText()));

                if (employeeTypeCombo.getSelectedItem().toString().equalsIgnoreCase("User")) {
                    employee.setUserName(userNameField.getText());
                    String password = userPasswordField.getText();

                    employee.setPassword(password);

                    employee.setqId(questionField.getSelectedItem().toString());
                    employee.setAnswer(answerField.getText());
                } else {
                    employee.setUserName("");
                    employee.setPassword("");
                    employee.setqId("");
                    employee.setAnswer("");
                }
                /*            
            ImagesHandler imgHandler = new ImagesHandler(this.employeeImgDir);
            //Delete the previous image file...
            //If User does not change the picture...
            if(!prevImageFile.getAbsolutePath().equals(imageFile.getAbsolutePath())){
                imgHandler.deleteImage(prevImageFile.getAbsolutePath());
            }
            //Real Path where the image is currently saved
            String realImagePath = imgHandler.addImage(imageFile.getAbsolutePath(), employee);
            employee.setPicPath(realImagePath);
                 */
                employee.setPicPath("");
                employee.setModifiedBy(41);
                employee.setModifiedDate(new Date() + "");

                // How to manage created by and modified by
                int what = new EmployeeDaoImpl().updateEmployee(employee);
                if (what == 1) {
//                    new MessageForm("Success", "Employee updated", "success.png").setVisible(true);
//                    updateTable();
//                    resetFields();
                }
            }
        } else {
//            new MessageForm("Error", "No record selected", "error.png").setVisible(true);
        }
    }

    private void salaryTypeComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salaryTypeComboFocusGained
        // TODO add your handling code here:
        salaryTypeCombo.setBorder(null);
        salaryTypeCombo.setForeground(Color.BLACK);
    }//GEN-LAST:event_salaryTypeComboFocusGained

    private void questionFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_questionFieldFocusGained
        // TODO add your handling code here:
        questionField.setBackground(null);
        questionField.setForeground(Color.BLACK);

    }//GEN-LAST:event_questionFieldFocusGained

    private void employeeTypeComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeTypeComboFocusGained
        // TODO add your handling code here:
        employeeTypeCombo.setBorder(null);
        employeeTypeCombo.setForeground(Color.BLACK);
    }//GEN-LAST:event_employeeTypeComboFocusGained

    private void deletelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletelblMouseClicked
        // TODO add your handling code here:
        int selectedRow = employeetable.getSelectedRow();
        if (selectedRow >= 0) {
            EmployeeBean employee = new EmployeeBean();
            employee.setEmpId(new Integer(employeetable.getValueAt(selectedRow, 0).toString()));

            employee.setModifiedBy(41);
            employee.setModifiedDate(new Date() + "");

            int status = new EmployeeDaoImpl().deleteEmployee(employee);
            if (status == 1) {
//                new MessageForm("Success", "Employee deleted", "success.png").setVisible(true);
//                updateTable();
//                resetFields();
            }
        } else {
//            new MessageForm("Error", "No record selected", "error.png").setVisible(true);
        }
    }//GEN-LAST:event_deletelblMouseClicked

    private void updatelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatelblMouseClicked
        // TODO add your handling code here:
        updateEmployeeRecord();

    }//GEN-LAST:event_updatelblMouseClicked

    private void resetlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetlblMouseClicked
        // TODO add your handling code here:
        resetFields();
    }//GEN-LAST:event_resetlblMouseClicked

    private void deletelblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletelblMouseEntered
        // TODO add your handling code here:
        deletelbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_deletelblMouseEntered

    private void updatelblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatelblMouseEntered
        // TODO add your handling code here:
        updatelbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_updatelblMouseEntered

    private void resetlblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetlblMouseEntered
        // TODO add your handling code here:
        resetlbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_resetlblMouseEntered

    private void employeetableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeetableMouseReleased
        // TODO add your handling code here:
        int selectedRow = employeetable.getSelectedRow();
        if (selectedRow >= 0) {
            Integer s_id = new Integer(employeetable.getValueAt(selectedRow, 0).toString());
            EmployeeBean employee = new EmployeeDaoImpl().getEmployeeById(s_id);
            setFields(employee);
        }
    }//GEN-LAST:event_employeetableMouseReleased

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
        UtilityMethods.searchDataFromTable(employeetable, searchField);
    }//GEN-LAST:event_searchFieldKeyReleased

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusLost
        // TODO add your handling code here:
        if (searchField.getText().isEmpty()) {
            setForegroundAndFontOnLost(searchField);
            searchField.setText(searchTip);
        }
    }//GEN-LAST:event_searchFieldFocusLost

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        // TODO add your handling code here:
        if (searchField.getText().equals(searchTip)) {
            searchField.setText("");
        }

        setForegroundAndFontOnGain(searchField);


    }//GEN-LAST:event_searchFieldFocusGained

    private void openRecordSelectionFrame() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                EmployeeRecordSelectionFrame frame = new EmployeeRecordSelectionFrame();
//                frame.setVisible(true);
            }
        });

        this.dispose();

    }

    private boolean validateForm() {

        boolean ok = true;

        if (employeeNameField.getText().equals(employeeNameTip) || employeeNameField.getText().equals(employeeNameRequiredTip)) {
            employeeNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            employeeNameField.setForeground(Color.RED);
            employeeNameField.setText(employeeNameRequiredTip);
            employeeDobField.requestFocus();
            ok = false;
        }
        if (employeeSurnameField.getText().equals(employeeSurnameTip) || employeeSurnameField.getText().equals(employeeSurnameRequiredTip)) {
            employeeSurnameField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            employeeSurnameField.setForeground(Color.RED);
            employeeSurnameField.setText(employeeSurnameRequiredTip);
            employeeDobField.requestFocus();
            ok = false;
        }
        if (employeeContactField.getText().equals(employeeContactTip) || employeeContactField.getText().equals(employeeContactRequiredTip) || employeeContactField.getText().equals("    -       ")) {
            employeeContactField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            employeeContactField.setForeground(Color.RED);
            employeeContactField.setText(employeeContactRequiredTip);
            employeeDobField.requestFocus();
            ok = false;
        }
        if (employeeCnicField.getText().equals(employeeCnicTip) || employeeCnicField.getText().equals(employeeCnicRequiredTip) || employeeCnicField.getText().equals("     -       - ")) {
            employeeCnicField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            employeeCnicField.setForeground(Color.RED);
            employeeCnicField.setText(employeeCnicRequiredTip);
            employeeDobField.requestFocus();
            ok = false;
        }
        if (employeeAddressField.getText().equals(employeeAddressTip) || employeeAddressField.getText().equals(employeeAddressRequiredTip)) {
            employeeAddressField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            employeeAddressField.setForeground(Color.RED);
            employeeAddressField.setText(employeeAddressRequiredTip);
            employeeDobField.requestFocus();
            ok = false;
        }
        if (employeeSpecilizationField.getText().equals(employeeSpecializationTip) || employeeSpecilizationField.getText().equals(employeeSpecializationRequiredTip)) {
            employeeSpecilizationField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            employeeSpecilizationField.setForeground(Color.RED);
            employeeSpecilizationField.setText(employeeSpecializationRequiredTip);
            employeeDobField.requestFocus();
            ok = false;
        }

        if (employeeSalaryField.getText().equals(employeeSalaryTip) || employeeSalaryField.getText().equals(employeeSalaryRequiredTip)) {
            employeeSalaryField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            employeeSalaryField.setForeground(Color.RED);
            employeeSalaryField.setText(employeeSalaryRequiredTip);
            employeeDobField.requestFocus();
            ok = false;
        }

        if (employeeTypeCombo.getSelectedIndex() == 0) {
            employeeTypeCombo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            employeeTypeCombo.setForeground(Color.RED);
            ok = false;
        }
        if (salaryTypeCombo.getSelectedIndex() == 0) {
            salaryTypeCombo.setForeground(Color.RED);
            salaryTypeCombo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        }
        if (questionField.isEnabled()) {
            if (questionField.getSelectedIndex() == 0) {
                questionField.setForeground(Color.RED);
                questionField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

            }
        }

        //If User Validation...
        //If it is user... then validate these items...
        if (employeeTypeCombo.getSelectedItem().toString().equalsIgnoreCase("user")) {

            if (userNameField.getText().equals(userNameTip) || userNameField.getText().equals(userNameRequiredTip)) {
                userNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                userNameField.setForeground(Color.RED);
                userNameField.setText(userNameRequiredTip);
                employeeDobField.requestFocus();
                ok = false;

            }
            if (userPasswordField.getText().equals(userPasswordTip) || userNameField.getText().equals(userPasswordRequiredTip)) {
                userPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                userPasswordField.setForeground(Color.RED);
                userPasswordField.setText(userPasswordRequiredTip);
                employeeDobField.requestFocus();
                ok = false;

            }
            if (answerField.getText().equals(questionAnswerTip) || userNameField.getText().equals(questionAnswerRequiredTip)) {
                answerField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                answerField.setForeground(Color.RED);
                answerField.setText(questionAnswerRequiredTip);
                employeeDobField.requestFocus();
                ok = false;
            }
        }

        /*
        //This is Currently Disabled by the user...
        //According to the requirment...
        if (imageFile == null) {
            profileIcon.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            employeeDobField.requestFocus();
            ok = false;
        }
         */
        return ok;

    }

    private void populateEmployeeRolesCombo() {
        employeeTypeCombo.removeAllItems();
        //Let the first item of the list be "Select Role"...
        employeeTypeCombo.addItem("Select Role");
        employeeRolesList = new RoleDaoImpl().getAllRoles();
        for (RoleBean role : employeeRolesList) {
            employeeTypeCombo.addItem(role.getRole());
        }
    }

    private void setUserFieldsEnabled(boolean what) {
        userInfoPanel.setEnabled(what);
        userNameField.setEnabled(what);
        userPasswordField.setEnabled(what);
        questionField.setEnabled(what);
        answerField.setEnabled(what);
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
            java.util.logging.Logger.getLogger(EmployeeEntryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeEntryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeEntryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeEntryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeEntryFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addlbl;
    private javax.swing.JTextField answerField;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel crossBtn;
    private javax.swing.JLabel deletelbl;
    private javax.swing.JLabel empAddressLabel;
    private javax.swing.JLabel empAmountLabel;
    private javax.swing.JLabel empAnswerLabel;
    private javax.swing.JLabel empCnicLabel;
    private javax.swing.JLabel empDobLabel;
    private javax.swing.JLabel empExpLabel;
    private javax.swing.JLabel empFieldLabel;
    private javax.swing.JLabel empGenderLabel;
    private javax.swing.JLabel empHeader;
    private javax.swing.JLabel empNameLabel;
    private javax.swing.JLabel empPassLabel;
    private javax.swing.JLabel empPhoneLabel;
    private javax.swing.JLabel empRoleLabel;
    private javax.swing.JLabel empSalaryLabel;
    private javax.swing.JLabel empSecurityLabel;
    private javax.swing.JLabel empSurnameLabel;
    private javax.swing.JLabel empUsernameLabel;
    private javax.swing.JTextField employeeAddressField;
    private javax.swing.JFormattedTextField employeeCnicField;
    private javax.swing.JFormattedTextField employeeContactField;
    private com.toedter.calendar.JDateChooser employeeDobField;
    private javax.swing.JTextField employeeExperienceField;
    private javax.swing.JPanel employeeInfoPanel;
    private javax.swing.JTextField employeeNameField;
    private javax.swing.JFormattedTextField employeeSalaryField;
    private javax.swing.JTextField employeeSpecilizationField;
    private javax.swing.JTextField employeeSurnameField;
    private javax.swing.JComboBox<String> employeeTypeCombo;
    private javax.swing.JTable employeetable;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JComboBox<String> questionField;
    private javax.swing.JLabel resetlbl;
    private javax.swing.JPanel salaryPanel;
    private javax.swing.JComboBox<String> salaryTypeCombo;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JScrollPane tableScorllPanel;
    private javax.swing.JLabel updatelbl;
    private javax.swing.JPanel userInfoPanel;
    private javax.swing.JTextField userNameField;
    private javax.swing.JPasswordField userPasswordField;
    // End of variables declaration//GEN-END:variables

    private void hideAllButtons() {
        addlbl.setVisible(false);
        updatelbl.setVisible(false);
        deletelbl.setVisible(false);
    }

    private void checkPermissions() {
//        List<PermissionBean> permissions = new RolePermissionDaoImpl().getAssignedPermissions(LoginFrame.userBean.getRole());
//        for (PermissionBean pb : permissions) {
//            if (pb.getPermission().equals("Add Employee")) {
//                addlbl.setVisible(true);
//            }
//            if (pb.getPermission().equals("Update Employee")) {
//                updatelbl.setVisible(true);
//            }
//            if (pb.getPermission().equals("Delete Employee")) {
//                deletelbl.setVisible(true);
//            }
//        }
    }
}
