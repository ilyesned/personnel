package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;

import personnel.*;

public class JDBC implements Passerelle 
{
	Connection connection;

	public JDBC()
	{
		System.out.println("Connexion en cours");
		try
		{
			Class.forName(Credentials.getDriverClassName());
			connection = DriverManager.getConnection(Credentials.getUrl(), Credentials.getUser(), Credentials.getPassword());
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Pilote JDBC non install�.");
		}
		catch (SQLException e)
		{
			System.out.println(e);
			System.out.println("Connexion �chou�e");
		}
	}
	
	@Override
	public GestionPersonnel getGestionPersonnel() 
	{
		//TODO ajouter le code permettant de charger la liste des employ�s
		GestionPersonnel gestionPersonnel = new GestionPersonnel();
		try 
		{
			String requete = "select * from ligue";
			Statement instruction = connection.createStatement();
			ResultSet ligues = instruction.executeQuery(requete);
			while (ligues.next())
			{
				gestionPersonnel.addLigue(ligues.getInt(1), ligues.getString(2));
				PreparedStatement request = connection.prepareStatement("SELECT * FROM employe WHERE idligue = ?");
                request.setInt(1, ligues.getInt("idligue"));
                ResultSet employe = request.executeQuery();
                Ligue ligue = gestionPersonnel.getLigues().last();
                
                while (employe.next()) {
                    int id = employe.getInt("idemploye");
<<<<<<< HEAD
                    String nom = employe.getString("nomemploye");
                    String prenom = employe.getString("prenomemploye");
                    String mail = employe.getString("mailemploye");
                    String password = employe.getString("mdpemploy�");
                    LocalDate date_arrivee = employe.getDate("dateajout") != null ? LocalDate.parse(employe.getString("dateajout")) : null;
                    LocalDate date_depart = employe.getDate("datesuppr") != null ? LocalDate.parse(employe.getString("datesuppr")) : null;
=======
                    String nom = employe.getString("nom_employe");
                    String prenom = employe.getString("pr�nom");
                    String mail = employe.getString("mail");
                    String password = employe.getString("password");
                    LocalDate date_arrivee = employe.getDate("date_d'entr�") != null ? LocalDate.parse(employe.getString("date_d'entr�")) : null;
                    LocalDate date_depart = employe.getDate("date_de_sortie") != null ? LocalDate.parse(employe.getString("date_de_sortie")) : null;
>>>>>>> b13b03a965751cc4bfd3d79ff25bb98fa000dc15
                    int type = employe.getType();
                    Employe employee = ligue.addEmploye(nom, prenom, mail, password, date_arrivee, date_depart,id);
                    if (employe.getBoolean("abilitation")) {
                        ligue.setAdministrateur(employee);
                    }
                }
			}
			
			String requeteEmpl = "select * from employe";
			Statement instructionEmpl = connection.createStatement();
			ResultSet employe = instructionEmpl.executeQuery(requeteEmpl);
			while (employe.next()){
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return gestionPersonnel;
	}

	@Override
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible 
	{
		close();
	}
	
	public void close() throws SauvegardeImpossible
	{
		try
		{
			if (connection != null)
				connection.close();
		}
		catch (SQLException e)
		{
			throw new SauvegardeImpossible(e);
		}
	}
	
	@Override
	public int insert(Ligue ligue) throws SauvegardeImpossible 
	{
		try 
		{
			PreparedStatement instruction;
			instruction = connection.prepareStatement("insert into ligue (nomligue) values(?)", Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, ligue.getNom());		
			instruction.executeUpdate();
			ResultSet id = instruction.getGeneratedKeys();
			id.next();
			return id.getInt(1);
		} 
		catch (SQLException exception) 
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}		
	}
	
	public int insert(Employe Employe) throws SauvegardeImpossible 
	{
		try 
		{
			PreparedStatement instruction;
			instruction = connection.prepareStatement("INSERT INTO employe (nomemploye,prenomemploye,mailemploye,abilitation,idligue, dateajout, datesuppr, mdpemploy�) values(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			instruction.setDate(6, Employe.getDateCome() == null ? null : Date.valueOf(Employe.getDateCome()));
			instruction.setDate(7, Employe.getDateLeave() == null ? null : Date.valueOf(Employe.getDateLeave()));
			instruction.setString(1, Employe.getNom());
			instruction.setString(2, Employe.getPrenom());
			instruction.setString(3, Employe.getMail());
			instruction.setInt(4, Employe.getAbilitation());
			instruction.setInt(8, Employe.getId());
			//TODO faire une verification pour savoir l'id de la ligue est null ou existant
			if(Employe.getLigue() != null) {
				instruction.setInt(5, Employe.getIdLigue());
			}else {
				instruction.setNull(5, Employe.getIdLigue(), null);
			}
			instruction.executeUpdate();
			ResultSet id = instruction.getGeneratedKeys();
			id.next();
			return id.getInt(1);
		} 
		catch (SQLException exception) 
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}		
	}
<<<<<<< HEAD
	
	
=======

	@Override
	public void deleteLigue(Ligue ligue) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		try
		{
			PreparedStatement listLigue;
			listLigue = connection.prepareStatement("DELETE FROM ligue WHERE idligue = ?");
			listLigue.setInt(1, ligue.getId());
			listLigue.executeUpdate();
			System.out.println("Ligue " + ligue.getNom() + " supprimé");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
		
	}

	@Override
	public void deleteEmploye(Employe employe) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		try
		{
			PreparedStatement listEmploye;
			listEmploye = connection.prepareStatement("DELETE FROM employe WHERE idemploye = ?");
			listEmploye.setInt(1, employe.getId());
			listEmploye.executeUpdate();
			System.out.println("Employe " + employe.getNom() + " supprimé");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
	}

	@Override
	public void setAdmin(Employe employe) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		try 
		{
			PreparedStatement listEmploye;
			listEmploye = connection.prepareStatement("UPDATE employe SET admin = ? WHERE idligue = ? AND idemploye = ?");
			listEmploye.setInt(1, 1);
			listEmploye.setInt(2, employe.getLigue().getId());
			listEmploye.setInt(3, employe.getId());
			listEmploye.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
	}
>>>>>>> b13b03a965751cc4bfd3d79ff25bb98fa000dc15
}
