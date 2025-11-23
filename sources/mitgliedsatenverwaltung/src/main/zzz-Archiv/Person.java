package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Person implements Serializable{
	@Id
	private int personID;
	private String titel;
    private String name;
    private String vorname;
    private LocalDate geburtsdatum;
    
    public Person() {
		// Standard-Konstruktor für JPA
	}
	
	public Person(int personID, String titel, String name, String vorname, LocalDate geburtsdatum) {
		super(); // Ruft den Konstruktor der Elternklasse auf
		this.personID = personID;
		this.titel = titel;
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
	}

// Getter und Setter für alle Attribute
		
	public int getPersonID(){
    	return personID;
    }

    public void setPersonID(int personID){
    	this.personID = personID;
    }
    
	public String getTitel(){
    	return titel;
    }

    public void setTitel(String titel){
    	this.titel = titel;
    }
    
    public String getName(){
    	return name;
    }

    public void setName(String name){
    	this.name = name;
    }
    
    public String getVorname(){
    	return vorname;
    }

    public void setVorname(String vorname){
    	this.vorname = vorname;
    }
    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }
    public void setGeburtsdatum(LocalDate geburtsdatum) {
    	this.geburtsdatum = geburtsdatum;
    }
    // Komfortmethode für Alter
    public int getAlter() {
        if (geburtsdatum == null) return 0;
        return java.time.Period.between(geburtsdatum, LocalDate.now()).getYears();
    }

    // Komfortmethode für formatiertes Datum
    public String getGeburtsdatumFormatiert() {
        return (geburtsdatum != null) ? geburtsdatum.toString() : "";
    }
}    