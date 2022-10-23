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
import java.util.Map;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class TutorDAOimp implements TutorDAO{
     
   
   
//    public List <T> searchBy(Map <Integer , String> map,int i){}
    
// Getting all Courses
    

    @Override
    public void save(Tutor t, String imagePath) {
        CallableStatement cstm;
        try {
            cstm = Db.dbConnection.prepareCall("{call save_tutor(?,?,?,?,?,?,?,?)}");
            cstm.setString(1, t.getFirstName());
            cstm.setString(2, t.getLastName());
            cstm.setString(3, t.getAddress());
            cstm.setInt(4, t.getDept().getId());
            cstm.setInt(5, t.getFaculty().getId());
            cstm.setInt(6, t.getCourse().getId());
            cstm.setString(7, t.getEmail());
            InputStream image = null;
            try {
                image = new FileInputStream(new File(imagePath));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TutorDAOimp.class.getName()).log(Level.SEVERE, null, ex);
            }
            cstm.setBlob(8, image );
            cstm.executeUpdate();
//            ResultSet rs = cstm.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Tutor has been added ..");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public void update(Tutor t, String imagePath) {
        CallableStatement cstmt;
        if(imagePath == null){
            try {
                cstmt = Db.dbConnection.prepareCall("{call updateTutor(?,?,?,?,?,?,?,?)}");
                cstmt.setString(1, t.getFirstName());
                cstmt.setString(2, t.getLastName());
                cstmt.setString(3, t.getAddress());
                cstmt.setInt(4, t.getDept().getId());
                cstmt.setInt(5, t.getFaculty().getId());
                cstmt.setInt(6, t.getCourse().getId());
                cstmt.setString(7, t.getEmail());
                cstmt.setInt(8, t.getId());
                cstmt.executeUpdate();
//                ResultSet rs = cstmt.getGeneratedKeys();
                JOptionPane.showMessageDialog(null, "Tutor has been updated successfuly ..");
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex);
        }
        }else{
            try {
                cstmt = Db.dbConnection.prepareCall("{call updateTutorImg(?,?,?,?,?,?,?,?,?)}");
                cstmt.setString(1, t.getFirstName());
                cstmt.setString(2, t.getLastName());
                cstmt.setString(3, t.getAddress());
                cstmt.setInt(4, t.getDept().getId());
                cstmt.setInt(5, t.getFaculty().getId());
                cstmt.setInt(6, t.getCourse().getId());
                cstmt.setString(7, t.getEmail());
                InputStream image = null;
                try {
                    image = new FileInputStream(new File(imagePath));
                } catch (FileNotFoundException ex) {
                    JOptionPane.showInternalMessageDialog(null, ex.getMessage());
                }
                cstmt.setBlob(8, image );
                cstmt.setInt(9, t.getId());
                cstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Tutor has been updated successfuly ..");
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex);
        }
        }   
    }

    @Override
    public void delete(Tutor t) {
        CallableStatement cstmt;
        try {
            cstmt = Db.dbConnection.prepareCall("{call delete_tutor(?)}");
            cstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, t.getFirstName()+" "+t.getLastName()+" has been deleted ..");
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex);
        }
    }

    @Override
    public List<Tutor> listAll() {
        String sql = SQLStatements.allTutors;
        PreparedStatement stmt;
        ArrayList <Tutor> alltutors = new ArrayList<>();
        try {
            stmt = Db.dbConnection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Tutor tutor = new Tutor();
                tutor.setId(rs.getInt(1));
                // combobox by int with wraper Integer.parseInt(String);
                tutor.setFirstName(rs.getString(2));
                tutor.setLastName(rs.getString(3));
                tutor.setAddress(rs.getString(4));
                tutor.setEmail(rs.getString(5));
                tutor.setImage(rs.getBytes(6));
                Department dept = new Department();
                dept.setId(rs.getInt(7));
                Faculty fa = new Faculty();
                fa.setId(rs.getInt(9));
                Course co = new Course();
                co.setId(rs.getInt(11));
                tutor.setDept(dept);
                tutor.setFaculty(fa);
                tutor.setCourse(co);
                alltutors.add(tutor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
        return alltutors;
    }
}
