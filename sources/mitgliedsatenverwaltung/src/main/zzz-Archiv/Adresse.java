package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Adresse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adressID;

    private String strasse;
    private String hausNummer;
    private String plz;
    private String ort;

    public Adresse() {
        // Standard-Konstruktor für JPA
    }

    public Adresse(String strasse, String hausNummer, String plz, String ort) {
        this.strasse = strasse;
        this.hausNummer = hausNummer;
        this.plz = plz;
        this.ort = ort;
    }

    // --- Getter & Setter ---

    public int getAdressID() {
        return adressID;
    }

    public void setAdressID(int adressID) {
        this.adressID = adressID;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausNummer() {
        return hausNummer;
    }

    public void setHausNummer(String hausNummer) {
        this.hausNummer = hausNummer;
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
}
