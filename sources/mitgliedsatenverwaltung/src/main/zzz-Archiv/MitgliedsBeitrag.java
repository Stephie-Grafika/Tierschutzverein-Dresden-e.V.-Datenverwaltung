package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class MitgliedsBeitrag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mitgliedsBeitragsID;

    private double jahresBeitrag;

    @Enumerated(EnumType.STRING)
    private Zahlart zahlArt;

    private LocalDate letzteBeitragsZahlung;

    public MitgliedsBeitrag() {
        // Standard-Konstruktor für JPA
    }

    public MitgliedsBeitrag(double jahresBeitrag, Zahlart zahlArt, LocalDate letzteBeitragsZahlung) {
        this.jahresBeitrag = jahresBeitrag;
        this.zahlArt = zahlArt;
        this.letzteBeitragsZahlung = letzteBeitragsZahlung;
    }

    // --- Getter & Setter ---

    public int getMitgliedsBeitragsID() {
        return mitgliedsBeitragsID;
    }

    public void setMitgliedsBeitragsID(int mitgliedsBeitragsID) {
        this.mitgliedsBeitragsID = mitgliedsBeitragsID;
    }

    public double getJahresbeitrag() {
        return jahresBeitrag;
    }

    public void setJahresbeitrag(double jahresBeitrag) {
        this.jahresBeitrag = jahresBeitrag;
    }

    public Zahlart getZahlArt() {
        return zahlArt;
    }

    public void setZahlArt(Zahlart zahlArt) {
        this.zahlArt = zahlArt;
    }

    public LocalDate getLetzteBeitragsZahlung() {
        return letzteBeitragsZahlung;
    }

    public void setLetzteBeitragsZahlung(LocalDate letzteBeitragsZahlung) {
        this.letzteBeitragsZahlung = letzteBeitragsZahlung;
    }

    // Optional: Komfortmethode
    public boolean istBeitragAktuell() {
        return letzteBeitragsZahlung != null &&
               letzteBeitragsZahlung.isAfter(LocalDate.now().minusYears(1));
    }
}
