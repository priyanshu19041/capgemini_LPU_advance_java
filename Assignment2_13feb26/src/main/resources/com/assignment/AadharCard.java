package com.assignment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AadharCard {
	@Id
	private int aadharId;
	private long aadharNumber;
	private String address;
	private String issueDate;
	public int getAadharId() {
		return aadharId;
	}
	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	@Override
	public String toString() {
		return "AadharCard [aadharId=" + aadharId + ", aadharNumber=" + aadharNumber + ", address=" + address
				+ ", issueDate=" + issueDate + "]";
	}
	
}