/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import beans.ExpenseBean;
import beans.FeesBean;
import dao.FeesDao;
import daoimpl.ExpenseDaoImpl;
import daoimpl.FeesDaoImpl;

/**
 *
 * @author Javed Ali Dahri
 */
public class AnalyzeProfit extends javax.swing.JFrame {

    FeesDao feesDao = new FeesDaoImpl();
    String month="";
    String selectedYear="";
    Double totalExpensesAmount = 0.0;
    Double totalFeesAmount = 0.0;
    public AnalyzeProfit() {
        initComponents();
        Toolkit t = Toolkit.getDefaultToolkit();
        this.setSize(t.getScreenSize().width,t.getScreenSize().height);
        this.setLocationRelativeTo(null);
        dailyexpensetable.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,14));
        monthlyexpensetable.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,14));
        ownerexpensetable.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,14));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        mainpanel = new javax.swing.JPanel();
        cross = new javax.swing.JLabel();
        profitHeader = new javax.swing.JLabel();
        totalFeePanel = new javax.swing.JPanel();
        totalFeeHeader = new javax.swing.JLabel();
        idCardLabel = new javax.swing.JLabel();
        admisstionFeeLabel = new javax.swing.JLabel();
        formFeeLabel = new javax.swing.JLabel();
        boardRegFeeLabel = new javax.swing.JLabel();
        boardExamFeeLabel = new javax.swing.JLabel();
        boardLateFeeLabel = new javax.swing.JLabel();
        certificateFeeLabel = new javax.swing.JLabel();
        markFeeLabel = new javax.swing.JLabel();
        totalfeelbl = new javax.swing.JLabel();
        monthlyFeeHeader = new javax.swing.JLabel();
        monthlyfeelbl = new javax.swing.JLabel();
        idcardfeelbl = new javax.swing.JLabel();
        formfeelbl = new javax.swing.JLabel();
        boardregfeelbl = new javax.swing.JLabel();
        boardexamfeelbl = new javax.swing.JLabel();
        boardlatefeelbl = new javax.swing.JLabel();
        certificatefeelbl = new javax.swing.JLabel();
        marksheetfeelbl = new javax.swing.JLabel();
        testexamfeelbl = new javax.swing.JLabel();
        admissionfeelbl = new javax.swing.JLabel();
        testExamFeeLabel = new javax.swing.JLabel();
        totalFeeSumLabel = new javax.swing.JLabel();
        selYearLabel = new javax.swing.JLabel();
        monthchooser = new com.toedter.calendar.JMonthChooser();
        selMonthLabel = new javax.swing.JLabel();
        yearchooser = new com.toedter.calendar.JYearChooser();
        analyzeProfitBtn = new javax.swing.JLabel();
        expendetureDetailsPanel = new javax.swing.JPanel();
        expenseDetailHeader = new javax.swing.JLabel();
        dailyExpenseScroll = new javax.swing.JScrollPane();
        dailyexpensetable = new javax.swing.JTable();
        ownerExpenHeader = new javax.swing.JLabel();
        monthlyExpenseScroll = new javax.swing.JScrollPane();
        monthlyexpensetable = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        dailyExpendHeader = new javax.swing.JLabel();
        ownerExpenseScroll = new javax.swing.JScrollPane();
        ownerexpensetable = new javax.swing.JTable();
        monthlyExpendHeader = new javax.swing.JLabel();
        totalAmmountSumPanel = new javax.swing.JPanel();
        totaldailylbl = new javax.swing.JLabel();
        monthlyExpenAmountLabel = new javax.swing.JLabel();
        totalmonthlylbl = new javax.swing.JLabel();
        dailyExpenAmountLabel = new javax.swing.JLabel();
        ownerExpendAmountLabel = new javax.swing.JLabel();
        totalownerlbl = new javax.swing.JLabel();
        totalAmountlbl = new javax.swing.JLabel();
        amountlabel = new javax.swing.JLabel();
        profitlosslabel = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));
        mainpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cross.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        cross.setForeground(new java.awt.Color(255, 255, 255));
        cross.setText("X");
        cross.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cross.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crossMouseClicked(evt);
            }
        });
        mainpanel.add(cross, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 20, 20, 30));

        profitHeader.setBackground(new java.awt.Color(0, 102, 0));
        profitHeader.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        profitHeader.setForeground(new java.awt.Color(255, 255, 255));
        profitHeader.setText("                                                            Profit Loss Analysis");
        profitHeader.setOpaque(true);
        mainpanel.add(profitHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 65));

        totalFeePanel.setBackground(new java.awt.Color(255, 255, 255));
        totalFeePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));

        totalFeeHeader.setBackground(new java.awt.Color(51, 153, 0));
        totalFeeHeader.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        totalFeeHeader.setForeground(new java.awt.Color(255, 255, 255));
        totalFeeHeader.setText("                      Total Fees ");
        totalFeeHeader.setOpaque(true);

        idCardLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idCardLabel.setText("ID Card Fee");

        admisstionFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        admisstionFeeLabel.setText("Admission Fee");

        formFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        formFeeLabel.setText("Form Fee");

        boardRegFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boardRegFeeLabel.setText("Board Reg Fee");

        boardExamFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boardExamFeeLabel.setText("Board Exam Fee");

        boardLateFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boardLateFeeLabel.setText("Board Late Fee");

        certificateFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        certificateFeeLabel.setText("Certificate Fee");

        markFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        markFeeLabel.setText("Marksheet Fee");

        totalfeelbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalfeelbl.setForeground(new java.awt.Color(0, 102, 0));
        totalfeelbl.setText("0.00");

        monthlyFeeHeader.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        monthlyFeeHeader.setText("Monthly Fee");

        monthlyfeelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        monthlyfeelbl.setText("0.00");

        idcardfeelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idcardfeelbl.setText("0.00");

        formfeelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        formfeelbl.setText("0.00");

        boardregfeelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boardregfeelbl.setText("0.00");

        boardexamfeelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boardexamfeelbl.setText("0.00");

        boardlatefeelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boardlatefeelbl.setText("0.00");

        certificatefeelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        certificatefeelbl.setText("0.00");

        marksheetfeelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        marksheetfeelbl.setText("0.00");

        testexamfeelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        testexamfeelbl.setText("0.00");

        admissionfeelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        admissionfeelbl.setText("0.00");

        testExamFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        testExamFeeLabel.setText("Test Exam Fee");

        totalFeeSumLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalFeeSumLabel.setForeground(new java.awt.Color(0, 102, 0));
        totalFeeSumLabel.setText("Total Fees");

        javax.swing.GroupLayout totalFeePanelLayout = new javax.swing.GroupLayout(totalFeePanel);
        totalFeePanel.setLayout(totalFeePanelLayout);
        totalFeePanelLayout.setHorizontalGroup(
            totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalFeeHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(totalFeePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalFeePanelLayout.createSequentialGroup()
                        .addComponent(monthlyFeeHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(monthlyfeelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(totalFeePanelLayout.createSequentialGroup()
                        .addComponent(idCardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(idcardfeelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(totalFeePanelLayout.createSequentialGroup()
                        .addComponent(formFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(formfeelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(totalFeePanelLayout.createSequentialGroup()
                        .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(totalFeePanelLayout.createSequentialGroup()
                                .addComponent(boardRegFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)
                                .addComponent(boardregfeelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(totalFeePanelLayout.createSequentialGroup()
                                .addComponent(boardExamFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)
                                .addComponent(boardexamfeelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(totalFeePanelLayout.createSequentialGroup()
                                .addComponent(boardLateFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)
                                .addComponent(boardlatefeelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(totalFeePanelLayout.createSequentialGroup()
                                .addComponent(certificateFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)
                                .addComponent(certificatefeelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(totalFeePanelLayout.createSequentialGroup()
                                .addComponent(markFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)
                                .addComponent(marksheetfeelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(totalFeePanelLayout.createSequentialGroup()
                                .addComponent(admisstionFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)
                                .addComponent(admissionfeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(totalFeePanelLayout.createSequentialGroup()
                                .addComponent(testExamFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)
                                .addComponent(testexamfeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(totalFeePanelLayout.createSequentialGroup()
                                .addComponent(totalFeeSumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalfeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2))))
        );
        totalFeePanelLayout.setVerticalGroup(
            totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalFeePanelLayout.createSequentialGroup()
                .addComponent(totalFeeHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(admisstionFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admissionfeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monthlyFeeHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthlyfeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idCardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idcardfeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formfeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boardRegFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boardregfeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boardExamFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boardexamfeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boardLateFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boardlatefeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(certificateFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(certificatefeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(markFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marksheetfeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(testExamFeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(testexamfeelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(totalFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalFeeSumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalfeelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        mainpanel.add(totalFeePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 380, 590));

        selYearLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selYearLabel.setForeground(new java.awt.Color(0, 102, 0));
        selYearLabel.setText("Select Year");
        mainpanel.add(selYearLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 90, 30));

        monthchooser.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        mainpanel.add(monthchooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 130, 30));

        selMonthLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selMonthLabel.setForeground(new java.awt.Color(0, 102, 0));
        selMonthLabel.setText("Select Month");
        mainpanel.add(selMonthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));
        mainpanel.add(yearchooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 130, 30));

        analyzeProfitBtn.setBackground(new java.awt.Color(255, 255, 255));
        analyzeProfitBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        analyzeProfitBtn.setForeground(new java.awt.Color(255, 255, 255));
        analyzeProfitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/analyzelbl.png"))); // NOI18N
        analyzeProfitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                analyzeProfitBtnMouseClicked(evt);
            }
        });
        mainpanel.add(analyzeProfitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 160, 50));

        expendetureDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        expendetureDetailsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        expendetureDetailsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        expenseDetailHeader.setBackground(new java.awt.Color(51, 153, 0));
        expenseDetailHeader.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        expenseDetailHeader.setForeground(new java.awt.Color(255, 255, 255));
        expenseDetailHeader.setText("                                                                Expenditure Details ");
        expenseDetailHeader.setOpaque(true);
        expendetureDetailsPanel.add(expenseDetailHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 960, 50));

        dailyexpensetable.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 102, 0)));
        dailyexpensetable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dailyexpensetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.no", "Expense", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dailyexpensetable.setFocusable(false);
        dailyexpensetable.setGridColor(new java.awt.Color(255, 255, 255));
        dailyexpensetable.setOpaque(false);
        dailyexpensetable.setRowHeight(20);
        dailyexpensetable.setRowMargin(2);
        dailyexpensetable.getTableHeader().setResizingAllowed(false);
        dailyexpensetable.getTableHeader().setReorderingAllowed(false);
        dailyExpenseScroll.setViewportView(dailyexpensetable);
        if (dailyexpensetable.getColumnModel().getColumnCount() > 0) {
            dailyexpensetable.getColumnModel().getColumn(0).setResizable(false);
            dailyexpensetable.getColumnModel().getColumn(1).setResizable(false);
            dailyexpensetable.getColumnModel().getColumn(2).setResizable(false);
        }

        expendetureDetailsPanel.add(dailyExpenseScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 290, 370));

        ownerExpenHeader.setBackground(new java.awt.Color(102, 102, 102));
        ownerExpenHeader.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ownerExpenHeader.setForeground(new java.awt.Color(255, 255, 255));
        ownerExpenHeader.setText("              Owner Expenditures");
        ownerExpenHeader.setOpaque(true);
        expendetureDetailsPanel.add(ownerExpenHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 270, 40));

        monthlyexpensetable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        monthlyexpensetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.no", "Expense", "Employee", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        monthlyexpensetable.setFocusable(false);
        monthlyexpensetable.setGridColor(new java.awt.Color(255, 255, 255));
        monthlyexpensetable.setOpaque(false);
        monthlyexpensetable.setRowHeight(20);
        monthlyexpensetable.setRowMargin(2);
        monthlyexpensetable.getTableHeader().setResizingAllowed(false);
        monthlyexpensetable.getTableHeader().setReorderingAllowed(false);
        monthlyExpenseScroll.setViewportView(monthlyexpensetable);
        if (monthlyexpensetable.getColumnModel().getColumnCount() > 0) {
            monthlyexpensetable.getColumnModel().getColumn(0).setResizable(false);
            monthlyexpensetable.getColumnModel().getColumn(1).setResizable(false);
            monthlyexpensetable.getColumnModel().getColumn(2).setResizable(false);
            monthlyexpensetable.getColumnModel().getColumn(3).setResizable(false);
        }

        expendetureDetailsPanel.add(monthlyExpenseScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 380, 370));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        expendetureDetailsPanel.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        dailyExpendHeader.setBackground(new java.awt.Color(102, 102, 102));
        dailyExpendHeader.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dailyExpendHeader.setForeground(new java.awt.Color(255, 255, 255));
        dailyExpendHeader.setText("                    Daily Expenditures");
        dailyExpendHeader.setOpaque(true);
        expendetureDetailsPanel.add(dailyExpendHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 310, 40));

        ownerexpensetable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ownerexpensetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.no", "Owner", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ownerexpensetable.setFocusable(false);
        ownerexpensetable.setGridColor(new java.awt.Color(255, 255, 255));
        ownerexpensetable.setOpaque(false);
        ownerexpensetable.setRowHeight(20);
        ownerexpensetable.setRowMargin(2);
        ownerexpensetable.getTableHeader().setResizingAllowed(false);
        ownerexpensetable.getTableHeader().setReorderingAllowed(false);
        ownerExpenseScroll.setViewportView(ownerexpensetable);
        if (ownerexpensetable.getColumnModel().getColumnCount() > 0) {
            ownerexpensetable.getColumnModel().getColumn(0).setResizable(false);
            ownerexpensetable.getColumnModel().getColumn(1).setResizable(false);
            ownerexpensetable.getColumnModel().getColumn(2).setResizable(false);
        }

        expendetureDetailsPanel.add(ownerExpenseScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 270, 370));

        monthlyExpendHeader.setBackground(new java.awt.Color(102, 102, 102));
        monthlyExpendHeader.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        monthlyExpendHeader.setForeground(new java.awt.Color(255, 255, 255));
        monthlyExpendHeader.setText("                           Monthly Expenditures");
        monthlyExpendHeader.setOpaque(true);
        expendetureDetailsPanel.add(monthlyExpendHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 400, 40));

        totalAmmountSumPanel.setBackground(new java.awt.Color(255, 255, 255));
        totalAmmountSumPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        totalAmmountSumPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totaldailylbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        totaldailylbl.setForeground(new java.awt.Color(0, 102, 0));
        totalAmmountSumPanel.add(totaldailylbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 90, 50));

        monthlyExpenAmountLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        monthlyExpenAmountLabel.setForeground(new java.awt.Color(0, 102, 0));
        monthlyExpenAmountLabel.setText("Total Amount");
        totalAmmountSumPanel.add(monthlyExpenAmountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 110, 50));

        totalmonthlylbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        totalmonthlylbl.setForeground(new java.awt.Color(0, 102, 0));
        totalAmmountSumPanel.add(totalmonthlylbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 90, 50));

        dailyExpenAmountLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        dailyExpenAmountLabel.setForeground(new java.awt.Color(0, 102, 0));
        dailyExpenAmountLabel.setText("Total Amount");
        totalAmmountSumPanel.add(dailyExpenAmountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        ownerExpendAmountLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ownerExpendAmountLabel.setForeground(new java.awt.Color(0, 102, 0));
        ownerExpendAmountLabel.setText("Total Amount");
        totalAmmountSumPanel.add(ownerExpendAmountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 100, 50));

        totalownerlbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        totalownerlbl.setForeground(new java.awt.Color(0, 102, 0));
        totalAmmountSumPanel.add(totalownerlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 70, 50));

        expendetureDetailsPanel.add(totalAmmountSumPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 940, 50));

        totalAmountlbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        totalAmountlbl.setForeground(new java.awt.Color(0, 102, 0));
        totalAmountlbl.setText("Total Amount");
        expendetureDetailsPanel.add(totalAmountlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 100, 50));

        amountlabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        amountlabel.setForeground(new java.awt.Color(0, 102, 0));
        expendetureDetailsPanel.add(amountlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 520, 160, 70));

        profitlosslabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        profitlosslabel.setForeground(new java.awt.Color(0, 102, 0));
        expendetureDetailsPanel.add(profitlosslabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 524, 470, 60));

        mainpanel.add(expendetureDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 960, 590));

        getContentPane().add(mainpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossMouseClicked
//      new MainFrame().setVisible(true);
//      this.dispose();
    }//GEN-LAST:event_crossMouseClicked

    private void analyzeProfitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analyzeProfitBtnMouseClicked
        setFieldsInitailValues();
        setFeesRecord();
        populateDailyExpenses();
        populateMonthlyExpenses();
        populateOwnerExpenses();
        calculateProfitAndLoss();
    }//GEN-LAST:event_analyzeProfitBtnMouseClicked

    private void setFeesRecord(){
        Integer monthIndex = monthchooser.getMonth();
        switch(monthIndex){
            case 0:
                month="January";
            break;
            case 1:
                month="February";
            break;
            case 2:
                month="March";
            break;
            case 3:
                month="April";
            break;
            case 4:
                month="May";
            break;
            case 5:
                month="June";
            break;
            case 6:
                month="July";
            break;
            case 7:
                month="August";
            break;
            case 8:
                month="September";
            break;
            case 9:
                month="October";
            break;
            case 10:
                month="November";
            break;
            case 11:
                month="December";
        }
        Integer year = yearchooser.getYear();
        selectedYear = String.valueOf(year);
        List<FeesBean> feeRecord = feesDao.getFeesRecord(month, year);
        for(FeesBean fb:feeRecord){
            if(fb.getFeesType().getFeesTitle().contains("Admission")){
                admissionfeelbl.setText(fb.getTotalFeesAmount()+"");
            }
            else if(fb.getFeesType().getFeesTitle().contains("Monthly")){
                monthlyfeelbl.setText(fb.getTotalFeesAmount()+"");
            }
            else if(fb.getFeesType().getFeesTitle().contains("ID")){
                idcardfeelbl.setText(fb.getTotalFeesAmount()+"");
            }
            else if(fb.getFeesType().getFeesTitle().contains("Form")){
                formfeelbl.setText(fb.getTotalFeesAmount()+"");
            }
            else if(fb.getFeesType().getFeesTitle().contains("Registeration")){
                boardregfeelbl.setText(fb.getTotalFeesAmount()+"");
            }
            else if(fb.getFeesType().getFeesTitle().contains("Exam")){
                boardexamfeelbl.setText(fb.getTotalFeesAmount()+"");
            }
            else if(fb.getFeesType().getFeesTitle().contains("Late")){
                boardlatefeelbl.setText(fb.getTotalFeesAmount()+"");
            }
            else if(fb.getFeesType().getFeesTitle().contains("Certificate")){
                certificatefeelbl.setText(fb.getTotalFeesAmount()+"");
            }
            else if(fb.getFeesType().getFeesTitle().contains("Marks")){
                marksheetfeelbl.setText(fb.getTotalFeesAmount()+"");
            }
            else if(fb.getFeesType().getFeesTitle().contains("Test")){
                testexamfeelbl.setText(fb.getTotalFeesAmount()+"");
            }
            totalFeesAmount+=fb.getTotalFeesAmount();
        }
        totalfeelbl.setText(totalFeesAmount+" Rs");
    }
    
    private void populateDailyExpenses(){
        DefaultTableModel dtm = (DefaultTableModel)dailyexpensetable.getModel();
        Double total=0.0;
        dtm.setRowCount(0);
        List<ExpenseBean> dailyExpenses = new ExpenseDaoImpl().getAllDailyExpenses();
        int sNo = 1;
        for(ExpenseBean eb:dailyExpenses){
            if(eb.getDateOfPayment().contains(month+" "+selectedYear)){
                Object [] values = {sNo,eb.getExpenseTitle(),eb.getExpenseAmount()};
                dtm.addRow(values);
                sNo++;
                total+=eb.getExpenseAmount();
            }
        }
        totalExpensesAmount+=total;
        totaldailylbl.setText(total+" Rs");
    }
    
    private void populateMonthlyExpenses(){
        DefaultTableModel dtm = (DefaultTableModel)monthlyexpensetable.getModel();
        dtm.setRowCount(0);
        List<ExpenseBean> monthlyExpenses = new ExpenseDaoImpl().getAllMonthlyExpenses();
        Double total=0.0;
        int sNo = 1;
        for(ExpenseBean eb:monthlyExpenses){
            if(eb.getDateOfPayment().contains(month+" "+selectedYear)){
                Object [] values = {sNo,eb.getExpenseType().getExpenseTitle(),eb.getEmployee().getEmpName(),eb.getExpenseAmount()};
                dtm.addRow(values);
                sNo++;
                total+=eb.getExpenseAmount();
            }
        }
        totalExpensesAmount+=total;
        totalmonthlylbl.setText(total+" Rs");
    }
    
    private void populateOwnerExpenses(){
        DefaultTableModel dtm = (DefaultTableModel)ownerexpensetable.getModel();
        dtm.setRowCount(0);
        List<ExpenseBean> ownerExpenses = new ExpenseDaoImpl().getAllOwnerExpenses();
        Double total=0.0;
        int sNo = 1;
        for(ExpenseBean eb:ownerExpenses){
            if(eb.getDateOfPayment().contains(month+" "+selectedYear)){
                Object [] values = {sNo,eb.getEmployee().getEmpName(),eb.getExpenseAmount()};
                dtm.addRow(values);
                sNo++;
                total+=eb.getExpenseAmount();
            }
        }
        totalExpensesAmount+=total;
        totalownerlbl.setText(total+" Rs");
    }
    
    private void calculateProfitAndLoss(){
        Double netAmount = totalFeesAmount-totalExpensesAmount;
        if(netAmount>0){
            profitlosslabel.setText("Profit Gained");
            amountlabel.setText(netAmount+" Rs");
        }
        else if(netAmount<0){
            profitlosslabel.setText("Loss ");
            amountlabel.setText(netAmount+" Rs");
        }
        else{
            profitlosslabel.setText("No Profit no loss");
            amountlabel.setText(netAmount+"");
        }
    }
    
    private void setFieldsInitailValues(){
        admissionfeelbl.setText("0.00");
        monthlyfeelbl.setText("0.00");
        idcardfeelbl.setText("0.00");
        formfeelbl.setText("0.00");
        boardregfeelbl.setText("0.00");
        boardexamfeelbl.setText("0.00");
        boardlatefeelbl.setText("0.00");
        certificatefeelbl.setText("0.00");
        marksheetfeelbl.setText("0.00");
        testexamfeelbl.setText("0.00");
        totalfeelbl.setText("0.00");
        profitlosslabel.setText("");
        amountlabel.setText("");
        totalExpensesAmount = 0.0;
        totalFeesAmount = 0.0;
        
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
            java.util.logging.Logger.getLogger(AnalyzeProfit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalyzeProfit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalyzeProfit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalyzeProfit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnalyzeProfit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admissionfeelbl;
    private javax.swing.JLabel admisstionFeeLabel;
    private javax.swing.JLabel amountlabel;
    private javax.swing.JLabel analyzeProfitBtn;
    private javax.swing.JLabel boardExamFeeLabel;
    private javax.swing.JLabel boardLateFeeLabel;
    private javax.swing.JLabel boardRegFeeLabel;
    private javax.swing.JLabel boardexamfeelbl;
    private javax.swing.JLabel boardlatefeelbl;
    private javax.swing.JLabel boardregfeelbl;
    private javax.swing.JLabel certificateFeeLabel;
    private javax.swing.JLabel certificatefeelbl;
    private javax.swing.JLabel cross;
    private javax.swing.JLabel dailyExpenAmountLabel;
    private javax.swing.JLabel dailyExpendHeader;
    private javax.swing.JScrollPane dailyExpenseScroll;
    private javax.swing.JTable dailyexpensetable;
    private javax.swing.JPanel expendetureDetailsPanel;
    private javax.swing.JLabel expenseDetailHeader;
    private javax.swing.JLabel formFeeLabel;
    private javax.swing.JLabel formfeelbl;
    private javax.swing.JLabel idCardLabel;
    private javax.swing.JLabel idcardfeelbl;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JLabel markFeeLabel;
    private javax.swing.JLabel marksheetfeelbl;
    private com.toedter.calendar.JMonthChooser monthchooser;
    private javax.swing.JLabel monthlyExpenAmountLabel;
    private javax.swing.JLabel monthlyExpendHeader;
    private javax.swing.JScrollPane monthlyExpenseScroll;
    private javax.swing.JLabel monthlyFeeHeader;
    private javax.swing.JTable monthlyexpensetable;
    private javax.swing.JLabel monthlyfeelbl;
    private javax.swing.JLabel ownerExpenHeader;
    private javax.swing.JLabel ownerExpendAmountLabel;
    private javax.swing.JScrollPane ownerExpenseScroll;
    private javax.swing.JTable ownerexpensetable;
    private javax.swing.JLabel profitHeader;
    private javax.swing.JLabel profitlosslabel;
    private javax.swing.JLabel selMonthLabel;
    private javax.swing.JLabel selYearLabel;
    private javax.swing.JLabel testExamFeeLabel;
    private javax.swing.JLabel testexamfeelbl;
    private javax.swing.JPanel totalAmmountSumPanel;
    private javax.swing.JLabel totalAmountlbl;
    private javax.swing.JLabel totalFeeHeader;
    private javax.swing.JPanel totalFeePanel;
    private javax.swing.JLabel totalFeeSumLabel;
    private javax.swing.JLabel totaldailylbl;
    private javax.swing.JLabel totalfeelbl;
    private javax.swing.JLabel totalmonthlylbl;
    private javax.swing.JLabel totalownerlbl;
    private com.toedter.calendar.JYearChooser yearchooser;
    // End of variables declaration//GEN-END:variables
}
