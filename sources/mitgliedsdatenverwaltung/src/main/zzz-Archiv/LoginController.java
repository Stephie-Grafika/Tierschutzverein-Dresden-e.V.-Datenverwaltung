package emissionsapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class LoginController implements Serializable {

	String name;
	Account account;

	List<Account> accountListe;

	/* Wäre in richtigem System verschlüsselt */
	public LoginController() {
		this.accountListe = new ArrayList<Account>();
		this.accountListe.add(new Account("Wissenschaftlerin", "123456"));
		this.accountListe.add(new Account("Wissenschaftler", "654321"));
		this.account = new Account();
	}
	
	/* Methode wird aufgerufen, wenn Event ausgelöst wird (nach Eingabe in Namensfeld validiert wurde) */
	/* Accountname zwischenspeichern, damit Kombination mit Passwort validiert werden kann */
	public void postValidateName(ComponentSystemEvent ev) throws AbortProcessingException {
		/* Eingabekomponente aus Event extrahieren */
		UIInput temp = (UIInput)ev.getComponent();
		/* Wert/Value aus Eingabekomponente extrahieren in Datentyp String, weil vorher unbekannt*/
		this.name = (String)temp.getValue();
		/* Nur für Dev um zu sehen, wie Werte gesetzt und geprüft werden 
		int breakpoint = 1; */
	}
	
	/* Login-Validierung: Gibt es im System (wie eingegeben) einen Account mit selben Accountnamen & Passwort */
	public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		for(Account a:accountListe) {
			/* Temporäres Objekt (Account) mit zwischengespeichertem Accountname und Wert/Value des Passwortes durch diese Methode (ist mit Passwortfeld verknüpft) */
			Account temp=new Account(this.name, (String)value);
			/* Prüfen, ob Eingabewerte mit temporärem Objekt (Account) übereinstimmt durch überschriebene Equals-Methode */
			if(a.equals(temp))
				/* Falls ja, wird wahr zurück geworfen */
				return ;
		}
		/* Falls nein, wird Execption/Fehlermeldung geworfen */
		throw new ValidatorException(new FacesMessage("Login falsch!"));
	}

	/* Weiterleitung nach Login - Alle Benutzer werden zu "editierbar" weitergeleitet */
	public String login() {
	    return "editierbar"; // Alle Benutzer werden auf die Seite "editierbar" weitergeleitet
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
