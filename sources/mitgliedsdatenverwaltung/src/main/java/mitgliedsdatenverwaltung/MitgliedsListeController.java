package mitgliedsdatenverwaltung;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

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
    
 // ---- Für mitgliederEditierbar.xhtml: Zeilenweise bearbeiten/löschen, erst bei "Speichern" final ----

    private final Set<Integer> inBearbeitung = new HashSet<>(); // IDs der Zeilen, die gerade als Eingabefeld angezeigt werden
    private final List<Mitglied> zumLoeschenVorgemerkt = new ArrayList<>(); // erst bei Speichern wirklich löschen

    public boolean istInBearbeitung(Mitglied mitglied) {
        return inBearbeitung.contains(mitglied.getMitgliedsID());
    }

    // Schaltet eine Zeile zwischen Anzeige (Output) und Eingabe (Input) um (Stift <-> Haken)
    public void toggleBearbeitung(Mitglied mitglied) {
        if (!inBearbeitung.remove(mitglied.getMitgliedsID())) {
            inBearbeitung.add(mitglied.getMitgliedsID());
        }
    }

    // Merkt ein Mitglied zum Löschen vor: verschwindet aus der Ansicht, wird aber erst bei "Speichern" aus der DB gelöscht
    public void zumLoeschenVormerken(Mitglied mitglied) {
        zumLoeschenVorgemerkt.add(mitglied);
        mitgliedsListe.getListe().remove(mitglied);
    }

    // Übernimmt Bearbeitungen und Löschungen final in die Datenbank
    public String speichern() {
        for (Mitglied mitglied : zumLoeschenVorgemerkt) {
            mitgliedDAO.delete(mitglied);
        }
        zumLoeschenVorgemerkt.clear();
        mitgliedDAO.saveAll(mitgliedsListe.getListe());
        inBearbeitung.clear();
        return null; // auf derselben Seite bleiben
    }
    
}
