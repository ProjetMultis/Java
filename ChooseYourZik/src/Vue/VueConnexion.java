package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controlleur.Main;
import Controlleur.ProfilConnexion;
import Modele.ModeleConnexion;

public class VueConnexion extends JPanel implements ActionListener, KeyListener 	
{
	private JLabel eml = new JLabel("email");
	private JLabel mdp = new JLabel("Mdp");
	
	private JTextField txtemail = new JTextField();
	private JPasswordField txtmdp = new JPasswordField();
	
	private ArrondirBoutton btAnnuler = new ArrondirBoutton(" Annuler");
	private ArrondirBoutton btseConnecter = new ArrondirBoutton("Se connecter");
	private ArrondirBoutton btInscription = new ArrondirBoutton("Inscription");
	
	public VueConnexion()
	{
		this.setBounds(80, 40, 550, 350); //('', '','largeur', 'longeur')
		this.setLayout(null); //colonne - ligne
		
		Font tailleTexte = new Font("Comic Sans MS", Font.BOLD, 17);
		
		
		//visuel connexion
		eml.setBounds(270, 98, 200, 20);
		eml.setFont(tailleTexte);
		this.add(this.eml);
		txtemail.setBounds(193, 120, 200, 25);
		this.add(this.txtemail);
		
		mdp.setBounds(270, 168, 200, 20);
		mdp.setFont(tailleTexte);
		this.add(this.mdp);
		txtmdp.setBounds(193, 190, 200, 25);
		this.add(this.txtmdp);
		
		btInscription.setBounds(20, 270, 140, 40);
		this.add(btInscription);
		btseConnecter.setBounds(210, 270, 140, 40);
		this.add(this.btseConnecter);
		btAnnuler.setBounds(400, 270, 140, 40);
		this.add(this.btAnnuler);
		
		JFrame frame = new JFrame();	
		
		
		this.btseConnecter.setIcon(new ImageIcon(""));
		
		//rendre les boutons cliquable
		this.btAnnuler.addActionListener(this);
		this.btseConnecter.addActionListener(this); //ActionListener : evenement cliquable
		this.txtmdp.addKeyListener(this); //ajouter ecoute frappe de touche
		
		this.setVisible(true);
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.btAnnuler) //réinitialisation bouton annuler
		{
			this.txtemail.setText("");
			this.txtmdp.setText("");
			
		}
		else if (e.getSource() == this.btseConnecter) //récupération donnée puis insertion
		{
			this.actionConnexion();
		}
		
	}
	

	public void actionConnexion()
	{
		String email = this.txtemail.getText(); //equivalent en php à $reference = $_POST['reference'];
		String mdp = new String(this.txtmdp.getPassword());
		ProfilConnexion unProfil = ModeleConnexion.selectWhere(email, mdp);
		
		if(unProfil == null) //erreur de l'identification du formulaire
		{
			JOptionPane.showMessageDialog(this, "Erreur d'identification");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Bonjour ");
			this.txtemail.setText("");
			this.txtmdp.setText("");
			
			new Fenetre_principal(unProfil);
			Connexion.rendreVisible(false);
			Main.rendreVisible(false);
			
		}
	}

}
