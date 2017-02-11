import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ServeurDeJeuEx extends UnicastRemoteObject implements ServeurDeJeu {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String login, mdp;
	Joueur monJoueur;
	File file = new File("D:/Eclipse/Jeu/src/baseDonnee.json");

	JSONParser parser = new JSONParser();

	public ServeurDeJeuEx() throws RemoteException {
	}

	public void creerJoueur(String login, String mdp) {
		try {
			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray joueursJ = (JSONArray) jsonObject.get("Joueurs");
			JSONObject joueur = new JSONObject();
			joueur.put("login", login);
			joueur.put("mdp", mdp);
			System.out.println(joueur.toString());
			joueursJ.add(joueur);
			PrintWriter writer = new PrintWriter(file);
			writer.write(obj.toString());
			writer.flush();
			writer.close();
			System.out.println("Bienvenue dans le jeu " + login);
			System.out.println(obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void authentification(String login, String mdp) throws ExceptionJoueurNonExistant, ExceptionMdpInconrrecte {
		boolean exist = false;
		String loginJoueur, mdpJoueur;
		try {
			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray joueursJ = (JSONArray) jsonObject.get("Joueurs");

			for (int i = 0; i < joueursJ.size(); i++) {

				JSONObject joueur = (JSONObject) joueursJ.get(i);
				loginJoueur = (String) joueur.get("login");
				mdpJoueur = (String) joueur.get("mdp");
				if (login.equals(loginJoueur))

				{
					if (mdp.equals(mdpJoueur)) {
						// Alert srAlert = (Alert)
						// Naming.lookup("rmi://localhost/Alert");
						// srAlert.envoyerString("Bienvenue dans le jeu " +
						// loginJoueur);
						exist = true;
						System.out.println("Bienvenue dans le jeu " + loginJoueur);
						break;
						// System.out.println("Votre nombre de point de vie
						// courant est: " + monJoueur.nbreDePtDeVieCourant);
						// System.out.println("Votre nombre de point de vie Max
						// est: " + monJoueur.nbreDePtDeVieMax);
					} else {
						throw new ExceptionMdpInconrrecte();
					}
				}
			}

			if (exist == false) {
				throw new ExceptionJoueurNonExistant();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * public void seDeplacer(Joueur joueur){ BufferedReader entree = new
	 * BufferedReader(new InputStreamReader(System.in)); char porte; int
	 * numPiece = joueur.numPieceCourante;
	 * System.out.println("Vers quel porte vous voulez se deplacer(E/N/O/S");
	 * 
	 * try { porte=(char)entree.read(); Object obj = parser.parse(new
	 * FileReader(file)); JSONObject jsonObject = (JSONObject) obj; JSONArray
	 * pieces = (JSONArray) jsonObject.get("Pieces");
	 * 
	 * for (int i = 0; i < pieces.size(); i++) {
	 * 
	 * JSONObject piece = (JSONObject) pieces.get(i);
	 * if((int)piece.get("numPiece")==numPiece){ JSONArray portes =
	 * (JSONArray)piece.get("portes"); JSONObject porteJ = (JSONObject)
	 * portes.ge if(porteJ.get("porte"+porte)){
	 * 
	 * } } } } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

}
