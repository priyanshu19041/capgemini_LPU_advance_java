package com.CaseStudy1DAO;

import com.CaseStudy1.Profile;
import jakarta.persistence.*;

public class ProfileDAO {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Assignment3PU");

    public void saveProfile(Profile profile) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(profile);
        tx.commit();
        em.close();
    }

    public Profile findProfile(Long id) {
        EntityManager em = emf.createEntityManager();
        Profile p = em.find(Profile.class, id);
        em.close();
        return p;
    }
}