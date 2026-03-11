package CRM.Service;

import javax.persistence.EntityManager;

import CRM.application.Address;
import CRM.application.Customer;
import CRM.application.JPAUtil;

public class CustomerService {
    public void registerCustomer(String name, String email, String phone) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        c.setPhone(phone);

        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }

    public void addAddressToCustomer(Long id, Address address) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Customer c = em.find(Customer.class, id);
        c.setAddress(address);

        em.getTransaction().commit();
        em.close();
    }
}