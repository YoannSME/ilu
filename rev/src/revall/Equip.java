package revall;

public class Equip {
	private String etat;
	private String nom;
	

	public Equip(String etat, String nom) {
		
		this.etat = etat;
		this.nom = nom;
	}
	
	
	@Override
	public String toString() {
		return nom+""+etat;
	}
	
	public String getNom() {
		return nom;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Equip) {
			Equip elem = (Equip) obj;
			return nom.equals(elem.getNom());
		}
		return false;
	}
	
	public int hashCode() {
		return 31*nom.hashCode();
	}

}
