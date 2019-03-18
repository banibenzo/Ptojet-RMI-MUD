package Server_Labyrinthe;

import java.util.HashMap;

public class Piece {
	public HashMap<String, Personnage> ListPers;

	public Piece(HashMap<String, Personnage> listPers) {
		super();
		ListPers = listPers;
	}

	// retirer un personnage qui sort de la pièce
	public boolean retirerPers(Personnage pers) {
		boolean retirerOK = false;
		if (ListPers.remove(pers.nom) != null) {
			retirerOK = true;
		}
		return retirerOK;
	}

	// Ajout d'un personnage dans la pièce
	public boolean ajouterPers(Personnage pers) {
		boolean ajouterOK = false;
		ListPers.put(pers.nom, pers);
		ajouterOK = true;
		return ajouterOK;

	}
}
