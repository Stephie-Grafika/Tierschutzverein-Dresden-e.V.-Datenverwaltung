package mitgliedsdatenverwaltung;

public enum ZahlArt {
	UNDEFINIERT("Zahlart"),
	ABBUCHUNG("Abbuchung"),
	DAUERAUFTRAG("Dauerauftrag"),
	PAYPAL("PayPal"),
	UEBERWEISUNG("Überweisung"),
	KEINEZAHLUNG("keine Zahlung");

    private String zahlung;
    
    ZahlArt(String zahlung) {
        this.zahlung = zahlung;
    }

    public String getZahlung() {
        return zahlung;
    }

}