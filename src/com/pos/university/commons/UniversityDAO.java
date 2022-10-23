/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pos.university.commons;

import com.pos.university.dto.Student;
import java.util.List;

/**
 *
 * @author LENOVO
 *  public Integer save(T c);
    public Integer delete(int id);
    public Integer update(T c);
    public List <T> listAll();
    public T getType(T c);
    public List <T> searchBy(Map <Integer , String> map,int i);
 */
public interface UniversityDAO <T>{
    public void save(T t);
    public void update(T t);
    public void delete(T t);
    public List <T> listAll();
}
