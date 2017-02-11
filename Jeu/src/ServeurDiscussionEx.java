import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class ServeurDiscussionEx extends UnicastRemoteObject implements ServeurDiscussion{

	private static final long serialVersionUID = 1L;

	public ServeurDiscussionEx()  throws RemoteException {
		// TODO Auto-generated constructor stub
		super();
	}
	public void discuter(Piece piece, String texte,Joueur joueur){
		Date maDate = new Date();   
		System.out.println(maDate.toString()+ "***"+joueur.nomPersonne +"***");
		System.out.println(texte);
	}
}
