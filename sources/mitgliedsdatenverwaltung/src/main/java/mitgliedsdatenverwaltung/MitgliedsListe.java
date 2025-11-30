package mitgliedsdatenverwaltung;

import java.io.Serializable;
/*import java.util.ArrayList;*/
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import mitgliedsdatenverwaltung.Mitglied;
import mitgliedsdatenverwaltung.MitgliedDAO;

import java.util.Locale;

import org.primefaces.component.api.UIColumn;
import org.primefaces.event.ColumnToggleEvent;
import org.primefaces.model.Visibility;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
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
	
	/* Wenn wir in Java Instanzen erstellen wollen, statt über die Datenbank abzurufen
    private List<Mitglied> liste = new ArrayList<Emission>();

    public MitgliedListe() {
        // Beispiel-Daten 
        liste.add(new Mitglied("998", null, "Name", "Vorname", null, null, null));       
}
    public List<Mitglied> getListe() {
        return liste;
    }*/
    
}