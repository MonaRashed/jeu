import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServeurD {

	public ServeurD() {

	}

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
		} catch (RemoteException e1) {
			
		}
		try {
			ServeurDiscussionEx serveurD = new ServeurDiscussionEx();
			Naming.rebind("Discussion", serveurD);
			System.out.println("Serveur Discussion");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
