package Entity;

import java.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.StringPropertyBase;

public class User {
	private int id;
	private String nom;
	private String prenom;
	private Date dateNaiss;
        private String sexe;
	private String adresse;
        private String email;
        private String password;
        private RoleUser role;
        private String confirmationCode;
        private Boolean confirmation;
        private Boolean active;

	private ArrayList<Event> events;

	public User() {
	}

    public User(String nom, String prenom, Date dateNaiss, String sexe, String adresse, String email, String password, RoleUser role, String confirmationCode) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.adresse = adresse;
        this.email = email;
        this.password = password;
        this.role = role;
        this.confirmationCode = confirmationCode;
    }

    public User(int id, String nom, String prenom, Date dateNaiss, String sexe, String adresse, String email, String password, RoleUser role, String confirmationCode, Boolean confirmation, Boolean active) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.adresse = adresse;
        this.email = email;
        this.password = password;
        this.role = role;
        this.confirmationCode = confirmationCode;
        this.confirmation = confirmation;
        this.active = active;
    }


    
    public User(int id, String nom, String prenom, String adresse, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.password = password;
    }
        
        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public RoleUser getRole() {
        return role;
    }

    public void setRole(RoleUser role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }
    
        

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
    
    
    
    public StringProperty firstNameProperty() {
             return new SimpleStringProperty(nom);
    }



    public StringProperty lastNameProperty() {
             return new SimpleStringProperty(prenom);
    }
    
        public StringProperty emailProperty() {
             return new SimpleStringProperty(email);
    }

    @Override
    public String toString() {
        return nom;
    }
        
        
        
}