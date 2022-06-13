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
			System.out.println("Pilote JDBC non installï¿½.");
		}
		catch (SQLException e)
		{
			System.out.println(e);
			System.out.println("Connexion ï¿½chouï¿½e");
		}
	}
	
	@Override
	public GestionPersonnel getGestionPersonnel() 
	{
		//TODO ajouter le code permettant de charger la liste des employï¿½s
		GestionPersonnel gestionPersonnel = new GestionPersonnel();
		try 
		{
			String requete = "SELECT * FROM ligue";
			Statement instruction = connection.createStatement();
			ResultSet ligues = instruction.executeQuery(requete);
			while (ligues.next())
			{
				gestionPersonnel.addLigue(ligues.getInt("idligue"), ligues.getString("nomligue"));
				PreparedStatement request = connection.prepareStatement("SELECT * FROM employe WHERE idligue = ?");
                request.setInt(1, ligues.getInt("idligue"));
                ResultSet employe = request.executeQuery();
                Ligue ligue = gestionPersonnel.getLigues().last();
                
                while (employe.next()) {
                    int id = employe.getInt("idemploye");
                    String nom = employe.getString("nomemploye");
                    String prenom = employe.getString("prenomemploye");
                    String mail = employe.getString("mailemploye");
                    String password = employe.getString("mdpemployé");
                    LocalDate date_arrivee = employe.getDate("dateajout") != null ? LocalDate.parse(employe.getString("dateajout")) : null;
                    LocalDate date_depart = employe.getDate("datesuppr") != null ? LocalDate.parse(employe.getString("datesuppr")) : null;
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
	
	
	public int insert(Employe employe) throws SauvegardeImpossible 
	{
		try 
		{
			PreparedStatement instruction;
			
			instruction = connection.prepareStatement("INSERT INTO employe (nomemploye,prenomemploye,mailemploye,abilitation,idligue, dateajout, datesuppr, mdpemployé) values(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, employe.getNom());
			instruction.setString(2, employe.getPrenom());
			instruction.setString(3, employe.getMail());
			instruction.setInt(4, employe.getAbilitation());
			if(employe.getLigue() != null) {
				instruction.setInt(5, employe.getIdLigue());
			}else {
				instruction.setNull(5, employe.getIdLigue(), null);
			}
			instruction.setDate(6, employe.getDateCome() == null ? null : Date.valueOf(employe.getDateCome()));
			instruction.setDate(7, employe.getDateLeave() == null ? null : Date.valueOf(employe.getDateLeave()));
			instruction.setString(8, employe.getPassword());
			//TODO faire une verification pour savoir l'id de la ligue est null ou existant
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

	@Override
	public void deleteLigue(Ligue ligue) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		try
		{
			PreparedStatement listLigue;
			listLigue = connection.prepareStatement("DELETE FROM ligue WHERE idligue = ?");
			listLigue.setInt(1, ligue.getId());
			listLigue.executeUpdate();
			System.out.println("Ligue " + ligue.getNom() + " supprimÃ©");
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

	@Override
	public Employe getSuperAdmin(Employe root) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		return null;
	}
}
