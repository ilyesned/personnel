package testsUnitaires;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import personnel.*;

class testEmploye {

	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();

	@Test
	void testEstAdmin() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
		Employe employe = ligue.addEmploye("Ilyes", "Nedjai", "ily@ned.com", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06")); 
		assertFalse(employe.estAdmin(ligue));
		ligue.setAdministrateur(employe);
		assertTrue(employe.estAdmin(ligue));
	}
	
	@Test
	void testGetNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
		Employe employe = ligue.addEmploye("Ilyes", "Nedjai", "ily@ned.com", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
		assertEquals("Nedjai", employe.getNom());
	}
	
	@Test
	void testSetNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
		Employe employe = ligue.addEmploye("Ilyes", "Nedjai", "ily@ned.com", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
		employe.setNom("iajdeN");
		assertEquals("iajdeN", employe.getNom());
	}
	
	@Test
	void testGetPrenom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
		Employe employe = ligue.addEmploye("Ilyes", "Nedjai", "ily@ned.com", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
		assertEquals("Ilyes", employe.getPrenom());
	}
	
	@Test
	void testSetPrenom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
		Employe employe = ligue.addEmploye("Ilyes", "Nedjai", "ily@ned.com", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
		employe.setPrenom("seylI");
		assertEquals("seylI", employe.getPrenom());
	}
	
	@Test
	void testGetMail() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
		Employe employe = ligue.addEmploye("Ilyes", "Nedjai", "ily@ned.com", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
		assertEquals("ily@ned.com", employe.getMail());
	}
	
	@Test
	void testSetMail() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
		Employe employe = ligue.addEmploye("Ilyes", "Nedjai", "ily@ned.com", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
		employe.setMail("jalal@gmail.com");
		assertEquals("jalal@gmail.com", employe.getMail());
	}
	
	@Test
	void testCheckPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
		Employe employe = ligue.addEmploye("Ilyes", "Nedjai", "ily@ned.com", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
		assertFalse(employe.checkPassword("ABCDE"));
		assertTrue(employe.checkPassword("12345"));
	}
	
	@Test
	void testSetPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
		Employe employe = ligue.addEmploye("Ilyes", "Nedjai", "ily@ned.com", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
		employe.setPassword("67890");
		assertFalse(employe.checkPassword("ABCDE"));
		assertTrue(employe.checkPassword("67890"));
	}
	
	@Test
	void testGetLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
		Employe employe = ligue.addEmploye("Ilyes", "Nedjai", "ily@ned.com", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
		assertEquals(ligue, employe.getLigue());
	}
	
	@Test
	void TestToString() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
		Employe employe = ligue.addEmploye("Ilyes", "Nedjai", "ily@ned.com", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
		Employe root = gestionPersonnel.getRoot();
	}
	
	
	
	
	
	
	
	
	
	
	
}
