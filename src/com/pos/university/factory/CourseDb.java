/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.factory;

import com.pos.university.dao.CourseDAO;
import com.pos.university.dao.CourseDAOimp;
import com.pos.university.dto.Course;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CourseDb {
    public CourseDAO createCourseDAOimp(){
        return new CourseDAOimp();
    }
}
