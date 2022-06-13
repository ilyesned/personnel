package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getString;


import java.time.LocalDate;

import commandLineMenus.ListOption;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import personnel.Employe;
import personnel.Ligue;
import personnel.SauvegardeImpossible;

public class EmployeConsole 
{
	private Option afficher(final Employe employe)
	{
		return new Option("Afficher l'employé", "l", () -> {System.out.println(employe);});
	}

	ListOption<Employe> editerEmploye()
	{
		return (employe) -> editerEmploye(employe);		
	}

	Option editerEmploye(Employe employe)
	{
			Menu menu = new Menu("Gérer le compte " + employe.getNom(), "c");
			menu.add(afficher(employe));
			menu.add(changerNom(employe));
			menu.add(changerPrenom(employe));
			menu.add(changerMail(employe));
			menu.add(changerPassword(employe));
			menu.add(changerDateAjout(employe));
			menu.add(changerDateSuppr(employe));
			menu.add(administrer(employe));
			menu.add(supprimerEmploye(employe));
			menu.addBack("q");
			return menu;
	}

	private Option changerNom(final Employe employe)
	{
		return new Option("Changer le nom", "n", 
				() -> {employe.setNom(getString("Nouveau nom : "));}
			);
	}
	
	private Option changerPrenom(final Employe employe)
	{
		return new Option("Changer le prÃ©nom", "p", () -> {employe.setPrenom(getString("Nouveau prÃ©nom : "));});
	}
	
	private Option changerMail(final Employe employe)
	{
		return new Option("Changer le mail", "e", () -> {employe.setMail(getString("Nouveau mail : "));});
	}
	
	private Option changerPassword(final Employe employe)
	{
		return new Option("Changer le password", "x", () -> {employe.setPassword(getString("Nouveau password : "));});
	}
	
	private Option changerDateAjout(final Employe employe) 
	{
		return new Option("Changer la date d'arrivee", "m", () -> {employe.setDateCome(LocalDate.parse(getString("Nouvelle date : ")));});
	}
	
	private Option changerDateSuppr(final Employe employe) 
	{
		return new Option("Changer la date de depart", "s", () -> {employe.setDateLeave(LocalDate.parse(getString("Nouvelle date : ")));});
	}
	
	private Option administrer(final Employe employe)
	{
		Ligue ligue = employe.getLigue();
		return new Option("Administrateur de la ligue", "c", () -> {ligue.setAdministrateur(employe);});
	}
	
	private Option supprimerEmploye(final Employe employe) {
		return new Option("supprimer", "r", () -> {try {
			employe.remove();
		} catch (SauvegardeImpossible e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
	}
}
