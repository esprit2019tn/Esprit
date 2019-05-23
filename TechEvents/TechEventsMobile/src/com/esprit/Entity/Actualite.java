package com.esprit.Entity;

import java.util.*;

public class Actualite {

	public Actualite() {
	}
        
	private int numActu;
	private Date dateActu;
	private String titre;
	private String descActu;
        private int idEvent;

    public Actualite(String descActu, int idEvent) {
        this.descActu = descActu;
        this.idEvent = idEvent;
    }

    public Actualite(String titre,Date dateActu,  String descActu) {
        this.dateActu = dateActu;
        this.titre = titre;
        this.descActu = descActu;
    }
     
        

    public int getNumActu() {
        return numActu;
    }

    public void setNumActu(int numActu) {
        this.numActu = numActu;
    }

    public Date getDateActu() {
        return dateActu;
    }

    public void setDateActu(Date dateActu) {
        this.dateActu = dateActu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

   

    public String getDescActu() {
        return descActu;
    }

    public void setDescActu(String descActu) {
        this.descActu = descActu;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public Actualite(int numActu, Date dateActu, String descActu, int idEvent) {
        this.numActu = numActu;
        this.dateActu = dateActu;
        this.descActu = descActu;
        this.idEvent = idEvent;
    }

        
        

}