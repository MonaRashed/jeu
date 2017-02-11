import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServeurDeJeu extends Remote{
	public void creerJoueur(String login, String mdp) throws RemoteException;
	public void authentification(String login,String mdp) throws RemoteException,ExceptionJoueurNonExistant,ExceptionMdpInconrrecte;
	//public void seDeplacer(Joueur joueur);
	
	
}
