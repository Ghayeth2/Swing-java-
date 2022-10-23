/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.bao;

import com.pos.university.commons.BAOExciption;
import com.pos.university.dao.CourseDAO;
import com.pos.university.dto.Course;
import com.pos.university.factory.CourseDb;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class CourseBAOimp implements CourseBAO{
    private CourseDAO db = new CourseDb().createCourseDAOimp();
    
     // Exciption if it were from DAO layer then it should appear from here
        // too, because it is the connecting point.
        // Therefore, the functions in DAO should be Integer or Boolean not 
        // void()

    @Override
    public void save(Course t) {
        if(t.getId() == 0)
           db.save(t); 
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
    public void update(Course t) {
        db.update(t);
    }

    @Override
    public void delete(Course t) {
        if(t.getId() == 0){
            try {
                throw new BAOExciption("Attempting to delete non-existed item");
            } catch (BAOExciption ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage()+" "+ex.getClass(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public List<Course> listAll() {
        return db.listAll();
    }
}
