/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tungi
 */
public class DBUtils implements Serializable{
    private static final String DB_NAME = "Web_05_a";
    private static final String DB_USER_NAME = "sa";
    private static final String DB_PASSWORD = "12345";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName="+DB_NAME;
        conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
        return conn;
    }
    
    public static void main(String[] args) {
        try {
            Connection c =  getConnection();
            
            String sql = "INSERT INTO products (product_id, product_name, price, category, stock_quantity)"
                    + "  VALUES (12, N'Máy ảnh Sony A7 III', 45990000, N'Máy ảnh', 15)";
            
            Statement st = c.createStatement();
            
            int result = st.executeUpdate(sql);
            
            System.out.println(result);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
