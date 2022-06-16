package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.time.LocalDate;

import java.util.ArrayList;

import commandLineMenus.List;
import commandLineMenus.Menu;
import commandLineMenus.Option;

import personnel.*;

public class LigueConsole 
{
	private GestionPersonnel gestionPersonnel;
	private EmployeConsole employeConsole;

	public LigueConsole(GestionPersonnel gestionPersonnel, EmployeConsole employeConsole)
	{
		this.gestionPersonnel = gestionPersonnel;
		this.employeConsole = employeConsole;
	}

	Menu menuLigues()
	{
		Menu menu = new Menu("Gérer les ligues", "l");
		menu.add(afficherLigues());
		menu.add(ajouterLigue());
		menu.add(selectionnerLigue());
		menu.addBack("q");
		return menu;
	}

	private Option afficherLigues()
	{
		return new Option("Afficher les ligues", "l", () -> {System.out.println(gestionPersonnel.getLigues());});
	}

	private Option afficher(final Ligue ligue)
	{
		return new Option("Afficher la ligue", "l", 
				() -> 
				{
					System.out.println(ligue);
					System.out.println("administre par " + ligue.getAdministrateur());
				}
		);
	}
	private Option afficherEmployes(final Ligue ligue)
	{
		return new Option("Afficher les employes", "l", () -> {
			
			for (Employe employes: ligue.getEmployes())
			System.out.println(employes);
			
			if(ligue.getEmployes().size() == 0)
			{
				System.out.println("Il n'y a aucun employe dans cette ligue");
			}
		});
	}

	private Option ajouterLigue()
	{
		return new Option("Ajouter une ligue", "a", () -> 
		{
			try
			{
				gestionPersonnel.addLigue(getString("nom : "));
			}
			catch(SauvegardeImpossible exception)
			{
				System.err.println("Impossible de sauvegarder cette ligue");
			}
		});
	}
	
	private Menu editerLigue(Ligue ligue)
	{
		Menu menu = new Menu("Editer " + ligue.getNom());
		menu.add(afficher(ligue));
		menu.add(gererEmployes(ligue));
		menu.add(changerAdministrateur(ligue));
		menu.add(changerNom(ligue));
		menu.add(supprimer(ligue));
		menu.addBack("q");
		return menu;
	}

	private Option changerNom(final Ligue ligue)
	{
		return new Option("Renommer", "r", 
				() -> {ligue.setNom(getString("Nouveau nom : "));
				System.out.println("La ligue a bien été renommee par" + ligue.getNom());
				});
	}

	private List<Ligue> selectionnerLigue()
	{
		return new List<Ligue>("Sélectionner une ligue", "e", 
				() -> new ArrayList<>(gestionPersonnel.getLigues()),
				(element) -> editerLigue(element)
				);
	}
	
	private Option ajouterEmploye(final Ligue ligue)
	{
		return new Option("ajouter un employe", "a",
				() -> 
				{	
					System.out.println("Ajouter un employe");
					ligue.addEmploye(getString("nom : "), 
						getString("prenom : "), 
						getString("mail : "), 
						getString("password : "),
						LocalDate.parse(getString("Date d'ajout (YYYY-MM-DD):")), LocalDate.parse(getString("Date de suppression (YYYY-MM-DD) : ")));
				}
		);
		
	}
	
	private Menu gererEmployes(Ligue ligue)
	{
		Menu menu = new Menu("Gerer les employes de " + ligue.getNom(), "e");
		menu.add(afficherEmployes(ligue));
		menu.add(ajouterEmploye(ligue));
		menu.add(modifierEmploye(ligue));
		menu.add(supprimerEmploye(ligue));
		menu.addBack("q");
		return menu;
	}

	private List<Employe> supprimerEmploye(final Ligue ligue)
	{
		return new List<>("Supprimer un employe", "s", 
				() -> new ArrayList<>(ligue.getEmployes()),
				(index, element) -> {try {
					element.remove();
				} catch (SauvegardeImpossible e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
				);
	}
	
	private List<Employe> changerAdministrateur(final Ligue ligue)
	{

		Employe employe = ligue.getAdministrateur();
		return new List<>("Changer l'admin", "a", 					
			() -> new ArrayList<>(ligue.getEmployes()),
			(index, element) -> {
				ligue.setAdministrateur(element);}
			);
			
	}

	private List<Employe> modifierEmploye(final Ligue ligue)
	{
		return new List<>("Modifier un employe", "e", 
				() -> new ArrayList<>(ligue.getEmployes()),
				employeConsole.editerEmploye()
				);
	}

	private Option supprimer(Ligue ligue)
	{
		return new Option("Supprimer", "d", () -> {
			try {
				ligue.remove();
			} catch (SauvegardeImpossible e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}});
	}
	
}
