package fintech.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Fintech.Customer;
import Fintech.Main.JPAUtil;

public class CustomerDAO {

    public void save(Customer customer) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        em.close();
    }

    public Customer findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Customer customer = em.find(Customer.class, id);
        em.close();
        return customer;
    }

    public List<Customer> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Customer> query =
                em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> list = query.getResultList();
        em.close();
        return list;
    }

    public Customer findByEmail(String email) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Customer> query =
                em.createQuery("SELECT c FROM Customer c WHERE c.email = :email", Customer.class);
        query.setParameter("email", email);
        Customer customer;
        try {
            customer = query.getSingleResult();
        } catch (Exception e) {
            customer = null;
        }
        em.close();
        return customer;
    }

    public void update(Customer customer) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Customer customer = em.find(Customer.class, id);
        if (customer != null) {
            em.remove(customer);
        }
        em.getTransaction().commit();
        em.close();
    }
}