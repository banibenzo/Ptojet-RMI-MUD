package Server_Labyrinthe;

public class Personnage {
	String nom;
	Position pos;

	public Personnage(String nom, Position pos) {
		super();
		this.nom = nom;
		this.pos = pos;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	@Override
	public String toString() {
		return this.pos.numLigne + " " + this.pos.numCol + " est la nouvelle position de " + this.nom;
	}

}
