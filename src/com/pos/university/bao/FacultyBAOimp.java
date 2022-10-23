/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.bao;

import com.pos.university.commons.BAOExciption;
import com.pos.university.dao.FacultyDAO;
import com.pos.university.dto.Faculty;
import com.pos.university.factory.FacultyDb;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class FacultyBAOimp implements FacultyBAO{
    // Only Factory Design Pattern is applied
    private FacultyDAO data = new FacultyDb().createFacultyDAOimp();

    @Override
    public void save(Faculty t) {
        
        // Exciption if it were from DAO layer then it should appear from here
        // too, because it is the connecting point.
        // Therefore, the functions in DAO should be Integer or Boolean not 
        // void()
         if(t.getId() == 0)
           data.save(t); 
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
    public void update(Faculty t) {
        data.update(t);
    }
JFrame jFrame;
    @Override
    public void delete(Faculty t) {
        
        // Exciption if it were from DAO layer then it should appear from here
        // too, because it is the connecting point.
        // Therefore, the functions in DAO should be Integer or Boolean not 
        // void()
        JFrame jFrame = new JFrame();
        if(JOptionPane.showConfirmDialog(jFrame, "Delete "+t.getName()+" ?", "BAO delete confirmation", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION){
            if(t.getId() == 0){
            try {
                throw new BAOExciption("Attempting to delete non-existing item");
            } catch (BAOExciption ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        data.delete(t);
        }
    }

    @Override
    public List<Faculty> listAll() {
        return data.listAll();
    }
    
}
