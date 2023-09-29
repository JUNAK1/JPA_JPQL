package com.uptc.frw.persistence;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtil {
    private static EntityManagerFactory MY_ENTITY_MANAGER_FACTORY;

    public static EntityManager getEntityManager() {
        if (MY_ENTITY_MANAGER_FACTORY == null) {
            MY_ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("MUEBLES");
        }
        return MY_ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}