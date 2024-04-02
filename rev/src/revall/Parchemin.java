package revall;

public class Parchemin implements Comparable<Parchemin>{
	private String nom;

	

	public Parchemin(String nom) {

		this.nom = nom;
	}
	
	
	

	public String getNom() {
		return nom;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Parchemin) {
			Parchemin p = (Parchemin) obj;
			return nom.equals(p.getNom());
		}
		return false;
	}





	@Override
	public String toString() {
		return "Parchemin [nom=" + nom + "]";
	}




	@Override
	public int compareTo(Parchemin o) {
		return nom.compareTo(o.getNom());
	}



	

	

}
