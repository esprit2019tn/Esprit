package com.esprit.Entity;

import java.util.*;

public class Actualite {

	public Actualite() {
	}
        
	private int numActu;
	private Date dateActu;
	private String img;
	private String desc;
        private int eventId;

    public Actualite(Date dateActu, String desc, int eventId) {
        this.dateActu = dateActu;
        this.desc = desc;
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Actualite{" + "numActu=" + numActu + ", dateActu=" + dateActu + ", img=" + img + ", desc=" + desc + ", eventName=" + eventId + '}';
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventID(int eventName) {
        this.eventId = eventName;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
        
        

}