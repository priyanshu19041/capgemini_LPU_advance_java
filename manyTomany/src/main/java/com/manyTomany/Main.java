package com.manyTomany;

import javax.persistence.*;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("studentPU");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Subjects
        Subject sub1 = new Subject("Java", 30);
        Subject sub2 = new Subject("Spring", 25);
        Subject sub3 = new Subject("Database", 20);
        Subject sub4 = new Subject("React", 22);

        em.persist(sub1);
        em.persist(sub2);
        em.persist(sub3);
        em.persist(sub4);

        // Students
        Student st1 = new Student(
                "Rahul", "Male", "CSE",
                Arrays.asList(sub1, sub2, sub3, sub4));

        Student st2 = new Student(
                "Anita", "Female", "IT",
                Arrays.asList(sub1, sub2, sub3, sub4));

        em.persist(st1);
        em.persist(st2);

        tx.commit();

        em.close();
        emf.close();

        System.out.println("Data Inserted Successfully!");
    }
}
