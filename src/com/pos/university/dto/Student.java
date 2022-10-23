/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.dto;

import com.pos.university.commons.Man;

/**
 *
 * @author LENOVO
 */
public class Student extends Man{
    // date, stdNumber, dept, faculty, course belong to a student 
    private String date;
    private long stdNumber;
    // Applying Composition
    private Department dept ;
    private Course course;
    private Faculty faculty;
    
    @Override
    public void setImage(byte[] image) {
        super.setImage(image);
    }
    public void setIdStudent(int id) {
        super.setId(id);
    }
    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }
    
    public long getStdNumber() {
        return stdNumber;
    }

    public void setStdNumber(long stdNumber) {
        this.stdNumber = stdNumber;
    }
    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }
    @Override
    public void setGender(String gender) {
        super.setGender(gender);
    }
    
    // Applying inheritance between siblings (Composition)
    // Instead of taking all attributes in that class
    // We take only the wanted ones
    // As known @override when class inherit from another one

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    
}
