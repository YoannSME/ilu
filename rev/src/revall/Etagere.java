package revall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Etagere {
	private List<Gaulois> emprunteurs = new ArrayList<>();
	private List<Parchemin> parchemins = new ArrayList<>();
	
	
	public void ajouterEmprunteur(Gaulois gaulois) {
		if(!emprunteurs.contains(gaulois)) {
			emprunteurs.add(gaulois);
		}
		else {
			System.out.println(gaulois+"déjà présent");
		}
		
	}
	
	public List<Parchemin> getParch(){
		return parchemins;
	}
	
	public boolean ajouterEnTete(Parchemin p) {
		parchemins.add(0,p);
		return true;
	}
	
	public boolean retirer(String p) {
		for(ListIterator<Parchemin> it = parchemins.listIterator();it.hasNext();) {
			Parchemin elem = it.next();
			if(elem.getNom().equals(p)) {
				it.remove();
				return true;
			}
		}
		return false;
		
		
	}
	
	public boolean ajouterEnFin(Parchemin P) {
		parchemins.add(P);
		return true;
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		Etagere e = new Etagere();
		
		Gaulois a = new Gaulois("A",12, 0);
		e.ajouterEmprunteur(a);
		e.ajouterEmprunteur(a);
		
		List<Character> lst = new ArrayList<>();
		Collections.addAll(lst, 'a','b','c','d');
		for(ListIterator<Character> it = lst.listIterator();it.hasNext();) {
			Character elem = it.next();
			if(elem.equals('a')) {
				it.remove();
			}
			else {
				System.out.println(elem);
			}
		}
		
		
		Parchemin p = new Parchemin("A");
		Parchemin p1 = new Parchemin("B");
		Parchemin p2 = new Parchemin("C");
		Parchemin p3 = new Parchemin("D");
		
		Collections.addAll(e.getParch(), p,p1,p2,p3);
		System.out.println(e.getParch());
		e.retirer(p3.getNom());
		System.out.println(e.getParch());
		e.retirer(p.getNom());
		System.out.println(e.getParch());
		
	}

}
