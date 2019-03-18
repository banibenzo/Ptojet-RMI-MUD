package Server_Labyrinthe;

import java.util.HashMap;

public class Labyrinthe {
	private Piece[][] Pieces;

	public Labyrinthe(int dim) {
		Pieces = new Piece[dim][dim];
		HashMap<String, Personnage> personnages = new HashMap<String, Personnage>();

		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				Pieces[i][j] = new Piece(personnages);
			}
		}
	}

	// Methode d'ajout à la pièce initial
	public Boolean Ajout_Piece_Initiale(Personnage pers) {
		Boolean ajoutPI = true;
		// Récuperer la pièce de depart
		Piece p_init = Pieces[4][1];
		// Ajout du personnage dans la liste de personnages dans le jeu

		// Ajout du personnage dans la pièce de depart
		p_init.ListPers.put(pers.nom, pers);
		// verification
		// Personnage persV=p_init.ListPers.get(pers.nom);
		// System.out.println(persV.nom+" a bien été ajouté à la pièce 4,1");
		return ajoutPI;
	}

	// Methode de deplacement d'un personnage
	public boolean deplacer(Personnage p, char cmd) {
		boolean deplacerOK = false;
		// verifier si le deplacement demandé est possible, deplacer
		int nlig = p.pos.numLigne;
		int ncol = p.pos.numCol;
		if (((cmd == 'E') && (nlig != 0)) || ((cmd == 'O') && (nlig != 4)) || ((cmd == 'S') && (ncol != 0))
				|| ((cmd == 'N') && (ncol != 4))) {
			switch (cmd) {

			case 'E':
				// recuper ancienne piece et retirer personnage
				Piece old_p = Pieces[nlig][ncol];
				if (old_p.retirerPers(p)) {
					// recuper ancienne piece et ajouter personnage
					nlig = nlig - 1;
					Piece new_p = Pieces[nlig][ncol];
					if (new_p.ajouterPers(p)) {
						// System.out.println("Deplacement vers l'est OK!");
						Position posI = new Position(nlig, ncol);
						p.setPos(posI);
						deplacerOK = true;
					}
				}
				break;

			case 'O':
				// recuper ancienne piece et retirer personnage
				Piece old_p1 = Pieces[nlig][ncol];
				if (old_p1.retirerPers(p)) {
					// recuper ancienne piece et ajouter personnage
					nlig = nlig + 1;
					Piece new_p = Pieces[nlig][ncol];
					if (new_p.ajouterPers(p)) {
						Position pos = new Position(nlig, ncol);
						p.setPos(pos);
						deplacerOK = true;
					}
				}

				break;

			case 'S':

				// recuper ancienne piece et retirer personnage
				Piece old_p11 = Pieces[nlig][ncol];
				if (old_p11.retirerPers(p)) {
					// recuper ancienne piece et ajouter personnage
					ncol = ncol - 1;
					Piece new_p = Pieces[nlig][ncol];
					if (new_p.ajouterPers(p)) {
						Position pos = new Position(nlig, ncol);
						p.setPos(pos);
						deplacerOK = true;
					}
				}

				break;

			case 'N':

				// recuper ancienne piece et retirer personnage
				Piece old_p111 = Pieces[nlig][ncol];
				if (old_p111.retirerPers(p)) {
					// recuper ancienne piece et ajouter personnage
					ncol = ncol + 1;
					Piece new_p = Pieces[nlig][ncol];
					if (new_p.ajouterPers(p)) {
						Position pos = new Position(nlig, ncol);
						p.setPos(pos);
						deplacerOK = true;
					}
				}

				break;

			}

		}

		return deplacerOK;

	}
}
