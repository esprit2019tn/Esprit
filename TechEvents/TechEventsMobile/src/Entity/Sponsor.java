package Entity;


public class Sponsor {
	private int idSponsor;
	private String name;
	private String desc;
        
        
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
        
        



}