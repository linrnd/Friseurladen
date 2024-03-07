package Projekt;

public class Kunden {
	private String name;
	private String alter;
	private String gewunschtTag;
	private String Uhrzeit;
	public Kunden(String name, String alter, String gewunschtTag,String Uhrzeit) {
		super();
		this.name = name;
		this.alter = alter;
		this.gewunschtTag = gewunschtTag;
		this.Uhrzeit=Uhrzeit;
	}
	
	public String getName() {
		return name;
	}
	public String getGewunschtTag() {
		return gewunschtTag;
	}
	public void setGewunschtTag(String gewunschtTag) {
		this.gewunschtTag = gewunschtTag;
	}
	public String getUhrzeit() {
		return Uhrzeit;
	}
	public void setUhrzeit(String uhrzeit) {
		Uhrzeit = uhrzeit;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlter() {
		return alter;
	}
	public void setAlter(String alter) {
		this.alter = alter;
	}
	@Override
	public String toString() {
		return "Kunden [name=" + name + ", alter=" + alter + ", gewunschtTag=" + gewunschtTag + ", Uhrzeit=" + Uhrzeit
				+ "]";
	}

	
	

}
