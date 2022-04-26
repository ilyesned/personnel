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
	
	@Test
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fl�chettes");
		assertEquals("Fl�chettes", ligue.getNom());
	}
	
	@Test
	void setNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		assertEquals("TestLigue", ligue.getNom());
		ligue.setNom("NewLigue");
		assertEquals("NewLigue", ligue.getNom());
	}
	
	@Test
	 public Employe getAdministrateur() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.getAdministrateur();
				return employe;
	}
	
	@Test
	void removeLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		int debut = gestionPersonnel.getLigues().size();
		ligue.remove();
		int fin = gestionPersonnel.getLigues().size();
		assertEquals(debut -1, fin);
	}
	
	@Test
	void compareToLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Ligue ligue1 = gestionPersonnel.addLigue("Testligue1");
		assertEquals(-32, ligue.compareTo(ligue1));
	}
	
	@Test
	void toStringLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		assertEquals("TestLigue", ligue.toString());
	}
}
