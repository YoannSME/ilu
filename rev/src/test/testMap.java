package test;

import HashMap.*;
import java.util.*;

public class testMap {
	
	Map<Parchemin,Set<Gaulois>> map = new HashMap<>();
	
	public void ajouterCle(Parchemin key) {
		if(!map.containsKey(key)) {
			map.put(key,new HashSet<>());
		}
	}
	
	public void ajouterValeur(Parchemin key,Gaulois val) {
		Set<Gaulois> ens;
		if(!map.containsKey(key)) {
			ajouterCle(key);
			ens = map.get(key);
		}
		else {
			ens = map.get(key);
		}
		ens.add(val);
	}
	
	public void print() {
		for(Iterator<Parchemin> it = map.keySet().iterator();it.hasNext();) {
			Parchemin p = it.next();
			System.out.println("Cle: "+p.getTitre()+" , valeur: "+map.get(p));
			
		}
	}
	
	
	
	public static void main(String[] args) {
		testMap tst = new testMap();
		
		ParchDefaut p = new ParchDefaut("Parchemin1");
		
		Gaulois g = new Gaulois("G");
		
		tst.ajouterCle(p);
		tst.ajouterValeur(new ParchDefaut("Parch2"), g);
		tst.ajouterValeur(p, new Gaulois("G"));
		
		tst.print();
		

	}

}
