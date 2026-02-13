package com.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class StudentDAO {

    public void saveStudent(Student student) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(student);
        tx.commit();

        em.close();
    }

    public Student findStudentById(int id) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();
        Student s = em.find(Student.class, id);
        em.close();
        return s;
    }

    public List<Student> findAllStudents() {
        EntityManager em = JPAUtil.getFactory().createEntityManager();

        List<Student> list =
                em.createQuery("from Student", Student.class)
                  .getResultList();

        em.close();
        return list;
    }

    public void updateStudent(Student student) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(student);
        tx.commit();

        em.close();
    }

    public void deleteStudent(int id) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Student s = em.find(Student.class, id);

        if (s != null) {
            tx.begin();
            em.remove(s);
            tx.commit();
        }

        em.close();
    }

    public long studentCount() {
        EntityManager em = JPAUtil.getFactory().createEntityManager();

        long count =
                em.createQuery("select count(s) from Student s", Long.class)
                  .getSingleResult();

        em.close();
        return count;
    }
}
