/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.constants;

/**
 *
 * @author LENOVO
 */
public class SQLStatements {
    public final static String allFaculties = "SELECT * FROM university.faculty";
    public final static String allDepts = "SELECT department.id, department.namew, department.facuId, faculty.name"
    +"FROM university.department join faculty on faculty.id = department.facuId;";
    public final static String allCourses = "SELECT course.id, course.name, course.deptId, department.namew"
    +"FROM university.course join department on department.id = course.deptId;";
    public final static String allTutors = "SELECT t.id, t.firstName, t.lastName, t.address," 
    +"    t.email, t.image,d.id, d.namew,c.id, c.name,f.id, f.name " 
    +"	FROM university.tutor t INNER JOIN department d ON d.id = t.deptId "
    +"                INNER JOIN course c ON c.id = t.courseId" 
    +"                 inner join faculty f on f.id = t.facuId;";
    public final static String allStudents = "SELECT * FROM university.student INNER JOIN department ON department.id = student.deptId "
                + "INNER JOIN course ON course.id = student.courseId"
                + " inner join faculty on faculty.id = student.facuId;";

}
