package Client;

import java.rmi.Naming;
import java.util.Scanner;
import Server_Labyrinthe.Server_L;

public class Utilisateur {
	String nomPersonnage;
	Grille grille;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Server_L proxy = (Server_L) Naming.lookup("rmi://localhost:1099/ServeurLabyrinthe");
		System.out.println("Bienvenu sur le server Labyrinthe");
		System.out.println("Pour jouer, vous devez créer un personnage.");
		System.out.println("Saisir le chiffre correspondant à votre souhait:");
		System.out.println("1: Créer un personnage");
		System.out.println("0: Quitter le jeu");

		int i = sc.nextInt();
		switch (i) {
		case 1:
			System.out.println("Donner le nom de votre personnage:");
			String nom = sc.nextLine();
			if (proxy.creerPersonnage(nom)) {
				System.out.println("Le personnage "+nom+" a été créé !");
			}
			break;

		default:
			break;
		}

	
	}

}
