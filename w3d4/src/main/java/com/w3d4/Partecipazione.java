package com.w3d4;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Partecipazione")
@Table(name = "partecipazioni")
@NamedQuery(name = "daConfermare", query = "SELECT p FROM Partecipazione par WHERE p.stato = DA_CONFERMARE")
public class Partecipazione {
    @Id
    @SequenceGenerator(name = "seq_partecipazioni", sequenceName = "seq_partecipazioni", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_partecipazioni")
    long id;
    @ManyToOne(cascade = CascadeType.ALL)
    Persona persona;
    @ManyToOne(cascade = CascadeType.ALL)
    Evento evento;
    @Column
    @Enumerated(EnumType.STRING)    
    stato stato;
    public Partecipazione(Persona persona, Evento evento, com.w3d4.stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public stato getStato() {
        return stato;
    }
    public void setStato(stato stato) {
        this.stato = stato;
    }
    @Override
    public String toString() {
        return "Partecipazione [persona=" + persona + ", evento=" + evento + ", stato=" + stato + "]";
    }
}
enum stato {CONFERMATA, DA_CONFERMARE};
