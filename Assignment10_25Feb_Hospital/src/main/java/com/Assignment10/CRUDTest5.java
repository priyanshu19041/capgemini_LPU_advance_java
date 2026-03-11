package com.Assignment10;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CRUDTest5 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Doctor d1 = new Doctor();
		d1.setName("Dr. Mehta");
		d1.setSpecialization("Cardiology");
		
		Doctor d2 = new Doctor();
		d2.setName("Dr. Singh");
		d2.setSpecialization("Neurology");
		
		Patient p1 = new Patient();
		p1.setName("Ali");
		
		Patient p2 = new Patient();
		p2.setName("Priya");
		
		Patient p3 = new Patient();
		p3.setName("Raj");
		
		
		d1.addPatient(p1);
		d1.addPatient(p2);
		
		d2.addPatient(p1);
		d2.addPatient(p3);
		
		et.begin();
		em.persist(d1);
		em.persist(d2);
		et.commit();
		
		
		TypedQuery<Doctor> query = em.createQuery("select d from Doctor d join fetch d.patients where d.name=:n", Doctor.class);
		query.setParameter("n", "Dr. Mehta");
		Doctor loadedMehta = query.getSingleResult();
		
		loadedMehta.getPatients().forEach(p->System.out.println(p.getName()));
		
		
		//reverse query
		TypedQuery<Patient> reverseQuery = em.createQuery("select p from Patient p join fetch p.doctors where p.name=:name", Patient.class);
		reverseQuery.setParameter("name", "Ali");
		Patient loadedAli = reverseQuery.getSingleResult();
		loadedAli.getDoctors().forEach(d->System.out.println(d.getName()));
		
		
		
		et.begin();
		loadedMehta.removePatient(loadedAli);
		et.commit();
	}

}