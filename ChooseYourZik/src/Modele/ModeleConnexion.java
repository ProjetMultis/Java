package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controlleur.ProfilConnexion;

public class ModeleConnexion 
{
	public static ProfilConnexion selectWhere(String email,  String Mdp)
	{
		String requete = "select * "
				+"from user "
				+"where email = '"+ email + "' "
				+"and mdp = '" + Mdp + "'";

		ProfilConnexion unProfil = null;
		try
		{
			BDD uneBDD = new BDD("localhost", "restline", "root", "");
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaconnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
	
			if(unRes.next())
			{
		
				String login = unRes.getString("email");
				String Nom = unRes.getString("nom");
				String Prenom = unRes.getString("prenom");
				String mdp = unRes.getString("Mdp");
				boolean Permission = unRes.getBoolean("permission");
		
				unProfil = new ProfilConnexion(login, mdp, Nom, Prenom,Permission);
			}
			unStat.close();
			uneBDD.seDeconnecter();
			unRes.close();
		}	
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : " + requete);
		}

		return unProfil;
		}
	
}
