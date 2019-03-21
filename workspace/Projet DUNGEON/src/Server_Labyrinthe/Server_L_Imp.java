package Server_Labyrinthe;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class Server_L_Imp extends UnicastRemoteObject implements Server_L {

	// Liste des personnages dans le jeu
	HashMap<String, Personnage> personnages;
	// Le labyrinthe g�r�
	Labyrinthe labyrinthe;

	public Server_L_Imp() throws RemoteException {
		super();
		this.personnages = new HashMap<String, Personnage>();
		this.labyrinthe = new Labyrinthe(5);
	}

	public synchronized Boolean creerPersonnage(String nomPers) throws RemoteException {
		Boolean creationOK = false;
		// Cr�ation de la position initial
		Position posInit = new Position(4, 1);
		// Cr�ation du personnage
		Personnage personnage = new Personnage(nomPers, posInit);
		// ajout dans la liste des personnages dans le jeu
		personnages.put(personnage.nom, personnage);
		// ajout dans la liste des personnages dans la pi�ce de depart
		if (labyrinthe.Ajout_Piece_Initiale(personnage)) {
			System.out.println("Nouveau personnage " + personnage.nom + " � l'entr�e du labyrinthe !");
			creationOK = true;
		}
		return creationOK;
	}

	public synchronized String deplacer(String nom, char cmd) throws RemoteException {
		String message;
		// R�cuperer le personnage
		Personnage p = this.personnages.get(nom);
		// deplacement
		boolean deplacerOk = this.labyrinthe.deplacer(p, cmd);
		if (deplacerOk) {
			message = "1 " + p.toString();
		} else {
			message = "2 D�placement impossible";
		}
		return message;
	}

	public synchronized String getPosition(String nomPers) throws RemoteException {
		//recup�rer le personnage
		Personnage p = personnages.get(nomPers);
		//recuperer sa position 
		Position position =p.getPos();
		return position.toString();
	}

	public static void main(String[] args) throws Exception {
		LocateRegistry.createRegistry(1099);
		Naming.rebind("ServeurLabyrinthe", new Server_L_Imp());
		System.out.println("Le serveur de Labyrinthe est enr�gistr�");
	}

}
