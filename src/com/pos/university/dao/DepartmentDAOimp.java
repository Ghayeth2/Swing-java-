/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.dao;

import com.pos.university.util.Db;
import java.sql.CallableStatement;
import java.sql.Types;
import com.pos.university.commons.UniversityDAO;
import com.pos.university.constants.SQLStatements;
import com.pos.university.dto.Department;
import com.pos.university.dto.Faculty;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class DepartmentDAOimp implements DepartmentDAO{
    
    @Override
    public void save(Department t) {
        CallableStatement cStmt;
        try {
            cStmt = Db.dbConnection.prepareCall("{call save_dept(?,?)}");
            cStmt.setString(1, t.getName());
            cStmt.setInt(2, t.getFaculty().getId());
            cStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, t.getName()+" has been added ..");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public void update(Department t) {
        CallableStatement cStmt;
        try {
            cStmt = Db.dbConnection.prepareCall("{call update_dept(?,?,?)}");
            cStmt.setString(1, t.getName());
            cStmt.setInt(2, t.getFaculty().getId());
            cStmt.setInt(3, t.getId());
            cStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Department has been updated successfuly ..");
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex);
        }
    }

    @Override
    public void delete(Department t) {
        CallableStatement cStmt;
        try {
            cStmt = Db.dbConnection.prepareCall("{call delete_dept(?)}");
            cStmt.setInt(1, t.getId());
            cStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, t.getName()+" has been deleted ..");
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex);
        }
    }

    @Override
    public List<Department> listAll() {
        PreparedStatement stmt;
        String sql = SQLStatements.allDepts;
        ArrayList <Department> allDepts = new ArrayList<>();
        try {
            stmt = Db.dbConnection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            // Use it instead of having id -> put its name, user won't recognize
            // the id of the faculty he doesn't have access into database
            while(rs.next()){
                Department f = new Department();
                f.setId(rs.getInt(1));
                f.setName(rs.getString(2));
                // Setting foreign keys' names instead of ids
                Faculty fa = new Faculty();
                fa.setId(rs.getInt(3));
                f.setFaculty(fa);
                allDepts.add(f);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
        return allDepts;
    }
}
