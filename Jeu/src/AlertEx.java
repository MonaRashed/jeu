import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AlertEx extends UnicastRemoteObject implements Alert{
	private static final long serialVersionUID = 1L;
	public AlertEx()throws RemoteException {
		// TODO Auto-generated constructor stub
	}
public void envoyerString(String texte){
		System.out.println(texte);
	}
}
