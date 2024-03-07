package Projekt;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public  class TerminBuchung {
	
	
	public static List<Kunden> kundenlist=new ArrayList<>();
	public static List<Mitarbeiter> workerlist=new ArrayList<>();
	public static String Termin;
	
	
// Unten sind andere Methoden 	
	
	
public static String testZeitTag(Mitarbeiter mit,Kunden k) {
	//test ob the Kunden Termin die Arbeitszeit der Mitarbeiter passt

	Boolean test=false;
	String result;
	String testt=k.getGewunschtTag();
	String testz=k.getUhrzeit();
	
	String workt=mit.getArbeitstag();
	String workz=mit.getArbeitszeit();
	if(workt.contains(testt) && workz.contains(testz)) {
		test=true;
	     result=mit.getName()+" ist für Sie da.";
	}
	else {
		test=false;
		
		result=mit.getName()+"  kann leider nicht.";
	}
	return result;
}


public static void printTermin(Kunden k,String choice,String servicename,int servicep) {
	
	
	System.out.println("--------------------------------");
	System.out.println( "Schoen,dass Sie haben eine Termin erfolgreich gebucht! Überfrüfen Sie nochmal: \n"
			+k+" \n" + " Zustaendiger Mitarbeiter : "+choice+ "    Service ist:   " +servicename  +     "   "  +servicep  +"Euro");
	
	}
public static void  testException(String a,String b, String c, String d) throws NoTimeToWorkException {
	
	if(a.contains("nicht")&&b.contains("nicht")&&c.contains("nicht")&&d.contains("nicht")) {
		throw new NoTimeToWorkException
		("Sorry, Versuchen Sie andere Termin, Leider wurde kein gepasster Mitarbeiter gefunden!");
	}

}

public static void testIndexService(int sn)   {
if(sn>5||sn<0) {
	throw  new IndexOutOfBoundsException ("Nicht gültige Nummer von Service");
}

}

// File.io Data schreiben und einlesen 

public static void UsePasswordToRead() {
	System.out.println("Wollen Sie noch alle Termine sehen? Ja/Nein");
	Scanner kundenListe = new Scanner(System.in);
	String auswahl = kundenListe.next();
	boolean wiederholterlogin=false;
	
	boolean wiederholterLogin = false;
	do {
	if(auswahl.equals("Ja") ) {
		System.out.println("Bitte geben Sie das Mitarbeiterpasswort ein: " );
		Scanner mitPasswort = new Scanner(System.in);
		
			if(mitPasswort.next().equals("BesterFriseursalon")) {
				System.out.println("Sie haben die Zugangsberechtigung.");
				writeReadList();
				wiederholterLogin = false;
			}else {
				System.err.println("Das eingegebene Passwort ist leider falsch.");
				wiederholterLogin = true;
			}
	}}while(wiederholterLogin);
	
	if(auswahl.equals("Nein")) {
		System.out.println("Wollen Sie noch MitarbeiterList sehen? Ja/Nein");
		Scanner mitarbeiterListe = new Scanner(System.in);
		if(mitarbeiterListe.next().equals("Ja") ) {
			System.out.println("Bitte geben Sie das Mitarbeiterpasswort ein: " );
			Scanner mitarbeiterPasswort = new Scanner(System.in);
			if(mitarbeiterPasswort.next().equals("BesterFriseursalon")) {
				System.out.println("Sie haben die Zugangsberechtigung.");
				writeReadMitarbeiter();
			}
		}
	}

	}
	

public static void writeReadList() {
	try(FileWriter fw = new FileWriter("kundenList.txt", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{
		    out.println(kundenlist);
		} catch (IOException e) {
		
		}
//kundenlist zu lesen
	try {
		BufferedReader reader=new BufferedReader(new FileReader("kundenList.txt"));
		try {
			String line;
			while((line=reader.readLine()) !=null) {
			System.out.println(" "+line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}

}

public static void writeReadNewTermin() {
	try {
		BufferedWriter schreiber=new BufferedWriter(new FileWriter("KundenInfo.text"));
		schreiber.write(Termin);
		schreiber.close();
		
	} catch (IOException e) {
		System.err.println("Nicht gültig");
		
	}
		//read the Info
	
		try {
			BufferedReader reader=new BufferedReader(new FileReader("KundenInfo.text"));
			try {
				String line;
				while((line=reader.readLine()) !=null) {
				System.out.println(" "+line);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			try {
				reader.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
public static void writeReadMitarbeiter() {

	try(FileWriter fw = new FileWriter("mitarbeiter.txt", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{
		    out.println(workerlist);
		    System.out.println("Die neue Mitarbeiterliste steht zur Verfügung.");
		    
		} catch (IOException e) {
		    System.out.println("Es ist ein Fehler aufgetreten.");
		} 

	try(BufferedReader dateiLeser = new BufferedReader(new FileReader(new File("mitarbeiter.txt")))){
		String zeile;
		while((zeile = dateiLeser.readLine()) != null) {
			System.out.println(zeile);
		}
	} catch (FileNotFoundException e) {
		System.out.println("Die Datei konnte nicht gefunden werden.");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("Es gab einen Fehler.");
		e.printStackTrace();
	}
}
//Diese Methode kann der Kunden anmelden 
	public static void KundenAnmelden() {
		String choice;
		String servicename;
		int servicep;
		
		Service wf=new Service("0 waschen und Foehnen",10);
		Service sc=new Service("1 Haarschnitt",20);
		Service ab=new Service("2 Abend-/Brautfrisur",50);
		Service fa=new Service("3 Farbe",40);
		Service au=new Service("4 Augenbrauen zupfen und färben",20);
		Service ba=new Service("5 Bartkosmetik",35);
		
		List<Service> servicelist=new ArrayList<>();
		servicelist.add(wf);
		servicelist.add(sc);
		servicelist.add(ab);
		servicelist.add(fa);
		servicelist.add(au);
		servicelist.add(ba);
		
		Mitarbeiter f1=new Mitarbeiter("Schneider","Montag,Dienstag,Donnerstag","13:00-14:00-15:00-16:00-17:00-18:00");
		Mitarbeiter f2=new Mitarbeiter("Koenig","Donnerstag,Samstag","8:00-9:00-10:00-11:00-12:00 und 14:00-15:00-16:00-17:00");
		Mitarbeiter f3=new Mitarbeiter("Bauer","Mittwoch,Donnerstag,Freitag","12:00-13:00-14:00-15:00-16:00-17:00");
		Mitarbeiter f4=new Mitarbeiter("Holden","Mittwoch,Donnerstag,Samstag","8:00-9:00-10:00-11.00 und 16:00-17:00-18:00");
		
		workerlist.add(f1);
		workerlist.add(f2);
		workerlist.add(f3);
		workerlist.add(f4);
		
		//Arraylist um Kunden zu speichern
		
		Kunden k2=new Kunden("Lisa","14","Montag","15:00");
		Kunden k3=new Kunden("Monica","35","Freitag","15:00 ");
		Kunden k4=new Kunden("Leon","44","Mittwoch","12:00");
		Kunden k5=new Kunden("Felix","22","Donnertag","13:00");
		Kunden k6=new Kunden("Stefanie","18","Montag","17:00");
	
		//new Kunde Objekt 
		Kunden k1=new Kunden(null,null,null,null);
		
		kundenlist.add(k2);
		kundenlist.add(k3);
		kundenlist.add(k4);
		kundenlist.add(k5);
		kundenlist.add(k6);
		
		
		// mit Scanner kann Kunde anmelden
		Scanner s1=new Scanner(System.in);
		System.out.println("Herzlichen Willkomen zu unserem FrisörLaden!");
		System.out.print("Bitte Enter your name(No Number or NO EMPTY): ");
		String name =s1.nextLine();
		System.out.println("Name :"+name);
		k1.setName(name);
		while(name.isEmpty() == true ||name.matches("[0-9]+")) {
			System.err.println("Eingabe ist ungueltig . ");
			System.out.print(""
					+ "Bitte Enter your name(No Number or NO EMPTY): ");
			name =s1.nextLine();
			k1.setName(name);	
		}
		

		System.out.print("Bitte Enter your Age(Number ONLY): ");
		String alter =s1.nextLine();
		System.out.println("Alter :"+alter);
		k1.setAlter(alter);
		
		while(alter.isEmpty() == true||alter.matches("[a-zA-Z]+") || alter.length() > 2) {
			System.err.println("Eingabe ist ungueltig .");
			System.out.print("Bitte Enter your Age(Number ONLY): ");
			alter =s1.nextLine();
			System.out.println("Alter :"+alter);
		k1.setAlter(alter);
		}
			
		System.out.print("Bitte Enter your gewunschtes Tag(z.B Montag) : ");
		String gewunschtTag=s1.nextLine();
		System.out.println("gewunschtTag :"+gewunschtTag);
		k1.setGewunschtTag(gewunschtTag);
		while(gewunschtTag.isEmpty()==true||gewunschtTag.matches("[0-9]+")) {
			System.err.println("Eingabe ist ungueltig .");
			System.out.print("Bitte Enter your gewunschtes Tag(z.B Montag) : ");
			gewunschtTag=s1.nextLine();
			System.out.println("gewunschtTag :"+gewunschtTag);
			k1.setGewunschtTag(gewunschtTag);
		}
		
		System.out.print("Bitte Enter your gewunschte Uhrzeit(z.B 14:00) : ");
		String Uhrzeit=s1.nextLine();
		System.out.println("WunschtUhrzeit :"+Uhrzeit);
		k1.setUhrzeit(Uhrzeit);
		while(Uhrzeit.isEmpty()==true) {
			System.err.println("Eingabe ist ungueltig .");
			System.out.print("Bitte Enter your gewunschte Uhrzeit(z.B 14:00) : ");
			Uhrzeit=s1.nextLine();
			System.out.println("WunschtUhrzeit :"+Uhrzeit);
			k1.setUhrzeit(Uhrzeit);
		}
	

		// mit set und add kann man KundeInfo speichern 
		System.out.println("Ueberpruefen ihre Information : "+"\n"+k1);
		kundenlist.add(k1);
		
		// muss prüfen, welcher Mitarbeiter die Zeit hast u. den Kunde zu dienen 
	
		System.out.println("--------------------------");
		System.out.println("Welcher Service nehmen Sie? Unten siehen Sie alle Leistung von uns: ");
		
		for(Service x:servicelist) {
			System.out.println(x.getServiceName());
		}
		System.out.print("Bitte die Nummer des Service eingeben: ");
		
		// Exception wenn die ungültige Nummer gegeben wird.
		boolean check=true;
		int sn=0;
		while(check) {
			try {
				sn=s1.nextInt();
				testIndexService(sn);
				check=false;	
			}catch(IndexOutOfBoundsException m) {
				System.err.println("Nummer ist ungueltig. ");
	
			}
		}
		
	    servicename=servicelist.get(sn).getServiceName();
		servicep=servicelist.get(sn).getPreis();
	
		System.out.println("--------------------------");
		System.out.println("Unten werden das Ergebnis von Mitarbeiter gezeigt:  ");
		
		String a=testZeitTag(f1,k1);
		String b=testZeitTag(f2,k1);
		String c=testZeitTag(f3,k1);
		String d=testZeitTag(f4,k1);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		//wenn >1 Mitarbeiter sind da, der kunden kann sich für einen entscheiden
		
		try {
			testException(a, b, c, d);
		} catch (NoTimeToWorkException e) {
			System.err.println(e);
		}
		

			Scanner s3=new Scanner(System.in);
			System.out.println("--------------------------"+"\n");
			System.out.print("Schauen Sie welcher Mitarbeiter ist verfügbar am deinen gewunschten Tag,"+
		         "Wenn niemandem passt, bitte das Programm erneuren, wenn ja, bitte waehlen Sie einen Mitarbeiter : "  );
			 choice=s3.nextLine();
			printTermin(k1,choice,servicename,servicep);
			
		// Der Kunde kann Lieblingsfrisör auswählen
		System.out.println("--------------------------"+"\n");
		System.out.print("Wenn Sie ihre bevorzugten Frisoer haben, können Sie checken, wenn er sich für Sie verfügbar ist. "
				+ "Wenn nein, Bitte NO eingeben, wenn ja, Bitte der Name eingeben ");
		Scanner s4=new Scanner(System.in);
		String mitname=s4.nextLine();
		if(mitname.equals("NO")) {
			System.out.println();
		}
		if(mitname.equals("Schneider")) {
			System.out.println(f1.getArbeitstag()+   "  " +f1.getArbeitszeit());
		}
		if(mitname.equals("koenig")) {
			System.out.println(f2.getArbeitstag()+   "  " +f1.getArbeitszeit());
		}
		if(mitname.equals("Bauer")) {
			System.out.println(f3.getArbeitstag()+   "  " +f1.getArbeitszeit());
		}
		if(mitname.equals("Holden")) {
			System.out.println(f4.getArbeitstag()+   "  " +f1.getArbeitszeit());
		}
		
		System.out.println("--------------------------"+"\n");
		System.out.print("Wollen Sie Uhrzeit oder gewunschtetag  deiner Termin ändern, um Arbeitsplan des bevorzugte Frisoer zu passen?   "
				+ "wenn nein, bitte NO eingeben; Wenn ja, bitte Ja eingeben ");
		String mitprefer=s4.nextLine();
		if(mitprefer.equals("NO")) {
			System.out.println();
		}
		else {
			choice=mitprefer;	
			Scanner s5=new Scanner(System.in);
			System.out.print("Bitte neues gewunschtetag eingeben: ");
			String newday=s5.nextLine();
			k1.setGewunschtTag(newday);
			System.out.print("Bitte neue Uhrzeit eingeben: ");
			String newtime=s5.nextLine();
			k1.setUhrzeit(newtime);
			
		}
		
		// Der Kunde hat verschiedene Auswahl für seine gebuchte Termin 
		System.out.println("--------------------------"+"\n");
		System.out.print("Liebe Kunde,"+"\n"+
						"Wennn Sie die Termin Loeschen, bitte geben Sie ’loeschen’ ein;"+"\n"+
						"Wennn Sie die info des Termin ändern, bitte geben Sie ’aendern’ ein;    "+"\n"+
						"Wenn Sie mit der Termin zufrieden sind, bitte klicken Sie Eingabetaste(Enter)");
		Scanner s6=new Scanner(System.in);
		
	 //Buchung loeschen
		String edit=s6.nextLine();
		if(edit.equals("loeschen")) {
			System.out.println("--------------------------"+"\n");
			kundenlist.remove(k1);
		}
		//Buchung aendern
		else if(edit.equals("aendern")){
			System.out.println("--------------------------"+"\n");
			System.out.print("Welche Information werden Sie aendern? z.B Name,Alter(Tag und Uhrzeit koennen  Sie nicht aendern)      ");
		
			Scanner s7=new Scanner(System.in);
			String ändernA=s7.nextLine();
			if(ändernA.equals("Name")) {
				System.out.print("Enter Sie neuen Name: ");
				String newname=s7.nextLine();
				kundenlist.get(0).setName(newname);
				System.out.println("Fertig! Ihre neue Termin sind:  " +k1 );
			}
			if(ändernA.equals("Alter")) {
				System.out.println("--------------------------"+"\n");
				System.out.print("Enter Sie neues Alter: ");
				String newAlter=s7.nextLine();
				kundenlist.get(0).setAlter(newAlter);
			}
			
			
			//Zeigen bearbeitete Termin 
			System.out.println("--------------------------"+"\n");
			
		}
		System.out.println("Ueberfruefen Sie ihre Information:  ");
		System.out.println(k1);
		Termin=k1+"\n"+"Zustaendiger Frisoer:   "+ choice+  "\n"+ "Service:  "+servicename+  "  "+servicep+ "  Euro";
		List<String> terminlist=new ArrayList<>();
		terminlist.add(Termin);
		printTermin(k1,choice,servicename,servicep);
		System.out.println("Saved Termin:  " +terminlist.get(0));

	}

	
	


}


