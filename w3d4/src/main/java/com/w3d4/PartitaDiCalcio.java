package com.w3d4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity(name = "PartitaDiCalcio")
@Table(name = "partite_calcio")
public class PartitaDiCalcio extends Evento  {
    @Column(name = "squadra_casa")
    public String squadraCasa;
    @Column(name = "squadra_ospite")
    public String squadraOspite; 
    @Column(name = "squadra_vincente")
    public String squadraVincente = null;
    @Column(name = "goal_casa")
    public int goalCasa;
    @Column(name = "goal_ospite")
    public int goalOspite;

    public PartitaDiCalcio(String titolo, String dataEvento, String descrizione, com.w3d4.tipoEvento tipoEvento,
            int numeroMassimoPartecipanti, Location location, String squadraCasa, String squadraOspite, int goalCasa,
            int goalOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.goalCasa = goalCasa;
        this.goalOspite = goalOspite;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGoalCasa() {
        return goalCasa;
    }

    public void setGoalCasa(int goalCasa) {
        this.goalCasa = goalCasa;
    }

    public int getGoalOspite() {
        return goalOspite;
    }

    public void setGoalOspite(int goalOspite) {
        this.goalOspite = goalOspite;
    }

}
