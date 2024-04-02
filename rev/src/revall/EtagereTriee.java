package revall;

import java.util.*;

public class EtagereTriee {
	private List<Parchemin> parchemins = new ArrayList<>();
	
	
	public String toString() {
		 return parchemins.toString();
		 }
	
	public List<Parchemin> getListe(){
		return parchemins;
	}
	
	public void ajouter(Parchemin parchemin) {
		boolean found = false;
		Parchemin p;
			 
	 for(ListIterator<Parchemin> it = parchemins.listIterator();it.hasNext();) {
		 p = it.next();
		 int cmp = p.getNom().compareTo(parchemin.getNom());
		 if(cmp>=0) {
			 it.previous();
			 it.add(parchemin);
			 return;
		 }		 
	 }
	 
	 parchemins.add(parchemin);
	  
	}
	
	
	public Parchemin retirer(String nom) {
		
		for(ListIterator<Parchemin> it = parchemins.listIterator();it.hasNext();) {
			Parchemin p = it.next();
			if(p.getNom().equals(nom)) {
				it.remove();
				return p;
				
			}
		}
		return null;
		
	}

		 
		

public static void main(String[] args) {
	EtagereTriee e = new EtagereTriee();
	
	Parchemin p = new Parchemin("AAC");
	Parchemin p1 = new Parchemin("B");
	Parchemin p2 = new Parchemin("C");
	Parchemin p3 = new Parchemin("D");
	Parchemin p4 = new Parchemin("AAB");
	
	e.ajouter(p3);
	e.ajouter(p2);
	e.ajouter(p1);
	e.ajouter(p);
	e.ajouter(p4);
	
	System.out.println(e.getListe());
	
	System.out.println(e.retirer("B"));
	
	System.out.println(e.getListe());
	
	
}
}
		


