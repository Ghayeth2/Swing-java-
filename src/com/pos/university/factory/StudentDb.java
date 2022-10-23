/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.factory;

import com.pos.university.dao.StudentDAO;
import com.pos.university.dao.StudentDAOimp;

/**
 *
 * @author LENOVO
 */
public class StudentDb {
    // Singleton + Factory Design Patterns Implementation
    private static final StudentDAO dtb = new StudentDAOimp();
    public static StudentDAO creaStudentDAOimp (){
        return dtb;
    }

    private StudentDb() {
    }
    
}
