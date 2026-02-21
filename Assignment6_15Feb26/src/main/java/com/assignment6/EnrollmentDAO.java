package com.assignment6;


import jakarta.persistence.EntityManager;

public class EnrollmentDAO {

    public void saveEnrollment(Enrollment enrollment) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(enrollment);
        em.getTransaction().commit();
        em.close();
    }

    public void updateGrade(Long id, String grade) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Enrollment e = em.find(Enrollment.class, id);
        e.setGrade(grade);
        em.getTransaction().commit();
        em.close();
    }
}