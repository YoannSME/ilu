package revall;

public class Casque extends Equipement{
	private String possesseur;
	
	public Casque(String possesseur,String nom,int dura) {
		super(nom,dura);
		this.possesseur = possesseur;
	}
	
	public String toString() {
		return super.toString()+" \nappartient à : "+possesseur;
	}
	

}
