/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.dao;

import com.pos.university.constants.SQLStatements;
import java.sql.CallableStatement;
import java.sql.Types;
import com.pos.university.util.Db;
import com.pos.university.dto.Faculty;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class FacultyDAOimp implements FacultyDAO{
//    public List <T> searchBy(Map <Integer , String> map,int i){}
    
        // Exciption if it were from DAO layer then it should appear from here
        // too, because it is the connecting point.
        // Therefore, the functions in DAO should be Integer or Boolean not 
        // void()
    @Override
    public void save(Faculty t) {
        try {
            //  Connector Statement with Stored Procedure in MySQL
            CallableStatement cStmt = Db.dbConnection.prepareCall("{call save_faculty(?)}");
            cStmt.setString(1, t.getName());
            
            ResultSet rs = cStmt.getGeneratedKeys();
            
            cStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Faculty has been added ..");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public void update(Faculty t) {
        CallableStatement cStmt;
        try {
            // Both parameters are IN
            cStmt = Db.dbConnection.prepareCall("{call update_faculty(?,?)}");
            cStmt.setString(1, t.getName());
            cStmt.setInt(2, t.getId());
            cStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Faculty has been updated successfuly ..");
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex);
        }
    }

    @Override
    public void delete(Faculty t) {
        // It is not possible to get the name from database while applying
        // delete function on the table. So, we can just get it from here
        // whenever the user clicks on wanted faculty.
        String deletedFaculty = null;
        CallableStatement cStmt;
        try {
            cStmt = Db.dbConnection.prepareCall("{call delete_Faculty(?)}");
            cStmt.setInt(1, t.getId());
            cStmt.executeUpdate();
            // Instead of getting this message, it is much better to know 
            // what faculty has been deleted. And we might put the message 
            // in UI layer instead of putting it in here.
            JOptionPane.showMessageDialog(null, t.getName()+" has been deleted ..");
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex);
        }
    }

    @Override
    public List<Faculty> listAll() {
        PreparedStatement stmt;
        String sql = SQLStatements.allFaculties;
        List <Faculty> allFaculties = new ArrayList<>();
        try {
            stmt = Db.dbConnection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Faculty f = new Faculty();
                f.setId(rs.getInt(1));
                f.setName(rs.getString(2));
                allFaculties.add(f);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return allFaculties;
    }
}
