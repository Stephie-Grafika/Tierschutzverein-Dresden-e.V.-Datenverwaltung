package mitgliedsdatenverwaltung;

import java.util.List;
import jakarta.persistence.*;

// Datenbankzugriff
public class EmissionDAO {
	
	 // Verwende eine einzige EntityManagerFactory während der gesamten Laufzeit
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("emissionPersistenceUnit");
    
    // Methode zum Laden aller Emissionen aus der Datenbank
    public List<Emission> findAll() {
        EntityManager entityManager = emf.createEntityManager(); // PA-Komponente für Zugriff auf Datenbank 
        Query abfrage = entityManager.createQuery("select e from Emission e"); //JPQL-Abfrage (Java Persistence Query Language)
        List<Emission> alleEmissionen = abfrage.getResultList(); //Speichern der Abfrageergebnisse in eine Liste
        entityManager.close();
        return alleEmissionen;
    }

    // Methode zum Speichern aller Emissionen in der Datenbank
    public void saveAll(List<Emission> emissionen) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            for (Emission emission : emissionen) {
            	entityManager.merge(emission);  // Neu speichern oder Aktualisieren jedes Emission-Objekts (ID-Abhängig)
            }
            transaction.commit(); 
        } finally {
        	entityManager.close();  // EntityManager schließen, auch wenn eine Exception auftritt, um Ressourcen freizugeben
        }
    }

    // Methode zum Hinzufügen einer neuen Emission zur Liste, über Speichern in Datenbank

    public void addEmission(List<Emission> emissionen) {
        Emission neueEmission = new Emission(); // Leeres Emission-Objekt erstellen
        int maxId = emissionen.stream().mapToInt(Emission::getID).max().orElse(0); // Sucht höchste ID, Standard 0 bei leerer Liste
        neueEmission.setID(maxId + 1); // ID definieren als höchste ID + 1
        emissionen.add(neueEmission); // Neues Objekt der Liste hinzufügen
    }
    
    // Methode zum Löschen einer Emission
    public void delete(Emission emission) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            // Lösch-Operation
            if (!entityManager.contains(emission)) {
                // Wenn das Entity nicht verwaltet wird, muss es geladen werden
                emission = entityManager.merge(emission);
            }
            entityManager.remove(emission); // Löschen der Emission
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Rollback bei Fehler
            }
            throw e; // Fehler erneut werfen
        } finally {
            entityManager.close();
        }
    }
    
    // Methode zum Schließen der EntityManagerFactory (optional)
    public static void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }    
}

