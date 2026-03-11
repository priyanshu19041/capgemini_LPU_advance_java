package CRM.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import CRM.application.Customer;
import CRM.application.JPAUtil;
import CRM.application.OrderEntity;
import CRM.application.Product;

public class OrderService {
    public void placeOrder(Long customerId, List<Long> productIds) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Customer c = em.find(Customer.class, customerId);
        List<Product> products = new ArrayList<>();
        double total = 0;

        for (Long id : productIds) {
            Product p = em.find(Product.class, id);
            products.add(p);
            total += p.getPrice();
        }

        OrderEntity o = new OrderEntity();
        o.setCustomer(c);
        o.setProducts(products);
        o.setOrderDate(LocalDate.now());
        o.setTotalAmount(total);

        em.persist(o);
        em.getTransaction().commit();
        em.close();
    }
}
