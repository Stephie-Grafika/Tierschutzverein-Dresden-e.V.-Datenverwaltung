package mitgliedsdatenverwaltung;

import java.io.Serializable;
/*import java.util.ArrayList;*/
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import mitgliedsdatenverwaltung.Mitglied;
import mitgliedsdatenverwaltung.MitgliedDAO;



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
    
 // gibt die Anzahl aller Mitglieder zurück
    public int getSummeMitglieder() {
        // getListe() sorgt für Lazy-Loading, also immer die aktuelle Liste verwenden
        List<Mitglied> l = getListe();
        return (l == null) ? 0 : l.size();
    }

    // gibt die Anzahl der aktiven Mitglieder weider
    
    public int getAnzahlAktiv() {
        List<Mitglied> l = getListe();
        if (l == null || l.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Mitglied m : l) {
            if (m == null) continue;
            MitgliedsStatus s = m.getMitgliedsStatus();
            if (s == null) continue;
            // robust prüfen: entweder Enum-Name oder (falls vorhanden) die String-Repräsentation über getStatus()
            if ("AKTIV".equalsIgnoreCase(s.name()) ||
                (s.getStatus() != null && "AKTIV".equalsIgnoreCase(s.getStatus()))) {
                count++;
            }
        }
        return count;
    }
	
    // gibt die Anzahl der keine Zahlung Mitglieder weider
    
    public int getAnzahlKeineZahlung() {
        List<Mitglied> l = getListe();
        if (l == null || l.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Mitglied m : l) {
            if (m == null) continue;
            MitgliedsStatus s = m.getMitgliedsStatus();
            if (s == null) continue;
            // robust prüfen: entweder Enum-Name oder (falls vorhanden) die String-Repräsentation über getStatus()
            if ("KEINEZAHLUNG".equalsIgnoreCase(s.name()) ||
                (s.getStatus() != null && "KEINEZAHLUNG".equalsIgnoreCase(s.getStatus()))) {
                count++;
            }
        }
        return count;
    }
    
    // gibt die Anzahl der gestrichene Mitglieder weider
    
    public int getAnzahlGestrichen() {
        List<Mitglied> l = getListe();
        if (l == null || l.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Mitglied m : l) {
            if (m == null) continue;
            MitgliedsStatus s = m.getMitgliedsStatus();
            if (s == null) continue;
            // robust prüfen: entweder Enum-Name oder (falls vorhanden) die String-Repräsentation über getStatus()
            if ("GESTRICHEN".equalsIgnoreCase(s.name()) ||
                (s.getStatus() != null && "GESTRICHEN".equalsIgnoreCase(s.getStatus()))) {
                count++;
            }
        }
        return count;
    }
	
    // gibt die Anzahl der gekündigter Mitglieder weider
    
    public int getAnzahlGekuendigt() {
        List<Mitglied> l = getListe();
        if (l == null || l.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Mitglied m : l) {
            if (m == null) continue;
            MitgliedsStatus s = m.getMitgliedsStatus();
            if (s == null) continue;
            // robust prüfen: entweder Enum-Name oder (falls vorhanden) die String-Repräsentation über getStatus()
            if ("GEKUENDIGT".equalsIgnoreCase(s.name()) ||
                (s.getStatus() != null && "GEKUENDIGT".equalsIgnoreCase(s.getStatus()))) {
                count++;
            }
        }
        return count;
    }
    
   // gibt die Anzahl der Mitglieder mit undefiniertem Status
    
    public int getAnzahlUnbekannt() {
        List<Mitglied> l = getListe();
        if (l == null || l.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Mitglied m : l) {
            if (m == null) continue;
            MitgliedsStatus s = m.getMitgliedsStatus();
            if (s == null) continue;
            // robust prüfen: entweder Enum-Name oder (falls vorhanden) die String-Repräsentation über getStatus()
            if ("UNBEKANNT".equalsIgnoreCase(s.name()) ||
                (s.getStatus() != null && "UNBEKANNT".equalsIgnoreCase(s.getStatus()))) {
                count++;
            }
        }
        return count;
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