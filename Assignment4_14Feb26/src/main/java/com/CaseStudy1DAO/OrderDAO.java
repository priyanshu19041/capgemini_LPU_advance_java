package com.CaseStudy1DAO;

import com.CaseStudy1.PurchaseOrder;
import jakarta.persistence.*;

public class OrderDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Assignment3PU");

    public void saveOrder(PurchaseOrder order) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(order);
        tx.commit();
        em.close();
    }
}