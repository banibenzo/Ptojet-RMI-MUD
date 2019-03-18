package Server_Labyrinthe;

public class Position {
	int numLigne;
	int numCol;

	public Position(int numLigne, int numCol) {
		super();
		this.numLigne = numLigne;
		this.numCol = numCol;
	}

	public int getNumLigne() {
		return numLigne;
	}

	public void setNumLigne(int numLigne) {
		this.numLigne = numLigne;
	}

	public int getNumCol() {
		return numCol;
	}

	public void setNumCol(int numCol) {
		this.numCol = numCol;
	}

}
