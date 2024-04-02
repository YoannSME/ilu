package revall;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Tas <E extends Equipement> implements Iterable<E>{
	private E[] tas;
	private int nombreEquipement;
	private int indiceIterateur = 0;
	
	private int nombreOperations = nombreEquipement;
	
	public Tas(E... tas) {
		
		this.tas = tas;
		this.nombreEquipement = tas.length;
	}
	
	public int getTaille() {
		return nombreEquipement;
	}

	


	@Override
	public Iterator<E> iterator() {
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<E>{
		private int indiceIterateur = 0;
		private int nombreOperationsReference = nombreOperations;
		
		public boolean hasNext() {
			return indiceIterateur<nombreEquipement;
		}

		
		public E next() {
			if(hasNext()) {
				E equ = tas[indiceIterateur];
				indiceIterateur++;
				return equ;
			}
			throw new NoSuchElementException();
		}
		
		public void remove() {
			if(nombreEquipement<1) {
				throw new IllegalStateException();
			}
			for(int i=indiceIterateur-1;i<nombreEquipement-1;i++) {
				tas[i] = tas[i+1];
			}
			nombreEquipement--;
			indiceIterateur--;
		}
	}
	
	
	
	
	
	
	
	
	

}
