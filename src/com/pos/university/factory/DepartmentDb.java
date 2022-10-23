/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.factory;

import com.pos.university.dao.DepartmentDAO;
import com.pos.university.dao.DepartmentDAOimp;

/**
 *
 * @author LENOVO
 */
public class DepartmentDb {
    private static final DepartmentDAO db = new DepartmentDAOimp();
    
    public static DepartmentDAO cDepartmentDAOimp(){
        return db;
    }
    private DepartmentDb(){
        
    }
}
