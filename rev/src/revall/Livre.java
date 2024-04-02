package revall;

public class Livre implements Comparable<Livre>{
	private String nom;
	private int annee;
	
	public Livre(String nom, int annee) {
		this.nom = nom;
		this.annee = annee;
	}
	
	public String getNom() {
		return nom;
	}
	public int getAnnee() {
		return annee;
	}
	
	
	
	@Override
	public String toString() {
		return "Livre [nom=" + nom + ", annee=" + annee + "]";
	}

	public boolean equals(Object o) {
		if( o instanceof Livre) {
			Livre l = (Livre) o;
			return nom.equals(l.getNom()) &&
					annee==l.getAnnee();
		}
		return false;
	}
	@Override
	public int compareTo(Livre o) {
		int cmp = annee-o.getAnnee();
		if(cmp != 0) {
			return cmp;
		}
		else { 
			return nom.compareTo(o.getNom());
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	
	
	
	

}
