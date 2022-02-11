package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import personnel.*;

class testEmploye {
<<<<<<< HEAD
	
=======
>>>>>>> 3283cb854806280688343dfffece46a7f8257dca
	
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void createLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		assertEquals("Flechettes", ligue.getNom());
	}

	
}
