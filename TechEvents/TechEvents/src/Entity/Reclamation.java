package Entity;


public class Reclamation {

	public Reclamation() {
	}


	private int idReclam;
	private String texte;
	private User user;
	private Event event;
        private String sujet;

    public Reclamation(int idReclam, String texte, User user, Event event, String sujet) {
        this.idReclam = idReclam;
        this.texte = texte;
        this.user = user;
        this.event = event;
        this.sujet = sujet;
    }
    

    public Reclamation(String texte, User user, Event event, String sujet) {
        this.texte = texte;
        this.user = user;
        this.event = event;
        this.sujet = sujet;
    }

    public Reclamation(int idReclam, User user, Event event, String sujet) {
        this.idReclam = idReclam;
        this.user = user;
        this.event = event;
        this.sujet = sujet;
    }

    public Reclamation(int idReclam, String texte, Event event, String sujet) {
        this.idReclam = idReclam;
        this.texte = texte;
        this.event = event;
        this.sujet = sujet;
    }

    public Reclamation(int idReclam, String texte, User user, String sujet) {
        this.idReclam = idReclam;
        this.texte = texte;
        this.user = user;
        this.sujet = sujet;
    }

    public Reclamation(int idReclam, String texte, User user, Event event) {
        this.idReclam = idReclam;
        this.texte = texte;
        this.user = user;
        this.event = event;
    }

    public void setIdReclam(int idReclam) {
        this.idReclam = idReclam;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public int getIdReclam() {
        return idReclam;
    }

    public String getTexte() {
        return texte;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public String getSujet() {
        return sujet;
    }
}
    

        
        
    