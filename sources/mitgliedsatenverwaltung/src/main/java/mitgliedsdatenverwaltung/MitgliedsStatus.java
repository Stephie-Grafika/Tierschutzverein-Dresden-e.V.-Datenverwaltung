package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class MitgliedsStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mitgliedsStatusID;

    @Enumerated(EnumType.STRING)
    private Status status;

    public MitgliedsStatus() {
        // Standard-Konstruktor für JPA
    }

    public MitgliedsStatus(Status status) {
        this.status = status;
    }

    // --- Getter & Setter ---

    public int getMitgliedsStatusID() {
        return mitgliedsStatusID;
    }

    public void setMitgliedsStatusID(int mitgliedsStatusID) {
        this.mitgliedsStatusID = mitgliedsStatusID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
