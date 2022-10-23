/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.dao;

import com.pos.university.util.Db;
import com.pos.university.dto.Course;
import com.pos.university.dto.Department;
import com.pos.university.dto.Faculty;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.CallableStatement;
import java.sql.Types;

/**
 *
 * @author LENOVO
 */
public class CourseDAOimp implements CourseDAO{
//    public List <T> searchBy(Map <Integer , String> map,int i){}

    @Override
    // GENERATED values returning
    public void save(Course t) {
        CallableStatement cStmt;
        try {
            cStmt = Db.dbConnection.prepareCall("{call save_course(?,?)}");
            cStmt.setString(1, t.getName());
            cStmt.setInt(2, t.getDept().getId());
            
            ResultSet rs = cStmt.getGeneratedKeys();
            
            cStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Course has been added ..");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public void update(Course t) {
        CallableStatement cStmt;
        try {
            cStmt = Db.dbConnection.prepareCall("{call update_course(?,?,?)}");
            cStmt.setString(1, t.getName());
            cStmt.setInt(2, t.getDept().getId());
            cStmt.setInt(3, t.getId());
            cStmt.executeUpdate();
            ResultSet rs = cStmt.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Course has been updated successfuly ..");
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex);
            
        }
    }

    @Override
    public void delete(Course t) {
        CallableStatement cStmt;
        try {
            cStmt = Db.dbConnection.prepareCall("{call delete_course(?)}");
            cStmt.setInt(1, t.getId());
            cStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, t.getName()+" has been deleted ..");
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex);
        }
    }
    @Override
    public List<Course> listAll() {
         String sql = " searchById ()  can use IN & OUT at the same time\n" +
"    // Or any other operation needs to get data by inserting some of it into \n" +
"    // databaseJOIN Course & Department & Faculty to display sequence ";
         CallableStatement cstmt;
         ResultSet rs;
        ArrayList <Course> allCourses = new ArrayList<>();
        try {
            cstmt = Db.dbConnection.prepareCall("{call allCourses(?,?,?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.registerOutParameter(3, Types.INTEGER);
            cstmt.registerOutParameter(4, Types.VARCHAR);
            rs = cstmt.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setId(cstmt.getInt(1));
                course.setName(cstmt.getString(2));
                Department dept = new Department();
                dept.setId(cstmt.getInt(3));
                dept.setName(cstmt.getString(4));
                course.setDept(dept);
                allCourses.add(course);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
        return allCourses;
    }
}
