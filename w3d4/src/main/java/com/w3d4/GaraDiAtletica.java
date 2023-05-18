package com.w3d4;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.List;

@Entity(name = "GaraDiAtletica")
@Table(name = "gare_atletica")

public class GaraDiAtletica extends Evento{

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    public List<Persona> setAtleti;
    @Column
    public Persona vincitore;
   
    public GaraDiAtletica(String titolo, String dataEvento, String descrizione, com.w3d4.tipoEvento tipoEvento,
            int numeroMassimoPartecipanti, Location location) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
    }
    
    public List<Persona> getSetAtleti() {
        return setAtleti;
    }
    public void setSetAtleti(List<Persona> setAtleti) {
        this.setAtleti = setAtleti;
    }
    public Persona getVincitore() {
        return vincitore;
    }
    public void setVincitore(Persona vinc) {
        vincitore = vinc;
    }    
}
