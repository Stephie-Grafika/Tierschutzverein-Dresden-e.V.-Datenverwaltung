package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class MitgliedsBeitrag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mitgliedsBeitragsID;

    private double jahresbeitrag;

    @Enumerated(EnumType.STRING)
    private Zahlart zahlArt;

    private LocalDate letzteBeitragsZahlung;

    public MitgliedsBeitrag() {
        // Standard-Konstruktor für JPA
    }

    public MitgliedsBeitrag(double jahresbeitrag, Zahlart zahlArt, LocalDate letzteBeitragsZahlung) {
        this.jahresbeitrag = jahresbeitrag;
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
        return jahresbeitrag;
    }

    public void setJahresbeitrag(double jahresbeitrag) {
        this.jahresbeitrag = jahresbeitrag;
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
