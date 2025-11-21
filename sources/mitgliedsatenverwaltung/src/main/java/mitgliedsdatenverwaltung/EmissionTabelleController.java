package mitgliedsdatenverwaltung;

import java.io.Serializable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class EmissionTabelleController implements Serializable
{
	@Inject 
	private EmissionTabelle emissionTabelle; // Injiziert die Tabelle.
	
	private final EmissionDAO emissionDAO = new EmissionDAO(); // Injiziert  Klasse EmissionDAO, um Methoden nutzen zu können
	
	// Methode zum Start der Bearbeitung und Beenden des Vorschaumodus
    public String startEdit() {
        return "editierbar";
    }
    
    // Methode zum Speichern der Emissionen und Beenden des Bearbeitungsmodus
    public String stopEdit() {
    	
    	// Speichere die gesamte Liste ohne erneutes Öffnen der EntityManagerFactory
        emissionDAO.saveAll(emissionTabelle.getListe());      
        return "vorschau"; // Erfolgreich gespeichert
    }
    
    // Methode zum Hinzufügen einer neuen Emission
    public void addEmission() {
    	emissionDAO.addEmission(emissionTabelle.getListe());
    }

    // Methode zum Löschen einer Emission
    public void deleteEmission(Emission emission) {
        emissionDAO.delete(emission); // Löschen der Emission über die DAO
        emissionTabelle.getListe().remove(emission); // Entfernen aus lokalen Liste
    }
}
