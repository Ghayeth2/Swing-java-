/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pos.university.commons;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface UniversityBAO <T>{
    public void save(T t);
    public void update(T t);
    public void delete(T t);
    public List <T> listAll();
}
