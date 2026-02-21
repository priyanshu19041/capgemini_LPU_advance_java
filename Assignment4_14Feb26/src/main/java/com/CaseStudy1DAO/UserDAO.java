package com.CaseStudy1DAO;
import com.CaseStudy1.User;
import jakarta.persistence.*;

public class UserDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Assignment3PU");

    public void saveUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(user);
        tx.commit();
        em.close();
    }

    public User findUser(Long id) {
        EntityManager em = emf.createEntityManager();
        User u = em.find(User.class, id);
        em.close();
        return u;
    }
}