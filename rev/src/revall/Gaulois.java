package revall;

public class Gaulois {
	private String nom;
	private int force;
	private int age;
	

	public Gaulois(String nom,int force,int age) {
		this.nom = nom;
		this.force = force;
		this.age=age;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return "Gaulois: "+nom+" force: "+force;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Gaulois) {
			Gaulois g = (Gaulois) obj;
			return nom.equals(g.getNom());
		}
		return false;
	}

}
