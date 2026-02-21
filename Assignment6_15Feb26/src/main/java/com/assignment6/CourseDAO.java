package com.assignment6;


import jakarta.persistence.EntityManager;

import java.util.List;

public class CourseDAO {

    public void saveCourse(Course course) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    public Course findCourse(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Course c = em.find(Course.class, id);
        em.close();
        return c;
    }

    public List<Course> findByInstructor(Instructor instructor) {
        return instructor.getCourses();
    }
}