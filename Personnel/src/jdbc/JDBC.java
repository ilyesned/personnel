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
		//TODO ajouter le code permettant de charger la liste des employés
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
                    String nom = employe.getString("nom_employe");
                    String prenom = employe.getString("prénom");
                    String mail = employe.getString("mail");
                    String password = employe.getString("password");
                    LocalDate date_arrivee = employe.getDate("date_d'entré") != null ? LocalDate.parse(employe.getString("date_d'entré")) : null;
                    LocalDate date_depart = employe.getDate("date_de_sortie") != null ? LocalDate.parse(employe.getString("date_de_sortie")) : null;
                    int type = employe.getType();
                    Employe employee = ligue.addEmploye(nom, prenom, mail, password, date_arrivee, date_depart,id);
                    if (employe.getBoolean("type")) {
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
			instruction = connection.prepareStatement("INSERT INTO employe (nomemploye,prenomemploye,mailemploye,abilitation,idligue, dateajout, datesuppr, mdpemploye) values(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			instruction.setDate(1, Employe.getDateCome() == null ? null : Date.valueOf(Employe.getDateCome()));
			instruction.setDate(2, Employe.getDateLeave() == null ? null : Date.valueOf(Employe.getDateLeave()));
			instruction.setString(3, Employe.getNom());
			instruction.setString(4, Employe.getPrenom());
			instruction.setString(5, Employe.getMail());
			instruction.setInt(6, Employe.getAbilitation());
			instruction.setInt(7, Employe.getId());
			instruction.setInt(8, Employe.getIdLigue());
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
}
