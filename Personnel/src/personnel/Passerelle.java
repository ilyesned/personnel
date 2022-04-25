package personnel;

public interface Passerelle 
{
	public GestionPersonnel getGestionPersonnel();
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel)  throws SauvegardeImpossible;
	/* insertion ligue */
	public int insert(Ligue ligue) throws SauvegardeImpossible;
	/* suppression ligue*/
	public void deleteLigue(Ligue ligue) throws SauvegardeImpossible ;
	/* insertion employee */
	public int insert(Employe employe) throws SauvegardeImpossible;
	/* suppression employe */
	public void deleteEmploye(Employe employe) throws SauvegardeImpossible;
	/* changer employe par l'Admin */
	public void setAdmin(Employe employe)  throws SauvegardeImpossible;
	
}
