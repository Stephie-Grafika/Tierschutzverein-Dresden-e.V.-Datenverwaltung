package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Mitglied implements Serializable{
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int mitgliedsID;
	private String titel;
    private String name;
    private String vorname;
    private String geburtsdatum;
    private Double jahresBeitrag;
    private String zahlArt;
    private int letzteBeitragsZahlung;
    private String plz;
    private String ort;
    private String strasse;
    private String hausNr;
    private String telefonNummer;
    private String mobilNummer;
    private String email;
    private String datumEintritt;
    private String mitgliedsStatus;
    private String kommentar;

    public Mitglied() {
    	
    }
    
	public Mitglied(int mitgliedsID, String titel, String name, String vorname, String geburtsdatum, Double jahresBeitrag,String zahlArt, int letzteBeitragsZahlung, String plz, String ort, String strasse, String hausNr, String telefonNummer, String mobilNummer, String email, String datumEintritt, String mitgliedsStatus, String kommentar) {
		super();
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

	public int getMitgliedsID() {
		return mitgliedsID;
	}

	public void setMitgliedsID(int mitgliedsID) {
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

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public Double getJahresBeitrag() {
		return jahresBeitrag;
	}

	public void setJahresBeitrag(Double jahresBeitrag) {
		this.jahresBeitrag = jahresBeitrag;
	}

	public String getZahlArt() {
		return zahlArt;
	}

	public void setZahlArt(String zahlArt) {
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

	public String getDatumEintritt() {
		return datumEintritt;
	}

	public void setDatumEintritt(String datumEintritt) {
		this.datumEintritt = datumEintritt;
	}

	public String getMitgliedsStatus() {
		return mitgliedsStatus;
	}

	public void setMitgliedsStatus(String mitgliedsStatus) {
		this.mitgliedsStatus = mitgliedsStatus;
	}

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}
		
}