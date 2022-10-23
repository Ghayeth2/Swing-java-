/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.dao;

import com.pos.university.constants.SQLStatements;
import com.pos.university.util.Db;
import com.pos.university.dto.Course;
import com.pos.university.dto.Department;
import com.pos.university.dto.Faculty;
import com.pos.university.dto.Student;
import com.pos.university.dto.Tutor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class StudentDAOimp implements StudentDAO{
    
//    public List <T> searchBy(Map <Integer , String> map,int i){}
//    public List <T> searchBy(Map <Integer , String> map,int i){}
//    public List <T> searchBy(Map <Integer , String> map,int i){}

    @Override
    public void save(Student t, String imagePath) {
         String sql = "INSERT INTO `university`.`student`(`firstName`,`lastName`,`birthDate`,`stdNumber`,`email`,`gender`,"
                + "`deptId`,`facuId`,`courseId`,`image`)VALUES(?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = Db.dbConnection.prepareStatement(sql);
            pst.setString(1, t.getFirstName());
            pst.setString(2, t.getLastName());
            pst.setString(3, t.getDate());
            pst.setLong(4, t.getStdNumber());
            pst.setString(5, t.getEmail());
            pst.setString(6, t.getGender());
            pst.setInt(7, t.getDept().getId());
            pst.setInt(8, t.getFaculty().getId());
            pst.setInt(9, t.getCourse().getId());
            InputStream image = null;
            try {
                image = new FileInputStream(new File(imagePath));
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            pst.setBlob(10, image );
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student has been added ..");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public void update(Student t, String imagePath) {
         String sql = "UPDATE `university`.`student`SET`firstName` = ?,`lastName` = ?,`birthDate` = ?"
                + ",`stdNumber` = ?,`email` = ?,`gender` = ?,`deptId` = ?"
                + ",`facuId` = ?,`courseId` = ? WHERE `id` = "+t.getId();
        String sqlimage = "UPDATE `university`.`student`SET`firstName` = ?,`lastName` = ?,`birthDate` = ?,`stdNumber`"
                + " = ?,`email` = ?,`gender` = ?,`deptId` = ?,"
                + "`facuId` = ?,`courseId` = ?,`image` = ?WHERE `id` = "+t.getId();
        PreparedStatement pst;
        if(imagePath == null){
            try {
            pst = Db.dbConnection.prepareStatement(sql);
            pst.setString(1, t.getFirstName());
            pst.setString(2, t.getLastName());
            pst.setString(3, t.getDate());
            pst.setLong(4, t.getStdNumber());
            pst.setString(5, t.getEmail());
            pst.setString(6, t.getGender());
            pst.setInt(7, t.getDept().getId());
            pst.setInt(8, t.getFaculty().getId());
            pst.setInt(9, t.getCourse().getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student has been updated successfuly ..");
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex.getMessage());
        }
        }else{
            try {
            pst = Db.dbConnection.prepareStatement(sqlimage);
            pst.setString(1, t.getFirstName());
            pst.setString(2, t.getLastName());
            pst.setString(3, t.getDate());
            pst.setLong(4, t.getStdNumber());
            pst.setString(5, t.getEmail());
            pst.setString(6, t.getGender());
            pst.setInt(7, t.getDept().getId());
            pst.setInt(8, t.getFaculty().getId());
            pst.setInt(9, t.getCourse().getId());
            InputStream image = null;
            try {
                image = new FileInputStream(new File(imagePath));
            } catch (FileNotFoundException ex) {
                JOptionPane.showInternalMessageDialog(null, ex.getMessage());
            }
            pst.setBlob(10, image );
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student has been updated successfuly ..");
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex);
        }
        }   
    }

    @Override
    public void delete(Student t) {
        String sql = "DELETE FROM `university`.`student`WHERE `id` = "+t.getId();
        PreparedStatement pst;
        try {
            pst = Db.dbConnection.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student has been deleted ..");
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex);
        }
    }

    @Override
    public List<Student> listAll() {
        String sql = SQLStatements.allStudents;
        ArrayList <Student> allStudents = new ArrayList<>();
        try {
            PreparedStatement pst = Db.dbConnection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt(1));
                // combobox by int with wraper Integer.parseInt(String);
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setDate(rs.getString("birthDate"));
                student.setStdNumber(rs.getInt("stdNumber"));
                student.setEmail(rs.getString("email"));
                student.setGender(rs.getString("gender"));
                student.setImage(rs.getBytes("image"));
                Department dept = new Department();
                Course course = new Course();
                Faculty faculty = new Faculty();
                dept.setId(rs.getInt(12));
                student.setId(rs.getInt(18));
                course.setId(rs.getInt(15));
                student.setCourse(course);
                student.setDept(dept);
                student.setFaculty(faculty);
                allStudents.add(student);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
        return allStudents;
    }
}
