package Client;

import java.rmi.Naming;
import java.util.Scanner;
import Server_Labyrinthe.Server_L;

public class Utilisateur {
	String nomPersonnage;
	Grille grille;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Scanner str = new Scanner(System.in);
		Boolean Jouer = true;

		Server_L proxy = (Server_L) Naming.lookup("rmi://localhost:1099/ServeurLabyrinthe");

		System.out.println("Bienvenu sur le server Labyrinthe");

		while (true) {
			System.out.println("Pour jouer, vous devez créer un personnage.");
			System.out.println("Saisir le chiffre correspondant à votre souhait:");
			System.out.println("1: Créer un personnage");

			int i = sc.nextInt();

			switch (i) {
			case 1:
				Jouer= true;
				Grille jeu = new Grille(5, 5);
				System.out.println("Donner le nom de votre personnage:");
				String nom = str.nextLine();
				char initial = nom.charAt(0);
				if (proxy.creerPersonnage(nom)) {
					System.out.println("Le personnage " + nom + " a été créé !");
					System.out.println("La position actuelle de " + nom
							+ " dans le labyrinthe est representé par la lettre " + initial);
					jeu.initialiser(initial);
				}
				while (Jouer) {
					System.out.println("Saisir le chiffre correspondant à votre souhait:");
					System.out.println("1: Se deplacer");
					System.out.println("0: Quitter le jeu");

					i = sc.nextInt();
					if (i == 1) {
						char cmd;
						do {
							System.out.println("Quelle direction souhaitez vous (E,O,N,S):");
							String cmd_s = str.nextLine();
							cmd_s = cmd_s.toUpperCase();
							cmd = cmd_s.charAt(0);
							if (cmd == 'E' || cmd == 'S' || cmd == 'O' || cmd == 'N') {
								proxy.deplacer(nom, cmd);
								//
							} else {
								System.out.println("Votre commande n'a pas été comprise.");
							}
						} while ((cmd != 'E') && (cmd != 'S') && (cmd != 'O') && (cmd != 'N'));

					} else {
						Jouer = false;
					}
				}

				break;

			default:
				break;
			}
		}

	}

}
