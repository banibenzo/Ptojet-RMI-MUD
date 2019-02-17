package Client;

import java.rmi.Naming;

import Server_Labyrinthe.Server_L;

public class Utilisateur {
	String nomPersonnage;
	Grille grille;
public static void main(String[] args) throws Exception {
	Server_L proxy = (Server_L) Naming.lookup("rmi://localhost:1900/ServeurLabyrinthe");

}

}
