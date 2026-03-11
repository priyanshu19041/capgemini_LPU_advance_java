package CRM.Service;

import javax.persistence.EntityManager;

import CRM.application.JPAUtil;
import CRM.application.Product;

public class ProductService {
    public void addProduct(String name, double price) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);

        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }
}