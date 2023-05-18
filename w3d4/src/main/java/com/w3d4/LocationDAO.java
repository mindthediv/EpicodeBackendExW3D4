package com.w3d4;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO extends Location{
    private static EntityManager em =  JpaUtil.getEntityManagerFactory().createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public LocationDAO(String nome, String citta) {
        super(nome, citta);
    }

    public static void save(Location loc){
        try{
        transaction.begin();
        em.persist(loc);
        transaction.commit();
        } finally {
        em.close();
        }
    }
    
}
