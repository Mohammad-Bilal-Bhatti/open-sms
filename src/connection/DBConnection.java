/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Bilal Bhatti
 */
public class DBConnection {

    private static Connection con = null;
    private static final String DBNAME = "db.sqlite";

    public static Connection getConnection() {
        if (con == null) {
            
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+ DBNAME);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return con;
    }
    
    public static boolean checkDB(){
        boolean check = true;
        File f = new File("db.sqlite");
        if(!f.exists()){
            check = false;
        }
        return check;
    }
}
