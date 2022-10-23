/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.bao;

import com.pos.university.commons.BAOExciption;
import com.pos.university.dao.TutorDAO;
import com.pos.university.dto.Tutor;
import com.pos.university.factory.TutorDb;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class TutorBAOimp implements TutorBAO{
    private TutorDAO dtb = TutorDb.createTutorDAOimp();
    @Override
    public void save(Tutor t, String imagePath) {
         if(t.getId() == 0)
           dtb.save(t, imagePath); 
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
    public void update(Tutor t, String imagePath) {
        dtb.update(t, imagePath);
    }

    @Override
    public void delete(Tutor t) {
        dtb.delete(t);
    }

    @Override
    public List<Tutor> listAll() {
        return dtb.listAll();
    }
    
}
