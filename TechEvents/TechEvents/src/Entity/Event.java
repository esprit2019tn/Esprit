package Entity;

import java.util.*;
<<<<<<< HEAD
import javafx.scene.image.ImageView;
=======
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

>>>>>>> eb045fb00ac91d979ade4862295df94e27facc92

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
    
     public Event(int idEvent, String titre, String desc, Long capaciteMax, Long capaciteMin, String dateEvent, Long duree,ImageView imv) {
        this.idEvent = idEvent;
        this.titre = titre;
        this.desc = desc;
        this.capaciteMax = capaciteMax;
        this.capaciteMin = capaciteMin;
        this.dateEvent = dateEvent;
        this.duree = duree;
        this.image = imv ;
    }


    public Event(String titre, String desc) {
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
<<<<<<< HEAD
=======
    
    public StringProperty titreProperty() {
        return new SimpleStringProperty(titre);
    }
    
     public StringProperty descProperty() {
        return new SimpleStringProperty(desc);
    }
        
        
>>>>>>> eb045fb00ac91d979ade4862295df94e27facc92

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    
    
}
