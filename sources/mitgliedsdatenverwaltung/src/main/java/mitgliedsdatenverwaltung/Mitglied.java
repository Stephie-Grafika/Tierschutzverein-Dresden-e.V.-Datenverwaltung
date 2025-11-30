package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;

import mitgliedsdatenverwaltung.MitgliedsStatus;

@Entity
public class Mitglied implements Serializable {
	
	@Id
	private int mitgliedsID;
    private String titel;
    private String name;
    private String vorname;
    private Date geburtsdatum;
    private String jahresBeitrag;
    //private String zahlArt;
    @Enumerated(EnumType.STRING)
    private ZahlArt zahlArt;
    private int letzteBeitragsZahlung;
    private String plz;
    private String ort;
    private String strasse;
    private String hausNr;
    private String telefonNummer;
    private String mobilNummer;
    private String email;
    private Date datumEintritt;
    //private String mitgliedsStatus;
    @Enumerated(EnumType.STRING)
    private MitgliedsStatus mitgliedsStatus;
    private String kommentar;

	public Mitglied() {
		// Standard-Konstruktor für JPA
	}
	
	public MitgliedsStatus mitgliedsStatus() {
		return mitgliedsStatus;
	}
	
	public Mitglied(int mitgliedsID, String titel, String name, String vorname, Date geburtsdatum, String jahresBeitrag, ZahlArt zahlArt, int letzteBeitragsZahlung, String plz, String ort, String strasse, String hausNr, String telefonNummer, String mobilNummer, String email, Date datumEintritt, MitgliedsStatus mitgliedsStatus, String kommentar) {
		super(); // Ruft den Konstruktor der Elternklasse auf
		this.mitgliedsID = mitgliedsID;
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		this.jahresBeitrag = jahresBeitrag;
		this.zahlArt = zahlArt;
		this.letzteBeitragsZahlung = letzteBeitragsZahlung;
		this.plz = plz;
		this.ort = ort;
		this.strasse = strasse;
		this.hausNr = hausNr;
		this.telefonNummer = telefonNummer;
		this.mobilNummer = mobilNummer;
		this.email = email;
		this.datumEintritt = datumEintritt;
		this.mitgliedsStatus = mitgliedsStatus;
		this.kommentar = kommentar;
	}

// Getter und Setter für alle Attribute
		
	public int getMitgliedsID(){
    	return mitgliedsID;
    }

    public void setMitgliedsID(int mitgliedsID){
    	this.mitgliedsID = mitgliedsID;
    }
 
	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getJahresBeitrag() {
		return jahresBeitrag;
	}

	public void setJahresBeitrag(String jahresBeitrag) {
		this.jahresBeitrag = jahresBeitrag;
	}

	public ZahlArt getZahlArt() {
		return zahlArt;
	}

	public void setZahlArt(ZahlArt zahlArt) {
		this.zahlArt = zahlArt;
	}

	public int getLetzteBeitragsZahlung() {
		return letzteBeitragsZahlung;
	}

	public void setLetzteBeitragsZahlung(int letzteBeitragsZahlung) {
		this.letzteBeitragsZahlung = letzteBeitragsZahlung;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausNr() {
		return hausNr;
	}

	public void setHausNr(String hausNr) {
		this.hausNr = hausNr;
	}

	public String getTelefonNummer() {
		return telefonNummer;
	}

	public void setTelefonNummer(String telefonNummer) {
		this.telefonNummer = telefonNummer;
	}

	public String getMobilNummer() {
		return mobilNummer;
	}

	public void setMobilNummer(String mobilNummer) {
		this.mobilNummer = mobilNummer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDatumEintritt() {
		return datumEintritt;
	}

	public void setDatumEintritt(Date datumEintritt) {
		this.datumEintritt = datumEintritt;
	}

	public MitgliedsStatus getMitgliedsStatus() {
		return mitgliedsStatus;
	}

	public void setMitgliedsStatus(MitgliedsStatus mitgliedsStatus) {
		this.mitgliedsStatus = mitgliedsStatus;
	}

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}
}