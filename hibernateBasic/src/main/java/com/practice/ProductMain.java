package com.practice;

import javax.persistence.*;

public class ProductMain {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Product p = new Product();
        p.setId(1);
        p.setName("Laptop");
        p.setQuality("High");
        p.setPrice(65000);

        et.begin();
        em.persist(p);
        et.commit();
        System.out.println("Product Inserted");

        et.begin();
        Product updateProduct = em.find(Product.class, 1);
        if (updateProduct != null) {
            updateProduct.setPrice(60000);
        }
        et.commit();
        System.out.println("Product Updated");

        et.begin();
        Product deleteProduct = em.find(Product.class, 1);
        if (deleteProduct != null) {
            em.remove(deleteProduct);
        }
        et.commit();
        System.out.println("Product Deleted");

        em.close();
        emf.close();
    }
}
