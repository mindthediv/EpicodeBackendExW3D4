package com.w3d4;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO extends Partecipazione {
    private static EntityManager em =  JpaUtil.getEntityManagerFactory().createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public PartecipazioneDAO(Persona persona, Evento evento, com.w3d4.stato stato) {
        super(persona, evento, stato);
    }

        public static void save(Partecipazione par) {
            transaction.begin();
            em.persist(par);
            transaction.commit();
        }
    
     // - getPartecipazioniDaConfermarePerEvento(Evento evento)
}
