/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.dto;

import com.pos.university.commons.Man;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class Tutor extends Man{
    
    // address, dept, faculty, course attributes are not shared with everyone
    private String address;
    private Department dept;
    private Faculty faculty;
    private Course course;
    
    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tutor other = (Tutor) obj;
        return Objects.equals(this.address, other.address);
    }
    
    // Calling setters in parent class
    @Override
    public void setImage(byte[] image) {
        super.setImage(image); 
    }
    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }
    @Override
    public void setId(int id) {
        super.setId(id);
    }
    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }
    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
