package Entity;


public class Reclamation {

	public Reclamation() {
	}


	private int idReclam;
	private String textReclam;
        private String sujetReclam;
	private User user;
	private Event event;

    public Reclamation(int idReclam, String textReclam, String sujetReclam, User user, Event event) {
        this.idReclam = idReclam;
        this.textReclam = textReclam;
        this.sujetReclam = sujetReclam;
        this.user = user;
        this.event = event;
    }

    public Reclamation(int idReclam, String textReclam, String sujetReclam) {
        this.idReclam = idReclam;
        this.textReclam = textReclam;
        this.sujetReclam = sujetReclam;
    }

    public int getIdReclam() {
        return idReclam;
    }

    public void setIdReclam(int idReclam) {
        this.idReclam = idReclam;
    }

    public String getTextReclam() {
        return textReclam;
    }

    public void setTextReclam(String textReclam) {
        this.textReclam = textReclam;
    }

    public String getSujetReclam() {
        return sujetReclam;
    }

    public void setSujetReclam(String sujetReclam) {
        this.sujetReclam = sujetReclam;
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
    

        
        
    