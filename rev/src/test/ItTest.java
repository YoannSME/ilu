package test;
import HashMap.*;
import java.util.*;

public class ItTest implements Iterable<Parchemin>{
	private Parchemin[] tab;
	private int taille;
	private int nbElem = 0;
	private int nbOp=0;
	
	public ItTest(int taille) {
		this.taille = taille;
		tab = new Parchemin[taille];
	}
	
	@Override
	public Iterator<Parchemin> iterator() {
		return new Iterateur();
	}
	
	
	public void ajouter(Parchemin... tableau) {
		for(int i =0;i<tableau.length;i++) {
			tab[nbElem] = tableau[i];
			nbElem++;
		}
	}
	
	public void printTab() {
		for(Iterator<Parchemin> it = iterator();it.hasNext();) {
			Parchemin p = it.next();
			System.out.println(p.getTitre());
		}
	}
	
	
	private class Iterateur implements Iterator<Parchemin>{
		private int indiceIterateur=0;
		private int nbOpRef = nbOp;
		
		
		
		@Override
		public boolean hasNext() {
			return indiceIterateur<nbElem;
		}
		@Override
		public Parchemin next() {
			verifConcurrence();
			if(hasNext()) {
				Parchemin p = tab[indiceIterateur];
				indiceIterateur++;
				return p;
			}
			throw new ArrayIndexOutOfBoundsException();
		}
		
		public void remove() {
			if(nbElem<1) {
				throw new IllegalStateException();
			}
			else {
				for(int i = indiceIterateur-1;i<nbElem-1;i++) {
					tab[i] =tab[i+1];
				}
				indiceIterateur--;
				nbElem--;
				nbOp++;nbOpRef++;
			}
			
		}
		
		public void verifConcurrence() {
			if(nbOp!=nbOpRef) {
				throw new ConcurrentModificationException();
			}
		}
		
		
		
	}
	
	
	
	public static void printTitre(List<Parchemin> lst) {
		for(ListIterator<Parchemin> it = lst.listIterator();it.hasNext();) {
	
		Parchemin p = it.next();
		System.out.println(p.getTitre());
	}
}
	
	
	public static void main(String[] args) {
		List<Parchemin> lst = new ArrayList<>();
		ParchDefaut p = new ParchDefaut("titre");
		ParchDefaut p1 = new ParchDefaut("titre1");
		ParchDefaut p2 = new ParchDefaut("titre2");
		ParchDefaut p3 = new ParchDefaut("titre3");
		
		Collections.addAll(lst, p,p1,p2,p3);
		
//		printTitre(lst);
		
		ItTest tst = new ItTest(50);
		
		tst.ajouter(p);
		tst.printTab();
		
		
		NavigableSet<Parchemin> tset= new TreeSet<>();
		tset.add(p3);
		System.out.println(tset);
	
		
		
		
}
}


	
	
	
	


