/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.bao;

import com.pos.university.commons.BAOExciption;
import com.pos.university.dao.StudentDAO;
import com.pos.university.dto.Student;
import com.pos.university.factory.StudentDb;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class StudentBAOimp implements StudentBAO{
    // Factory D.P. calling for Database object from an implementing class
    private StudentDAO db = StudentDb.creaStudentDAOimp();
    @Override
    public void save(Student t, String imagePath) {
        if(t.getId() == 0)
           db.save(t, imagePath); 
        else {
                try {
                    // University generated BAO Exciption
                    throw new BAOExciption("Error : trying to save new data into existed one");
                } catch (BAOExciption ex) {
                    JOptionPane.showInternalMessageDialog(null, ex.getMessage());
                }
            }
    }
    @Override
    public void update(Student t, String imagePath) {
       db.update(t, imagePath);
    }
    @Override
    public void delete(Student t) {
        db.delete(t);
    }
    @Override
    public List<Student> listAll() {
        return db.listAll();
    }
}
