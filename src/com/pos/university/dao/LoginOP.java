/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.dao;

import com.pos.university.constants.SQLStatements;
import java.sql.CallableStatement;
import java.sql.Types;
import com.pos.university.util.Db;
import com.pos.university.dto.Login;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class LoginOP {
    // Login operation
     public boolean login(Login login){
        PreparedStatement stmt;
        String sql = "SELECT * FROM university.login where email =? and password =? and role =?;";
        ResultSet rs = null;
        try {
            stmt = Db.dbConnection.prepareStatement(sql);
            stmt.setString(1, login.getEmail());
            stmt.setString(2, login.getPassword());
            stmt.setString(3, login.getRole());
            rs = stmt.executeQuery();
            if(rs.next())
                return true;
            else
                return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
     // Checking if there is an registered account
     public boolean checkAccount(Login login){
         String sql = "select * from university.login where email = ? and password= ? and role=?";
         PreparedStatement stmt;
         ResultSet rs = null;
         try{
             stmt = Db.dbConnection.prepareStatement(sql);
             stmt.setString(1, login.getEmail());
             stmt.setString(2, login.getPassword());
             stmt.setString(3, login.getRole());
             rs = stmt.executeQuery();
             if(rs.next())
                 return true;
             else
                 return false;
         } catch(SQLException ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
             return false;
         }
     }
     // Adding new account ( new regirsteration account )
     public void addLoginAccount(Login login){
        CallableStatement cstmt;
        try {
            cstmt = Db.dbConnection.prepareCall("{call loginF(?,?,?)}");
            cstmt.setString(1, login.getEmail());
            cstmt.setString(2, login.getPassword());
            cstmt.setString(3, login.getRole());
            cstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "User account has been created");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
     
}
