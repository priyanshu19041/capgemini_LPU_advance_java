package com.assignment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	private int StudentId;
	private String name;
	private String email;
	private String branch;
	@OneToOne
	private AadharCard aadharcard;
	@OneToOne
	private HostelRoom hostelroom;
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public AadharCard getAadharcard() {
		return aadharcard;
	}
	public void setAadharcard(AadharCard aadharcard) {
		this.aadharcard = aadharcard;
	}
	public HostelRoom getHostelroom() {
		return hostelroom;
	}
	public void setHostelroom(HostelRoom hostelroom) {
		this.hostelroom = hostelroom;
	}
	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", name=" + name + ", email=" + email + ", branch=" + branch + "]";
	}
	
}
