package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import personnel.*;

class testEmploye {
	
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void createLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		assertEquals("Flechettes", ligue.getNom());
	}

	
}
