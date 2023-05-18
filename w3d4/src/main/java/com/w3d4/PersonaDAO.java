package com.w3d4;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO extends Persona {
    private static EntityManager em =  JpaUtil.getEntityManagerFactory().createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public PersonaDAO(String nome, String cognome, String email, String dataNascita, com.w3d4.sesso sesso,
            List<Partecipazione> listaPartecipazioni) {
        super(nome, cognome, email, dataNascita, sesso);
    }

    public static void save(Persona pp){
        transaction.begin();
        em.persist(pp);
        transaction.commit();
    }
    
}
