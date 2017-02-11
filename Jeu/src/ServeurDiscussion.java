import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServeurDiscussion extends Remote {
public void discuter(Piece piece, String texte,Joueur joueur)throws RemoteException;
}
