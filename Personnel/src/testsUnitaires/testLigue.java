package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();

	@Test
	void createLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		assertEquals("Flechettes", ligue.getNom());
	}

	@Test
	void addEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "azerty", null, null); 
		assertEquals(employe, ligue.getEmployes().first());
	}

	
}
