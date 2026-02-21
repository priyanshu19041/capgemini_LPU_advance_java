package com.assignment6;
import jakarta.persistence.EntityManager;

public class InstructorProfileDAO {

    public void saveProfile(InstructorProfile profile) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(profile);
        em.getTransaction().commit();
        em.close();
    }
}