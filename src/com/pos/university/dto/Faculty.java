/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.dto;

import com.pos.university.commons.Dept_Faculty;
import java.security.cert.PKIXRevocationChecker;

/**
 *
 * @author LENOVO
 */
public class Faculty extends Dept_Faculty{
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setId(int id) {
        super.setId(id);
    }

    public void setName(String name) {
        super.setName(name);
    }
}
