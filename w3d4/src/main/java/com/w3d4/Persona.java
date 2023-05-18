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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity(name = "Persona")
@Table(name = "persone")
public class Persona {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @SequenceGenerator(name="seq_persone" ,sequenceName = "seq_persone",allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_persone")
    long id;
    @Column
    String nome;
    @Column
    String cognome;
    @Column(unique = true)
    String email;
    @Column(name = "data_nascita")
    String dataNascita;
    @Column
    @Enumerated(EnumType.STRING)
    sesso sesso;
    @OneToMany(mappedBy = "persona")
    Set<Partecipazione> listaPartecipazioni = null ;
    public Persona(String nome, String cognome, String email, String dataNascita, com.w3d4.sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
    }
    //
    public Partecipazione partecipa(Evento ev){
        return new Partecipazione(this,ev, stato.CONFERMATA);
    }
    //
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }
    public sesso getSesso() {
        return sesso;
    }
    public void setSesso(sesso sesso) {
        this.sesso = sesso;
    }
    public Set<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }
    public void setListaPartecipazioni(Set<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }
}

enum sesso {MASCHIO,FEMMINA};
