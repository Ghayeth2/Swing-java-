/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.factory;

import com.pos.university.dao.FacultyDAO;
import com.pos.university.dao.FacultyDAOimp;

/**
 *
 * @author LENOVO
 */
public class FacultyDb {
    public FacultyDAO createFacultyDAOimp(){
        return new FacultyDAOimp();
    }
}
