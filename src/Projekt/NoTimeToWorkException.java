package Projekt;

public class NoTimeToWorkException extends Exception{
			public NoTimeToWorkException (String string) {
				super("Sorry, Versuchen Sie andere Termin, Leider wurde kein gepasster Mitarbeiter gefunden!");
			}
}
