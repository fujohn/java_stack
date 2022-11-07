package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    
    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id, String role) {
    	super(id);
    	this.role = role;
    	this.securityIncidents = new ArrayList<String>();
    }
    
    // TO DO: Implement HIPAACompliantUser!    
    @Override
	public boolean assignPin(int pin) {
		if (String.valueOf(pin).length() >= 6) {
			this.pin = pin;
			return true;
		}
		return false;
	}

    @Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (this.id == confirmedAuthID) {
			return true;
		}
		this.authIncident();
		return false;
		
	}
    
    
    // TO DO: Implement HIPAACompliantAdmin!
    @Override
	public ArrayList<String> reportSecurityIncidents(){
		return securityIncidents;
	}
    
    
	public String getRole() {
		return role;
	}

    

    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        this.securityIncidents.add(report);
    }
    
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        this.securityIncidents.add(report);

    }
}
