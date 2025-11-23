package mitgliedsdatenverwaltung;

import java.util.List;
import jakarta.persistence.*;

//Datenbankzugriff
public class MitgliedDAO {
	
	 // Verwende eine einzige EntityManagerFactory während der gesamten Laufzeit
   private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("mitgliedPersistenceUnit");
   
   // Methode zum Laden aller Emissionen aus der Datenbank
   public List<Mitglied> findAll() {
       EntityManager entityManager = emf.createEntityManager(); // PA-Komponente für Zugriff auf Datenbank 
       Query abfrage = entityManager.createQuery("select e from Mitglied e"); //JPQL-Abfrage (Java Persistence Query Language)
       List<Mitglied> alleMitglieder = abfrage.getResultList(); //Speichern der Abfrageergebnisse in eine Liste
       entityManager.close();
       return alleMitglieder;
   }

   // Methode zum Speichern aller Mitglieder in der Datenbank
   public void saveAll(List<Mitglied> mitglieder) {
       EntityManager entityManager = emf.createEntityManager();
       EntityTransaction transaction = entityManager.getTransaction();

       try {
           transaction.begin();
           for (Mitglied mitglied : mitglieder) {
           	entityManager.merge(mitglied);  // Neu speichern oder Aktualisieren jedes Mitglied-Objekts (ID-Abhängig)
           }
           transaction.commit(); 
       } finally {
       	entityManager.close();  // EntityManager schließen, auch wenn eine Exception auftritt, um Ressourcen freizugeben
       }
   }

   // Methode zum Hinzufügen eines neuen Mitglieds zur Liste, über Speichern in Datenbank

   public void addMitglied(List<Mitglied> mitglieder) {
	   Mitglied neuesMitglied = new Mitglied(); // Leeres Emission-Objekt erstellen
       int maxId = mitglieder.stream().mapToInt(Mitglied::getMitgliedsID).max().orElse(0); // Sucht höchste ID, Standard 0 bei leerer Liste
       neuesMitglied.setMitgliedsID(maxId + 1); // ID definieren als höchste ID + 1
       mitglieder.add(neuesMitglied); // Neues Objekt der Liste hinzufügen
   }
   
   // Methode zum Löschen von Mitglied
   public void delete(Mitglied mitglied) {
       EntityManager entityManager = emf.createEntityManager();
       EntityTransaction transaction = entityManager.getTransaction();

       try {
           transaction.begin();
           // Lösch-Operation
           if (!entityManager.contains(mitglied)) {
               // Wenn das Entity nicht verwaltet wird, muss es geladen werden
        	   mitglied = entityManager.merge(mitglied);
           }
           entityManager.remove(mitglied); // Löschen von Mitglied
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

