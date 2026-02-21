package com.CaseStudy1DAO;
import com.CaseStudy1.Payment;
import jakarta.persistence.*;

public class PaymentDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Assignment3PU");

    public void savePayment(Payment payment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(payment);
        tx.commit();
        em.close();
    }
}