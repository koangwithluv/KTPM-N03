/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer-PC
 */
public class DBConnect {
    public static Connection getConnection(){
        String link = System.getProperty("user.dir");
        Connection connection = null;
        try {
            
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(link);
         //Lay ket noi va lay du lieu
         
        try {
            //ket noi
            connection = DriverManager.getConnection("jdbc:sqlite:"+link +"\\src\\QLiCongNhan.db");
            
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        Connection c = getConnection();
        System.out.println(c.toString());
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
