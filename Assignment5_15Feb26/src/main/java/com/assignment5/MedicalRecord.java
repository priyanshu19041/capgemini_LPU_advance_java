package com.assignment5;

import jakarta.persistence.*;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue
    private int id;
    private String bloodGroup;
    private String allergies;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

}