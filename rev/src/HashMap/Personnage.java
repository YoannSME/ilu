package HashMap;

public class Personnage {
	protected String nom;

	
	public Personnage(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Personnage [nom=" + nom + "]";
	}
	
	
	public boolean equals(Object obj) {
		if(obj instanceof Personnage) {
			Personnage g = (Personnage) obj;
			return nom.equals(g.getNom());
		}
		return false;
	}
	
	


}
