package mitgliedsdatenverwaltung;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class MitgliedsListe implements Serializable {

	private List<Mitglied> liste; // Speichert Liste aller aus Datenbank geladenen Mitglied-Objekte
    private final MitgliedDAO mitgliedDAO = new MitgliedDAO(); // Injiziert  Klasse MitgliedDAO, um Methoden nutzen zu können

    // Lade die Liste nur, wenn Sie benötigt wird (Lazy Loading)
    public List<Mitglied> getListe() {
        if (liste == null) {
            liste = mitgliedDAO.findAll();
        }
        return liste;
    }
}