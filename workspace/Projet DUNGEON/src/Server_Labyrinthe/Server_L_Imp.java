package Server_Labyrinthe;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class Server_L_Imp extends UnicastRemoteObject implements Server_L  {
HashMap<String, Personnage> personnages;
Labyrinthe labyrinthe;
	
	public Server_L_Imp() throws RemoteException {
	super();
	this.personnages = new HashMap<String, Personnage>();
	this.labyrinthe = new Labyrinthe();
}

	public synchronized Boolean creerPersonnage(String nomPers) throws RemoteException{
	
	}

	public synchronized String deplacer(String nom, char cmd) throws RemoteException {
		
	}
	
	public synchronized String getPosition(String nomPers) throws RemoteException {
		
	}
	
	public static void main(String[] args) throws Exception {
		LocateRegistry.createRegistry(1900);
		Naming.rebind("ServeurLabyrinthe", new Server_L_Imp());
		System.out.println("Le serveur de Labyrinthe est enrégistré");
	}

}
