/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.bao;

import com.pos.university.commons.BAOExciption;
import com.pos.university.dao.DepartmentDAO;
import com.pos.university.dto.Department;
import com.pos.university.factory.DepartmentDb;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class DepartmentBAOimp implements DepartmentBAO{
    // Creating database object from middle class
    private DepartmentDAO db = DepartmentDb.cDepartmentDAOimp();

    @Override
    public void save(Department t) {
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
    public void update(Department t) {
        db.update(t);
    }

    @Override
    public void delete(Department t) {
        db.delete(t);
    }

    @Override
    public List<Department> listAll() {
        return db.listAll();
    }
    
}
