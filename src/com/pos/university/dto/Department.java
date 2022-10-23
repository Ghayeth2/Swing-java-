/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.dto;

import com.pos.university.commons.Dept_Faculty;
import com.pos.university.commons.Floor;

/**
 *
 * @author LENOVO
 */
public class Department extends Dept_Faculty{
    private Integer floor;
    private Faculty faculty;

    public int getFloor() {
        return floor;
    }
    String fly = null;
    public void setFloor(Floor floor) {
        this.floor = floor.getNumeric();
    }
    @Override
    public void setId(int id) {
        super.setId(id);
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
