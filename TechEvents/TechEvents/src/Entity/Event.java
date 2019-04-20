package Entity;

import java.util.*;


public class Event {

	public Event() {
	}
	private int idEvent;
	private String titre;
	private String desc;
	private Long capaciteMax;
	private Long capaciteMin;
	private Date dateEvent;
	public Long duree;
	private Localisation localisation;

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

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
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
        
        

}