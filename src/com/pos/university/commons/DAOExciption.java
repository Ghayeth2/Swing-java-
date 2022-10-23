/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.commons;

/**
 *
 * @author LENOVO
 */
public class DAOExciption extends Exception{
    public DAOExciption() {
    }
    
    public DAOExciption(String message){
        super(message);
    }
    
    public DAOExciption(String message,Throwable cause){
        super(message, cause);
    }
    
    public DAOExciption (Throwable cause){
        super(cause);
    }
}
