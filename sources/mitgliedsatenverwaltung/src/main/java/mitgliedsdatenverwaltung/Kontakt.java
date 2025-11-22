package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Kontakt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kontaktID;

    private String telefonNummer;
    private String mobilNummer;
    private String email;

    public Kontakt() {
        // Standard-Konstruktor für JPA
    }

    public Kontakt(String telefonNummer, String mobilNummer, String email) {
        this.telefonNummer = telefonNummer;
        this.mobilNummer = mobilNummer;
        this.email = email;
    }

    // --- Getter & Setter ---

    public int getKontaktID() {
        return kontaktID;
    }

    public void setKontaktID(int kontaktID) {
        this.kontaktID = kontaktID;
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
}
