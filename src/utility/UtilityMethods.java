/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Javed Ali Dahri
 */
public class UtilityMethods {
    public static void fillDataIntoCombos(List<String> values , javax.swing.JComboBox comboBox){
        comboBox.removeAllItems();
        for(String value : values){
            comboBox.addItem(value);
        }
    }
    
    public static void fillDataIntoTables(ResultSet rs , JTable tableName , JScrollPane jScrollPane , JFrame frame){
        DefaultTableModel dtm = new DefaultTableModel() ;
        tableName.setDefaultEditor(Object.class, null);

        dtm = (DefaultTableModel)DbUtils.resultSetToTableModel(rs);

        tableName.setModel(dtm);

        tableName.getColumnModel().getColumn(0).setWidth(0);
        tableName.getColumnModel().getColumn(0).setMinWidth(0);
        tableName.getColumnModel().getColumn(0).setMaxWidth(0);

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(11, 18, 29));
        headerRenderer.setForeground(new Color(140, 198, 62));

        for (int i = 0; i < tableName.getModel().getColumnCount(); i++) {
            tableName.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        tableName.setShowHorizontalLines(true);
        tableName.setShowVerticalLines(true);
        frame.getContentPane().setBackground(Color.WHITE);
        jScrollPane.getViewport().setBackground(Color.WHITE);
    }
    
    public static void searchDataFromTable(JTable tableName , JTextField textFieldName){
        String search = textFieldName.getText();
        TableRowSorter tableRowSorter = new TableRowSorter(tableName.getModel());
        tableName.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + search));
    }
    
      public static void copyDatabaseFile() throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            File f = new File("star_academy_db.sqlite");
            new File("D:\\backup").mkdir();

            is = new FileInputStream(f);
            os = new FileOutputStream(new File("D:\\backup\\star_academy_db.sqlite"));
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
}
