package com.Assignment10;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CRUDTest3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Doctor doctor = new Doctor();
        doctor.setName("Dr. Kumar");
        doctor.setSpecialization("General Physician");
        doctor.setLicenseNo("LIC500");

        Appointment a1 = new Appointment();
        a1.setAppointDate(LocalDateTime.now().plusDays(1));
        a1.setStatus("SCHEDULED");
        a1.setReason("Fever");

        Appointment a2 = new Appointment();
        a2.setAppointDate(LocalDateTime.now().minusDays(1));
        a2.setStatus("COMPLETED");
        a2.setReason("Checkup");

        Appointment a3 = new Appointment();
        a3.setAppointDate(LocalDateTime.now().plusDays(3));
        a3.setStatus("CANCELLED");
        a3.setReason("Consultation");
        
        doctor.getAppointments().add(a1);
        doctor.getAppointments().add(a2);
        doctor.getAppointments().add(a3);
        
        et.begin();
        em.persist(doctor);
        et.commit();
        
        Doctor doc = em.find(Doctor.class, 1L);
        
        et.begin();
        for(Appointment apt : doc.getAppointments()) {
        	if(apt.getStatus().equals("scheduled")) {
        		apt.setStatus("Completed");
        	}
        }
        et.commit();
        
	}

}