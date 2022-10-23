/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.util;
import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LENOVO
 */
public class Db {
    private static final String url = "jdbc:mysql://localhost:3306/university";
    private static final String username = "root";
    private static final String password = "123456789";
    public static Connection dbConnection = null;
    
    static {
        if(dbConnection == null)
            try {
                dbConnection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    
}
