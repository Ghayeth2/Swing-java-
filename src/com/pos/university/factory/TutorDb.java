/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.factory;

import com.pos.university.dao.TutorDAO;
import com.pos.university.dao.TutorDAOimp;

/**
 *
 * @author LENOVO
 */
public class TutorDb {
    private final static TutorDAO db = new TutorDAOimp();
    
    public static TutorDAO createTutorDAOimp(){
        return db;
    }
    private TutorDb(){}
}
