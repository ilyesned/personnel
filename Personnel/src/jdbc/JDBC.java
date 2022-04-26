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
	
	public int insert(Employe Employe) throws SauvegardeImpossible 
	{
		try 
		{
			PreparedStatement instruction;
			instruction = connection.prepareStatement("INSERT INTO employe (nomemploye,prenomemploye,mailemploye,abilitation,idligue, dateajout, datesuppr, mdpemployé) values(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
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
	
	
}
