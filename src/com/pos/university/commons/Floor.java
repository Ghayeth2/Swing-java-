/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.commons;

/**
 *
 * @author LENOVO
 */
public enum Floor {
    BASEMENT(-1),
    GROUND(0),
    FIRST(1),
    SECOND(2),
    THIRD(3);
    
    private int numeric;

    private Floor(int numeric) {
        this.numeric = numeric;
    }
    public int getNumeric(){
        return numeric;
    }
            
}
