package com.safetynet.safetynetalerts.model;

import lombok.Data;

@Data
public class Firestation {
		
	private String address;
	
	private int station;
	
	
	public void updateFirestation (Firestation updatedFirestation) {
		this.address = updatedFirestation.getAddress();
		this.station = updatedFirestation.getStation();

	}
	
}
