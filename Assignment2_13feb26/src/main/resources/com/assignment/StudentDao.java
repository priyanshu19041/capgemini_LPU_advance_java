package com.assignment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class StudentDao {
	public static void main(String[] args) {
//		InsertStudent();
		deleteStudent();
	}
	public static void InsertStudent() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		AadharCard a=new AadharCard();
		a.setAadharId(2);
		a.setAadharNumber(223421343112L);
		a.setAddress("Hyderabad");
		a.setIssueDate("1March2005");
		HostelRoom hr=new HostelRoom();
		hr.setRoomId(2);
		hr.setRoomNumber(309);
		hr.setBlockName("B-Block");
		hr.setFloorNumber(4);
		Student s=new Student();
		s.setStudentId(2);
		s.setName("KhasimBasha");
		s.setEmail("khasimbasha@gmail.com");
		s.setBranch("CSE");
	
		et.begin();
		em.persist(a);
		em.persist(hr);
		s.setAadharcard(a);
		s.setHostelroom(hr);
		em.persist(s);
		et.commit();	
	}
	public static void deleteStudent() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		Student s = em.find(Student.class, 1);
		em.remove(s);
		
		et.commit();
	}
}