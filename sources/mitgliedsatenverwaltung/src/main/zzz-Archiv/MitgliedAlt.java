package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class MitgliedAlt implements Serializable{
	@Id
	private int mitgliedsID;
	private Person person;
	private Adresse adresse;
	private Kontakt kontakt;
	private MitgliedsBeitrag mitgliedsBeitrag;
	private MitgliedsStatus mitgliedsStatus;
	private Eintritt eintritt;
	private Kommentar kommentar;

	public MitgliedAlt() {
		// Standard-Konstruktor für JPA
	}
	
	public MitgliedAlt(int mitgliedsID, Person person, Adresse adresse, Kontakt kontakt, MitgliedsBeitrag mitgliedsBeitrag, MitgliedsStatus mitgliedsStatus, Eintritt eintritt, Kommentar kommentar) {
		super(); // Ruft den Konstruktor der Elternklasse auf
		this.mitgliedsID = mitgliedsID;
		this.person = person;
		this.adresse = adresse;
		this.kontakt = kontakt;
		this.mitgliedsBeitrag = mitgliedsBeitrag;
		this.mitgliedsStatus = mitgliedsStatus;
		this.eintritt = eintritt;
		this.kommentar = kommentar;
	}

// Getter und Setter für alle Attribute
		
	public int getMitgliedsID(){
    	return mitgliedsID;
    }

    public void setMitgliedsID(int mitgliedsID){
    	this.mitgliedsID = mitgliedsID;
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}