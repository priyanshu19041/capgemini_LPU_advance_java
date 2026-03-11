package com.Assignment10;


import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CRUDTest1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//To insert
		MedicalRecord record = new MedicalRecord();
		record.setRecordDate(LocalDate.now());
		record.setDiagnosis("Flu");
		record.setNotes("Rest 3 days");
		
		
		Patient patient = new Patient();
		patient.setName("neha");
		patient.setDob(LocalDate.of(2005, 2, 27));
		patient.setBloodGroup("O+");
		patient.setPhone("9876543210");
		patient.setMedicalRecord(record);
		
		et.begin();
		em.persist(patient);
		et.commit();
		
		System.out.println("Patient added " + patient.getId());
		
		
		//To read
		Patient p = em.find(Patient.class, patient.getId());
		System.out.println(p.getMedicalRecord().getDiagnosis());
		
		
		//To update
		et.begin();
		p.getMedicalRecord().setNotes("Updated: Follow up required");
		et.commit();
		System.out.println("Record updated");
		
		
		//To dalete
		et.begin();
		em.remove(p);
		et.commit();System.out.println("Patient deleted");
		
		
	}

}