package com.esprit.Entity;

import java.util.*;
import com.codename1.components.ImageViewer;



public class Event {

    public Event() {
    }
    private int idEvent;
    private String titre;
    private String desc;
    private Long capaciteMax;
    private Long capaciteMin;
    private String dateEvent;
    private Date date ;
    private ImageViewer image ;
    public Long duree;
    private int cpt ;
    private String pathphoto ;
    private String statut ;
    
    

    public Event(int idEvent, String titre) {
        this.idEvent = idEvent;
        this.titre = titre;
    }
    
    public Event(String idEvent, String titre) {
        this.desc = idEvent;
        this.titre = titre;
    }


    public Event(String titre, String desc, Long capaciteMax, Long capaciteMin, String dateEvent) {
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.dateEvent = dateEvent;
    }
    
    
    
     public Event(String titre, String desc, Long capaciteMax, Long capaciteMin,Long duree) {
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.duree = duree ;
    }
     
      public Event(String titre, String desc, Long capaciteMax, Long capaciteMin,Long duree,String pathfile) {
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.duree = duree ;
        this.pathphoto = pathfile ;
    }
     
     
     public Event(String titre, String desc, Long capaciteMax, Long capaciteMin, Date dateEvent,Long duree,ImageViewer im) {
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.date = dateEvent;
        this.duree = duree ;
        this.image = im ;
    }
    
  
    

    public Event(int id, String titre, String desc, Long capaciteMax, Long capaciteMin, String dateEvent) {
        this.idEvent = id;
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.dateEvent = dateEvent;
    }

    public Event(int idEvent, String titre, String desc, Long capaciteMax, Long capaciteMin, String dateEvent, Long duree) {
        this.idEvent = idEvent;
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.dateEvent = dateEvent;
        this.duree = duree;
    }

    public Event(Long cpt) {
        this.capaciteMax = cpt;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(Long capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public Long getCapaciteMin() {
        return capaciteMin;
    }

    public void setCapaciteMin(Long capaciteMin) {
        this.capaciteMin = capaciteMin;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public Long getDuree() {
        return duree;
    }

    public void setDuree(Long duree) {
        this.duree = duree;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ImageViewer getImage() {
        return image;
    }

    public void setImage(ImageViewer image) {
        this.image = image;
    }

    public int getCpt() {
        return cpt;
    }

    public void setCpt(int cpt) {
        this.cpt = cpt;
    }

    public String getPathphoto() {
        return pathphoto;
    }

    public void setPathphoto(String pathphoto) {
        this.pathphoto = pathphoto;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    
   
    
    
}
