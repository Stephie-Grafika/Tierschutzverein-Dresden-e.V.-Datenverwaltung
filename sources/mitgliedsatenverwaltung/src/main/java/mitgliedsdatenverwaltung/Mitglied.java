package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Mitglied implements Serializable{
	@Id
	private int mitgliedsID;
	private int mitgliedsNummer;
	private Person person;
	private Adresse adresse;

	public Mitglied() {
		// Standard-Konstruktor für JPA
	}
	
	public Mitglied(int mitgliedsID, int mitgliedsNummer) {
		super(); // Ruft den Konstruktor der Elternklasse auf
		this.mitgliedsID = mitgliedsID;
		this.mitgliedsNummer = mitgliedsNummer;
	}

// Getter und Setter für alle Attribute
		
	public int getMitgliedsID(){
    	return mitgliedsID;
    }

    public void setMitgliedsID(int mitgliedsID){
    	this.mitgliedsID = mitgliedsID;
    }
    
    public int getMitgliedsNummer(){
    	return mitgliedsNummer;
    }

    public void setMitgliedsNummer(int mitgliedsNummer){
    	this.mitgliedsNummer = mitgliedsNummer;
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