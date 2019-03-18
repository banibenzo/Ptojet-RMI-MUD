package Client;

import java.rmi.Naming;
import java.util.Scanner;
import Server_Labyrinthe.Server_L;

public class Utilisateur {
	String nomPersonnage;
	Grille grille;

	// methode creation de personnage

	// methode de deplacement dans le labyrinthe

	public static void main(String[] args) throws Exception {

		// Entrées claviers
		Scanner sc = new Scanner(System.in);
		Scanner str = new Scanner(System.in);

		Boolean Jouer = true;

		// récuperation de la souche cliente
		Server_L proxy = (Server_L) Naming.lookup("rmi://localhost:1099/ServeurLabyrinthe");

		// Message d'acceuil sur le serveur de jeu gerant le labyrinthe
		System.out.println("Bienvenu sur le server Labyrinthe");
		while (true) {
			System.out.println("Pour jouer, vous devez créer un personnage.");
			System.out.println("Saisir le chiffre correspondant à votre souhait:");
			System.out.println("1: Créer un personnage");

			int i = sc.nextInt();

			switch (i) {

			// Option de création de personnage
			case 1:
				Jouer = true;
				// création de la grille de jeu à afficher
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

				// *****Tours de jeu******
				while (Jouer) {
					// Menu des opérations proposées par le serveur Labyrinthe
					System.out.println("Saisir le chiffre correspondant à votre souhait:");
					System.out.println("1: Se deplacer");
					System.out.println("0: Quitter le jeu");

					i = sc.nextInt();

					// Option de deplacement du personnage dans le labyrinthe
					if (i == 1) {
						char cmd;
						do {
							String[] res;
							System.out.println("Quelle direction souhaitez vous (E,O,N,S):");
							String cmd_s = str.nextLine();
							cmd_s = cmd_s.toUpperCase();
							cmd = cmd_s.charAt(0);
							if (cmd == 'E' || cmd == 'S' || cmd == 'O' || cmd == 'N') {
								String message = proxy.deplacer(nom, cmd);

								String[] mes = message.split(" ", 2);
								System.out.println(mes[1]);
								res = message.split(" ", 4);
								int res1 = Integer.parseInt(res[0]);

								if (res1 == 1) {
									int nlig = Integer.parseInt(res[1]);
									int ncol = Integer.parseInt(res[2]);
									jeu.vider();
									jeu.grille[nlig][ncol] = initial;
									jeu.afficher();
								}
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
