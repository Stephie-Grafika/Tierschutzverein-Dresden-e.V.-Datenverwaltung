package emissionsapp;

public class Account {
	private String name;
	private String passwort;
	
	// Getter und Setter für alle Attribute
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public Account(String name, String passwort) {
		super(); // Ruft den Konstruktor der Superklasse (Object) auf
		this.name = name;
		this.passwort = passwort;
	}
	public Account() {
		super();
	}
	
	/* Equals-Methode (vergleicht, ob 2 Objekte identisch sind) überschreiben, um Kombination Accountname & Passwort zu prüfen */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Account) {
			Account a = (Account)obj;
			if(a.getName().equals(this.name) && a.getPasswort().equals(this.passwort)) {
				return true;
			}
		}
		return false;
	}
}
