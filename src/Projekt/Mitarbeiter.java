package Projekt;

public class Mitarbeiter extends Frisoerladen{
	
	private String name;
	private String arbeitstag;
	private String arbeitszeit;
	public Mitarbeiter(String name, String arbeitstag, String arbeitszeit) {
		super();
		this.name = name;
		this.arbeitstag = arbeitstag;
		this.arbeitszeit = arbeitszeit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArbeitstag() {
		return arbeitstag;
	}
	public void setArbeitstag(String arbeitstag) {
		this.arbeitstag = arbeitstag;
	}
	public String getArbeitszeit() {
		return arbeitszeit;
	}
	public void setArbeitszeit(String arbeitszeit) {
		this.arbeitszeit = arbeitszeit;
	}
	@Override
	public String toString() {
		return "Mitarbeiter [name=" + name + ", arbeitstag=" + arbeitstag + ", arbeitszeit=" + arbeitszeit + "]";
	}
	
	
	

}
