package com.practice;

import javax.persistence.*;

public class Demo {
    public static void main(String args[]) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Student s = new Student();
        s.setId(1);
        s.setName("Basha ludo");
        s.setPercentage(80);

        et.begin();
        em.persist(s);
        et.commit();

        em.close();
        emf.close();

//        System.out.println("Student inserted successfully!");
    }
}
