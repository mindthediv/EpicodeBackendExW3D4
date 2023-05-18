package com.w3d4;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.w3d4.Concerto.genere;

public class EventoDAO extends Evento{
    private static EntityManager em =  JpaUtil.getEntityManagerFactory().createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();
    public EventoDAO(String titolo, String dataEvento, String descrizione, com.w3d4.tipoEvento tipoEvento,int numeroMassimoPartecipanti, Location location) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
    }

    public static void save(Evento ev){
        transaction.begin();
        em.persist(ev);
        transaction.commit();
    }

    public static void getConcertiInStreaming(boolean b){
        try{
            if(b){
            Query q = em.createQuery("SELECT c FROM eventi c WHERE in_streaming = true");
            List<Concerto> concertiInStreaming = q.getResultList();
            System.out.println("concerti in streaming: " + concertiInStreaming.toString());
            } else {
            Query q = em.createQuery("SELECT c FROM eventi c WHERE in_streaming = false");
            List<Concerto> concertiNonStreaming = q.getResultList();
            System.out.println("concerti non in streaming: " + concertiNonStreaming.toString());   
            }
        } finally {
            em.close();
        }
    }

    public static void getConcertiPerGenere(genere genere){
        try{
            if(genere == genere.CLASSICO){
                Query q = em.createQuery("SELECT c FROM eventi c WHERE genere = 'CLASSICO'");
                List<Concerto> concerti = q.getResultList();
                System.out.println("concerti classici: " + concerti.toString());
                } else if (genere == genere.ROCK) {
                Query q = em.createQuery("SELECT c FROM eventi c WHERE genere = 'ROCK'");
                List<Concerto> concerti = q.getResultList();
                System.out.println("concerti rock: " + concerti.toString());   
                } else if (genere == genere.POP){
                Query q = em.createQuery("SELECT c FROM eventi c WHERE genere = 'POP'");
                List<Concerto> concerti = q.getResultList();
                System.out.println("concerti pop: " + concerti.toString());   
                } 
            
        } finally {
            em.close();
        }
    }

        // - getPartiteVinteInCasa
        public static List<PartitaDiCalcio> getPartiteVinteInCasa(){
            Query q = em.createNamedQuery("vinteInCasa");
            List set =  q.getResultList();
            return set;
        }
        // - getPartiteVinteInTrasferta
        public static List<PartitaDiCalcio> getPartiteVinteInTrasferta(){
            Query q = em.createNamedQuery("vinteInTrasferta");
            List<PartitaDiCalcio> set =  q.getResultList();
            return set;
        }
        // - getPartitePareggiate
        public static List<PartitaDiCalcio> getPareggi(){
            Query q = em.createNamedQuery("pareggi");
            List<PartitaDiCalcio> set =  q.getResultList();
            return set;
        }
        // - getGareDiAtleticaPerVincitore(Persona vincitore)
        public static List<GaraDiAtletica> getVittorieAt(Persona vinc){
            Query q = em.createNamedQuery("vittorieAt");
            q.setParameter("vincitore", vinc);
            List<GaraDiAtletica> set =  q.getResultList();
            return set;
        }
        // - getGareDiAtleticaPerPartecipante(Persona partecipante)
        public static List<GaraDiAtletica> getParAtletica(Persona par){
            Query q = em.createNamedQuery("parGareAtletica");
            q.setParameter("partecipante", par);
            List<GaraDiAtletica> set =  q.getResultList();
            return set;
        }
        // - getEventiSoldOut [in cui il numero di partecipanti è = numeromassimopartecipanti]
        public static List<Evento> getSoldOut(){
            Query q = em.createNamedQuery("soldOut");
            List<Evento> set =  q.getResultList();
            return set;
        }
        
    
}
