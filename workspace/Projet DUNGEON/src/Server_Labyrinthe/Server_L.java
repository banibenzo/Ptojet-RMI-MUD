package Server_Labyrinthe;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server_L extends Remote {
	public Boolean creerPersonnage(String nomPers) throws RemoteException;

	public String deplacer(String nom, char cmd) throws RemoteException;

	public String getPosition(String nomPers) throws RemoteException;

}
