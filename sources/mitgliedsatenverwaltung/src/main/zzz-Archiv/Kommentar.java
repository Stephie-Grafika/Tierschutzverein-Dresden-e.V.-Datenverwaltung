package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Kommentar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kommentarID;
    @Column(length = 1000)
    private String notiz;

    public Kommentar() {
        // Standard-Konstruktor für JPA
    }

    // --- Getter & Setter ---

    public int getKommentarID() {
        return kommentarID;
    }
    
    public void setKommentarID(int kommentarID) {
        this.kommentarID = kommentarID;
    } 
    
    public String getnotiz() {
        return notiz;
    }
    
    public void setNotizID(String notiz) {
        this.notiz = notiz;
   }
} 