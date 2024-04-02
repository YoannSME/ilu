package revall;

public class Equipement {
	private String nom;
	private int durabilite;
	
	public Equipement(String nom, int durabilite) {	
		this.nom = nom;
		this.durabilite = durabilite;
	}
	
	
	public String toString() {
		return "Equipement : "+nom+"\ndurabilite : "+durabilite;
	}
	
	

}
