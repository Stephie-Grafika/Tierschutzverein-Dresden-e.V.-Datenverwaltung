package mitgliedsdatenverwaltung;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MitgliedsStatusTest {

	@Test
	void aktivHatKorrektenAnzeigetext() {
		assertEquals("aktiv", MitgliedsStatus.AKTIV.getStatus());
	}

	@Test
	void gekuendigtHatKorrektenAnzeigetext() {
		assertEquals("gekündigt", MitgliedsStatus.GEKUENDIGT.getStatus());
	}

	@Test
	void unbekanntHatLeerenAnzeigetext() {
		assertEquals("", MitgliedsStatus.UNBEKANNT.getStatus());
	}
}