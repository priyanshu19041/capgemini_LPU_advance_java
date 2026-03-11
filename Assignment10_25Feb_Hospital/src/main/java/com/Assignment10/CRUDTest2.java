package com.Assignment10;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CRUDTest2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Department cardio = new Department();
        cardio.setName("Cardiology");
        cardio.setLocation("Block A");
        cardio.setHeadDoctorName("Dr. Heart");

        Department neuro = new Department();
        neuro.setName("Neurology");
        neuro.setLocation("Block B");
        neuro.setHeadDoctorName("Dr. Brain");

        Doctor d1 = new Doctor();
        d1.setName("Dr. Smith");
        d1.setSpecialization("Cardio Specialist");
        d1.setLicenseNo("LIC101");
        
        Doctor d2 = new Doctor();
        d2.setName("Dr. John");
        d2.setSpecialization("Cardio Surgeon");
        d2.setLicenseNo("LIC102");

        Doctor d3 = new Doctor();
        d3.setName("Dr. Alice");
        d3.setSpecialization("Neuro Specialist");
        d3.setLicenseNo("LIC201");

        Doctor d4 = new Doctor();
        d4.setName("Dr. Bob");
        d4.setSpecialization("Neuro Surgeon");
        d4.setLicenseNo("LIC202");
        
        cardio.addDoctor(d1);
        cardio.addDoctor(d2);

        neuro.addDoctor(d3);
        neuro.addDoctor(d4);
        
        et.begin();
        em.persist(cardio);
        em.persist(neuro);
        et.commit();
        
        
        Department loadedDept = em.find(Department.class, cardio.getId());
        loadedDept.getDoctors().forEach(doc -> System.out.println(doc.getName()));
        
        Doctor loadedDoctor = em.find(Doctor.class, d1.getId());
        
        System.out.println(loadedDoctor.getDepartment().getName());
        
        et.begin();
        cardio.removeDoctor(d1);
        neuro.addDoctor(d1);
        et.commit();
        
        
        TypedQuery<Doctor> query = em.createQuery("Select d from doctor d where d.department.name = :dname", Doctor.class);
        query.setParameter("dname", "Cardiology");
        List<Doctor> cardioDoctors = query.getResultList();
        cardioDoctors.forEach(doc->System.out.println(doc.getName()));
	}

}