package com.w3d4;

import java.util.HashSet;

import java.util.Set;

import com.w3d4.Concerto.genere;

public final class GestioneEventi {
    public static void main(String[] args) {
        Location irishPub = new Location("Irish Pub", "Roma");
        Location stadioSanSiro = new Location("Stadio San Siro", "Milano");
        Persona mario = new Persona("Mario", "Rossi", "mrossi@gmail.com", "21/01/1996", sesso.MASCHIO);
        Persona atAt = new Persona("Sara", "Bianchi", "sbianchi@gmail.com", "02/09/2000", sesso.FEMMINA);
        // Evento ev = new Evento("festa di Luca", "11/08/2023", "festa all'Irish pub", tipoEvento.PRIVATO, 30, irishPub);
        PartitaDiCalcio milan_juve = new PartitaDiCalcio("Milan vs Juventus", "11/08/2023", "finale di campionato", tipoEvento.PUBBLICO, 60000, stadioSanSiro, "Milan", "Juventus", 2,1 );
        GaraDiAtletica atCup = new GaraDiAtletica("atCup", "07/06/2024", "coppa di atletica", tipoEvento.PUBBLICO, 7000, stadioSanSiro );
        Set<Persona> setAtleti = new HashSet<Persona>();
        setAtleti.add(atAt);
        setAtleti.add(mario);
        atCup.setSetAtleti(setAtleti);
        atCup.setVincitore(atAt);
        // mario.partecipa(ev);
        Concerto concertopop1 = new Concerto("concertopop1", "21/08/2020", "desc", tipoEvento.PUBBLICO, 60000, stadioSanSiro);
        concertopop1.setGenere(genere.POP);
        concertopop1.setInStreaming(true);
        Concerto concertopop2 = new Concerto("concertopop2", "24/08/2020", "desc", tipoEvento.PUBBLICO, 60000, stadioSanSiro);
        concertopop2.setGenere(genere.POP);
        concertopop2.setInStreaming(false);
        Concerto concertorock1 = new Concerto("concertorock1", "21/08/2020", "desc", tipoEvento.PUBBLICO, 60000, stadioSanSiro);
        concertorock1.setGenere(genere.ROCK);
        concertorock1.setInStreaming(true);
        Concerto concertorock2 = new Concerto("concertorock2", "24/08/2020", "desc", tipoEvento.PUBBLICO, 60000, stadioSanSiro);
        concertorock2.setGenere(genere.ROCK);
        concertorock2.setInStreaming(false);
        Concerto concertoclassico1 = new Concerto("concertoclassico1", "21/08/2020", "desc", tipoEvento.PUBBLICO, 60000, stadioSanSiro);
        concertoclassico1.setGenere(genere.CLASSICO);
        concertoclassico1.setInStreaming(true);
        Concerto concertoclassico2 = new Concerto("concertoclassico2", "24/08/2020", "desc", tipoEvento.PUBBLICO, 60000, stadioSanSiro);
        concertoclassico2.setGenere(genere.CLASSICO);
        concertoclassico2.setInStreaming(false);
        
        LocationDAO.save(irishPub);
        PersonaDAO.save(mario);
        // EventoDAO.save(ev);
        EventoDAO.save(milan_juve);
        EventoDAO.save(atCup);
        EventoDAO.save(concertoclassico1);
        EventoDAO.save(concertoclassico2);
        EventoDAO.save(concertorock1);
        EventoDAO.save(concertorock2);
        EventoDAO.save(concertopop1);
        EventoDAO.save(concertopop2);
        
        
    }
}
