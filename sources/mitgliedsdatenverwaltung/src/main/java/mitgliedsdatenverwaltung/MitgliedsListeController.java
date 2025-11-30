package mitgliedsdatenverwaltung;

import java.io.Serializable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mitgliedsdatenverwaltung.Mitglied;
import mitgliedsdatenverwaltung.MitgliedDAO;
import mitgliedsdatenverwaltung.MitgliedsListe;

@Named
@ViewScoped
public class MitgliedsListeController implements Serializable
{
	@Inject 
	private MitgliedsListe mitgliedsListe; // Injiziert die Tabelle.
	
	private final MitgliedDAO mitgliedDAO = new MitgliedDAO(); // Injiziert  Klasse MitgliedDAO, um Methoden nutzen zu können

    // Methode zum Bearbeiten der Mitglieder
	public String startEdit() {
        return 	"editierbar";
    }
	
    // Methode zum Speichern der Mitglieder
    public String stopEdit() {
    	
    	// Speichere die gesamte Liste ohne erneutes Öffnen der EntityManagerFactory
        mitgliedDAO.saveAll(mitgliedsListe.getListe());      
        return "mitglieder"; // Erfolgreich gespeichert, wechel zur Vorschauseite
    }
    
    // Methode zum Hinzufügen eines neuen Mtglieds
    public void addMitglied() {
    	mitgliedDAO.addMitglied(mitgliedsListe.getListe());
    }

    // Methode zum Löschen eines Mitglieds
    public void deleteMitglied(Mitglied mitglied) {
        mitgliedDAO.delete(mitglied); // Löschen des Mitglieds über die DAO
        mitgliedsListe.getListe().remove(mitglied); // Entfernen aus lokalen Liste
    }
}
