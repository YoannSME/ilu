package revall;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bibliotheque implements Iterable<Parchemin>{
	private Parchemin[] parchemins;
	private int capaciteMax;
	private int nbParchemins = 0;
	private int nbOperations = 0;
	
	
	public Bibliotheque(int capaciteMax) {
		this.capaciteMax = capaciteMax;
		parchemins = new Parchemin[capaciteMax];
	}
	

	
	public void ajouterParchemin(Parchemin p) {
		if(nbParchemins<capaciteMax) {
			parchemins[nbParchemins] = p;
			nbParchemins++;
			nbOperations++;
			return;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
		
	}
	
	public void afficherBibliotheque() {
		for(int i=0;i<nbParchemins;i++) {
			Parchemin p = parchemins[i];
			System.out.println(p);
		}
	}
	
	public Parchemin[] getParchemin() {
		return parchemins;
	}

	@Override
	public Iterator<Parchemin> iterator() {
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Parchemin>{
		private int indiceIterateur = 0;
		private int nbOperationsReference = nbOperations;

		@Override
		public boolean hasNext() {
			return indiceIterateur<nbParchemins;
		}

		@Override
		public Parchemin next() {
			verifConcurrence();
			if(hasNext()) {
				Parchemin p = parchemins[indiceIterateur];
				indiceIterateur++;
				return p;
			}
			throw new NoSuchElementException();
		}
		
		public void remove() {
			if(nbParchemins<1) {
				throw new NoSuchElementException();
			}
			else {
				for(int i = indiceIterateur-1;i<nbParchemins-1;i++) {
					parchemins[i] = parchemins[i+1];
					indiceIterateur--;
					nbParchemins--;
					nbOperations++;nbOperationsReference++;
				}
			}
		}
		
		private void verifConcurrence() {
			if(nbOperations!=nbOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
		
		

	}

}
