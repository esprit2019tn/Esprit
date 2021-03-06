package Entity;

import java.util.*;
import javafx.scene.image.ImageView;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Event {

    public Event() {
    }
    private int idEvent;
    private String titre;
    private String desc;
    private Long capaciteMax;
    private Long capaciteMin;
    private String dateEvent;
    private ImageView image ;
    public Long duree;
    private Localisation localisation;
    private String photoPath ;
    private String statut ;
    private int nbrreservation ;

    
    public Event(int idEvent, String titre, String desc, Long capaciteMax, Long capaciteMin, String dateEvent, Long duree, Localisation localisation) {
        this.idEvent = idEvent;
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.dateEvent = dateEvent;
        this.duree = duree;
        this.localisation = localisation;
    }

    public Event(int idEvent, String titre) {
        this.idEvent = idEvent;
        this.titre = titre;
    }
    
    

    public Event(String titre, String desc, Long capaciteMax, Long capaciteMin, String dateEvent, Long duree, Localisation localisation) {
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.dateEvent = dateEvent;
        this.duree = duree;
        this.localisation = localisation;
    }

    public Event(String titre, String desc, Long capaciteMax, Long capaciteMin, String dateEvent) {
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.dateEvent = dateEvent;
    }
    
    public Event(String titre, String desc, Long capaciteMax, Long capaciteMin, String dateEvent,ImageView img) {
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.dateEvent = dateEvent;
        this.image = img;
    }
    
     public Event(String titre, String desc,Long duree, Long capaciteMax, Long capaciteMin, String dateEvent,ImageView img) {
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.dateEvent = dateEvent;
        this.duree = duree ;
        this.image = img;
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
    
     public Event(int idEvent, String titre, String desc, Long capaciteMax, Long capaciteMin, String dateEvent, Long duree,String statut,ImageView imv) {
        this.idEvent = idEvent;
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.dateEvent = dateEvent;
        this.duree = duree;
        this.image = imv ;
        this.statut = statut ;
    }


    public Event(String titre, String desc) {
        this.titre = titre;
        this.desc = desc;
    }
    
    public Event(int id ,String titre, String desc) {
        this.idEvent = id ;
        this.titre = titre;
        this.desc = desc;
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

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    
    public StringProperty titreProperty() {
        return new SimpleStringProperty(titre);
    }
    
     public StringProperty descProperty() {
        return new SimpleStringProperty(desc);
    }
        
        

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return ""+titre + "";
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getNbrreservation() {
        return nbrreservation;
    }

    public void setNbrreservation(int nbrreservation) {
        this.nbrreservation = nbrreservation;
    }

    
    
}
