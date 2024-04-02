package revall;

import java.util.*;

public class BibliTriee {
	private List<Livre> lst = new ArrayList<>();
	
	
	public List<Livre> getLst() {
		return lst;
	}


	public void ajouter(Livre l) {
		Livre livre;
		boolean trouve = false;
		for(ListIterator<Livre> it = lst.listIterator();it.hasNext()&&!trouve;) {
			livre = it.next();
			if(l.compareTo(livre)<=0) {
				it.previous();
				it.add(l);
				trouve = true;
			}
		}
		if(!trouve) {
			lst.add(l);
		}
	}
	
	public static void main(String[] args) {
		BibliTriee b = new BibliTriee();
		
		Livre l = new Livre("AAAZ",2002);
		Livre l1 = new Livre("AZE",2004);
		Livre l2 = new Livre("VZER",2008);
		Livre l3= new Livre("AAAZ",2008);
		
		b.ajouter(l3);
		b.ajouter(l1);
		b.ajouter(l2);
		b.ajouter(l);
		
		System.out.println(b.getLst());
	}
	
	
	

}
