package Projekt;

import java.util.ArrayList;
import java.util.List;

public class Verwaltung {


	public static void main(String[] args) {
	
		
		
		
	//Der Kunden kann anmelden, um eine Termin zu bekommen	
	 TerminBuchung.KundenAnmelden();
	 
	 //der Mitarbeiter kann mit Password aktuelle alle Termin  oder Mitarbeiterlist lesen
	TerminBuchung.UsePasswordToRead();
	
	//die neue Termin kann man schreiben und lesen 
	TerminBuchung.writeReadNewTermin();
	
	//der Nmae von Kunden zu suchen 
	for(int i=0;i<5;i++) {
	System.out.println("Hier sind alle Kunden:   "+ TerminBuchung.kundenlist.get(i).getName());
	}
	
	// Alle Termin Tage anzeigen
	for(int j=0;j<5;j++) {
		System.out.println("Hier sind alle Tage mit Termin :   "+ TerminBuchung.kundenlist.get(j).getGewunschtTag());
		}
		
	
	
	
	 
	 

	 
	 
  
    
    
    
	
    
		
		
		
		
		
		

	}

}
