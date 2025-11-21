package mitgliedsdatenverwaltung;

import java.io.Serializable;
/*import java.util.ArrayList;*/
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class EmissionTabelle implements Serializable {
	
	private List<Emission> liste; // Speichert  Liste aller aus Datenbank geladenen Emission-Objekte
    private final EmissionDAO emissionDAO = new EmissionDAO(); // Injiziert  Klasse EmissionDAO, um Methoden nutzen zu können

    // Lade die Liste nur, wenn Sie benötigt wird (Lazy Loading)
    public List<Emission> getListe() {
        if (liste == null) {
            liste = emissionDAO.findAll();
        }
        return liste;
    }
	
	/* Wenn wir in Java Instanzen erstellen wollen, statt über die Datenbank abzurufen
    private List<Emission> liste = new ArrayList<Emission>();

    public EmissionTabelle() {
        // Beispiel-Daten 
        liste.add(new Emission("Aruba", "ABW", null, null, null, null));       
        liste.add(new Emission("Zimbabwe", "ZWE", 16535.5, 13578.9, 9518.0, 8312.5));
}
    public List<Emission> getListe() {
        return liste;
    }*/
}