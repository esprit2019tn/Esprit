package com.esprit.Entity;


public class Sponsor {
	private int idSponsor;
	private int matricule;
	private String name;
	private String desc;
        private String responsable ;
        private String fondateur ;
        private String origine ;
        private String domaine ;
        
        
        public Sponsor() {
	}

    public Sponsor(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Sponsor(int idSponsor, String name, String desc) {
        this.idSponsor = idSponsor;
        this.name = name;
        this.desc = desc;
    }
        

    public int getIdSponsor() {
        return idSponsor;
    }

    public void setIdSponsor(int idSponsor) {
        this.idSponsor = idSponsor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String logo) {
        this.desc = logo;
    }

    @Override
    public String toString() {
        return "" + name + "";
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getFondateur() {
        return fondateur;
    }

    public void setFondateur(String fondateur) {
        this.fondateur = fondateur;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
        
        



}