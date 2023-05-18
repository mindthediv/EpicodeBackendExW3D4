package com.w3d4;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


enum tipoEvento {PUBBLICO,PRIVATO};


@Entity(name = "Eventi")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "eventi")
@NamedQuery(name = "vinteInCasa", query = "SELECT p FROM Eventi e WHERE p.squadra_casa = p.squadra_vincente")
@NamedQuery(name = "vinteInTrasferta", query = "SELECT p FROM Eventi e WHERE p.squadra_ospite = p.squadra_vincente")
@NamedQuery(name = "pareggi", query = "SELECT p FROM Eventi e WHERE p.squadra_vincente = null")
@NamedQuery(name = "vittorieAt", query = "SELECT g FROM Eventi e WHERE g.vincitore = :vincitore")
@NamedQuery(name = "parGareAtletica", query = "SELECT g FROM Eventi e WHERE g.set_atleti LIKE :partecipante")
@NamedQuery(name = "soldOut", query = "SELECT s FROM Eventi e WHERE s.partecipazioni.size() = s.numeroMassiomoPartecipanti")
public class Evento {
    @Id
    @SequenceGenerator(name = "seq_eventi", sequenceName = "seq_eventi", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_eventi")
    public int id;
    @Column
	public String titolo;
    @Column(name = "data_evento")
	public String dataEvento;
    @Column
	public String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
	public tipoEvento tipoEvento;
    @Column(name = "n_max_partecipanti")
	public int numeroMassimoPartecipanti;
    @OneToMany(mappedBy = "evento")
    public Set<Partecipazione> partecipazioni;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location")
    public Location location;
    
    public Evento(String titolo, String dataEvento, String descrizione, com.w3d4.tipoEvento tipoEvento,
            int numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public String getDataEvento() {
        return dataEvento;
    }
    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public tipoEvento getTipoEvento() {
        return tipoEvento;
    }
    public void setTipoEvento(tipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }
    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
}
