package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Eintritt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eintrittID;

    private LocalDate datumEintritt;

    public Eintritt() {
        // Standard-Konstruktor für JPA
    }

    public Eintritt(LocalDate datumEintritt) {
        this.datumEintritt = datumEintritt;
    }

    // --- Getter & Setter ---

    public int getEintrittID() {
        return eintrittID;
    }

    public void setEintrittID(int eintrittID) {
        this.eintrittID = eintrittID;
    }

    public LocalDate getDatumEintritt() {
        return datumEintritt;
    }

    public void setDatumEintritt(LocalDate datumEintritt) {
        this.datumEintritt = datumEintritt;
    }
}
