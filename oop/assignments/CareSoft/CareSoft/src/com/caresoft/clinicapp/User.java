package com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected int pin;
    
    // TO DO: Getters and setters
    public Integer getId() {
    	return id;
    }
    
    public int getPin() {
    	return pin;
    }
    
    
    
    // Implement a constructor that takes an ID
    public User(Integer id) {
    	this.id = id;
    }
}
