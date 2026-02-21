package com.assignment6;

import jakarta.persistence.EntityManager;

public class InstructorDAO {

    public void saveInstructor(Instructor instructor) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(instructor);
        em.getTransaction().commit();
        em.close();
    }
    public Instructor findInstructor(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Instructor i = em.find(Instructor.class, id);
        if (i != null) {
            i.getCourses().size();
        }
        em.close();
        return i;
    }
    public void updateInstructor(Instructor instructor) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(instructor);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteInstructor(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Instructor i = em.find(Instructor.class, id);
        em.remove(i);
        em.getTransaction().commit();
        em.close();
    }
}