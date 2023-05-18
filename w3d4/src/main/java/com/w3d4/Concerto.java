package com.w3d4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity(name = "Concerto")
@Table(name = "concerti")
public class Concerto extends Evento{

    enum genere {CLASSICO,ROCK,POP}
    @Enumerated(EnumType.STRING)
    @Column
    public genere genere;
    @Column(name = "in_streaming")
    public boolean inStreaming;

    public Concerto(String titolo, String dataEvento, String descrizione, com.w3d4.tipoEvento tipoEvento,
            int numeroMassimoPartecipanti, Location location) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
    }

    public genere getGenere() {
        return genere;
    }

    public void setGenere(genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
    
}
