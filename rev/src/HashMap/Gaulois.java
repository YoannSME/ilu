package HashMap;

import java.util.*;

public class Gaulois extends Personnage implements Comparable<Gaulois>{

	public Gaulois(String nom) {
		super(nom);
	
	}
	@Override
	public int compareTo(Gaulois g1) {
		return -g1.getNom().compareTo(nom);
	}
	
	public String toString() {
		return nom;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Gaulois) {
			Gaulois g = (Gaulois) o;
			return nom.equals(g.getNom());
		}
		return false;
	}
	
	
	
	public static void afficherGaulois(NavigableSet<Gaulois> ensemble) {
		for(Iterator<Gaulois> it = ensemble.iterator();it.hasNext();) {
			Gaulois g = it.next();
			System.out.println(g);
		}
		
	}
	
	public static void main(String[] args) {
		
		Gaulois g = new Gaulois("a");
		Gaulois g1 = new Gaulois("ab");
		Gaulois g2 = new Gaulois("abc");
		Gaulois g3 = new Gaulois("acd");
		
		NavigableSet<Gaulois> ens = new TreeSet<>();
	
	
		Collections.addAll(ens,g1,g,g2,g3);
		
		afficherGaulois(ens);
	}
	

}
