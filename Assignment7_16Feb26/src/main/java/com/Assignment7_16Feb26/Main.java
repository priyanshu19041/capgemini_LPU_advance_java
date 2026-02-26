package com.Assignment7_16Feb26;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = new User("Khasim", "pass123", "khasim@gmail.com");
        em.persist(user);

        Post post = new Post("Hibernate JPA", "Unidirectional Mapping", user);
        em.persist(post);

        Comment comment = new Comment("Very useful post", post, user);
        em.persist(comment);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}