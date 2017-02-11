import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.util.Scanner;
import java.rmi.Naming;
//import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
//import java.util.Scanner;
import java.util.Date;

public class Client {

	public static void main(String[] args) {// throws MalformedURLException,
											// RemoteException,
											// NotBoundException,
											// ExceptionMdpInconrrecte,
											// ExceptionJoueurNonExistant {
		String login, mdp;
		char c;
	
		try {
			ServeurDeJeu srJeu = (ServeurDeJeu) Naming.lookup("rmi://localhost/Jeu");
			//ServeurDiscussion srDiscussion = (ServeurDiscussion) Naming.lookup("rmi://localhost/Discussion");
			//AlertEx alert= new AlertEx();
			//Naming.rebind("Alert",alert);
			
			BufferedReader entreec = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Vous êtes un nouveau joueur?(o/n)");
			c=(char)entreec.read();
			if(c=='n'){
			System.out.println("Veuillez saisir ton login");
			login = entree.readLine();
			System.out.println("Veuillez saisir ton mot de passe");
			mdp = entree.readLine();
			srJeu.authentification(login, mdp);

		} else if(c=='o'){
			System.out.println("Veuillez saisir un login");
			login=entree.readLine();
			System.out.println("Veuillez saisir un mot de passe");
			mdp=entree.readLine();
			srJeu.creerJoueur(login, mdp);
			
		}
		else
		{
			throw new ExceptionSaisie();
		}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
