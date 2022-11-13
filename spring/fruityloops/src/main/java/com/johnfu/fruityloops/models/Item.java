package com.johnfu.fruityloops.models;

public class Item {
    
    // MEMBER VARIABLES
    private String name;
    private double price;
    
    // CONSTRUCTOR
    public Item(String name, double price) {
    	this.name = name;
    	this.price = price;
    }
    
    // As always, don't forget to generate Getters and Setters!
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
}



