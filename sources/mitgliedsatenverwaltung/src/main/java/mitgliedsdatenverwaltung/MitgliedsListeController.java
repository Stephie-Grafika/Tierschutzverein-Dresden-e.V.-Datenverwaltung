package mitgliedsdatenverwaltung;

import java.io.Serializable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class MitgliedsListeController implements Serializable
{
	@Inject 
	private MitgliedsListe mitgliedsListe; // Injiziert die Tabelle.
	
	private final MitgliedDAO mitgliedDAO = new MitgliedDAO(); // Injiziert  Klasse EmissionDAO, um Methoden nutzen zu können

    
    // Methode zum Speichern der Emissionen
    public String stopEdit() {
    	
    	// Speichere die gesamte Liste ohne erneutes Öffnen der EntityManagerFactory
        mitgliedDAO.saveAll(mitgliedsListe.getListe());      
        return "mitglieder"; // Erfolgreich gespeichert
    }
    
    // Methode zum Hinzufügen einer neuen Emission
    public void addMitglied() {
    	mitgliedDAO.addMitglied(mitgliedsListe.getListe());
    }

    // Methode zum Löschen einer Emission
    public void deleteMitglied(Mitglied mitglied) {
        mitgliedDAO.delete(mitglied); // Löschen der Emission über die DAO
        mitgliedsListe.getListe().remove(mitglied); // Entfernen aus lokalen Liste
    }
}