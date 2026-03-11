package com.Assignment10;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CRUDTest4 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//persist with prescription
		
		Appointment apt1 = new Appointment();
		apt1.setAppointDate(LocalDateTime.now());
		apt1.setStatus("Completed");
		apt1.setReason("Fever");
		
		Prescription p1 = new Prescription();
		p1.setMedicines("Dolo");
		p1.setDosage("Daily twice");
		p1.setIssuedDate(LocalDate.now());
		p1.setActive(true);
		
		apt1.setPrescription(p1);
		et.begin();
		em.persist(apt1);
		et.commit();
		
		
		//persist without prescription
		
		Appointment apt2 = new Appointment();
		apt2.setAppointDate(LocalDateTime.now().plusDays(1));
		apt2.setStatus("Scheduled");
		apt2.setReason("Checkup");
		
		et.begin();
		em.persist(apt2);
		et.commit();
	}

}