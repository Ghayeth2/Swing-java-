/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.university.commons;

/**
 *
 * @author LENOVO
 */
public class BAOExciption extends Exception{
    public BAOExciption() {
    }
    
    public BAOExciption(String message){
        super(message);
    }
    
    public BAOExciption(String message,Throwable cause){
        super(message, cause);
    }
    
    public BAOExciption (Throwable cause){
        super(cause);
    }
}
