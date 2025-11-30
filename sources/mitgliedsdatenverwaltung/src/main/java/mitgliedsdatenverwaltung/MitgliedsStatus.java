package mitgliedsdatenverwaltung;

public enum MitgliedsStatus {
    UNBEKANNT(""),
    AKTIV("aktiv"),
    KEINEZAHLUNG("keine Zahlung"),
    GESTRICHEN("gestrichen"),
    GEKUENDIGT("gekündigt");

    private String status;
    
    MitgliedsStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
