
package com.assignment5;

import jakarta.persistence.*;

public class JPAUtil {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
