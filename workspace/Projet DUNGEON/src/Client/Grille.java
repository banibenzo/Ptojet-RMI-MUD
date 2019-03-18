package Client;

public class Grille {

	// Attributs
	private int nbLig;
	private int nbCol;
	char[][] grille;

	// Constructeur
	public Grille(int nbLig, int nbCol) {
		super();
		this.nbLig = nbLig;
		this.nbCol = nbCol;
		this.grille = new char[nbLig][nbCol];

		for (int i = 0; i < this.nbLig; i++) {
			for (int j = 0; j < this.nbCol; j++) {
				grille[i][j] = 'x';
			}
		}
	}

	// Accesseurs

	// Méthodes
	public void afficher() {
		System.out.println();
		for (int i = 0; i < this.nbLig; i++) {
			for (int j = 0; j < this.nbCol; j++) {
				System.out.print(" | " + grille[i][j]);
			}
			System.out.print(" | \n");
		}
		System.out.println();
	}

	public void initialiser(char initial) {
		grille[4][1] = initial;
		this.afficher();
	}

	public void vider() {
		for (int i = 0; i < this.nbLig; i++) {
			for (int j = 0; j < this.nbCol; j++) {
				grille[i][j] = 'x';
			}
		}

	}

	public static void main(String[] args) {
		Grille g = new Grille(5, 5);
		g.afficher();
	}

}
