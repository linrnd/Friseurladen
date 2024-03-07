package Projekt;

public class Service {
	
	String serviceName;
	int preis;
	public Service(String serviceName, int preis) {
		super();
		this.serviceName = serviceName;
		this.preis = preis;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public int getPreis() {
		return preis;
	}
	public void setPreis(int preis) {
		this.preis = preis;
	}
	@Override
	public String toString() {
		return "Service [serviceName=" + serviceName + ", preis=" + preis + "]";
	}
	
	
	




}
