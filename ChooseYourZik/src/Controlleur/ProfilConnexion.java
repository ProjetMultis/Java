package Controlleur;

public class ProfilConnexion 
{
	private String email, mdp, nom, prenom;
	private boolean permission;
	
	public ProfilConnexion(String email, String mdp, String nom, String prenom, boolean permission)
	{
		this.email = email;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.permission = permission;
		
	
	}
}
