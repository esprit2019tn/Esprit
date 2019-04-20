package Entity;


public class Reclamation {

	public Reclamation() {
	}


	private int idReclam;
	private String texte;
	private User user;
	private Event event;

    public int getIdReclam() {
        return idReclam;
    }

    public void setIdReclam(int idReclam) {
        this.idReclam = idReclam;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

        
}