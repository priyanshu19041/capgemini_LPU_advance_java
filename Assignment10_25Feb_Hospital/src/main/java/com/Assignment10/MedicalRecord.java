package com.Assignment10;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate recordDate;
	private String diagnosis;
	private String notes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(LocalDate recordDate) {
		this.recordDate = recordDate;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "MedicalRecord [id=" + id + ", recordDate=" + recordDate + ", diagnosis=" + diagnosis + ", notes="
				+ notes + "]";
	}
}