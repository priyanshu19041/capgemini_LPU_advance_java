package com.student;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("studentPU");

    public static EntityManagerFactory getFactory() {
        return emf;
    }

    public static void close() {
        emf.close();
    }
}
