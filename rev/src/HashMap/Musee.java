package HashMap;

import java.util.*;

import HashMap.Parchemin.Appreciation;

public class Musee {
	Map<Parchemin,List<Appreciation>> parchApprecies = new HashMap<>();
	
	
	
	public Parchemin ajouterParchemin(String titre,Gaulois auteur,int date) {
		Parchemin parch = new Parchemin(titre,auteur,date);
		
		if(!parchApprecies.containsKey(parch)) {
			parchApprecies.put(parch, new ArrayList<>());	
		}
		return parch;
	}
	
	public void ajouterAppreciation(Parchemin p,Appreciation a) {
		List<Appreciation> lst = new ArrayList<>();
		if(!parchApprecies.containsKey(p)) {
			parchApprecies.put(p, lst);
		}
		else {
			lst= parchApprecies.get(p);
			
		}
		lst.add(a);
	}
	
	public void getAll() {
		Set<Parchemin> parchs = parchApprecies.keySet();
		for(Iterator<Parchemin> it = parchs.iterator();it.hasNext();) {
			Parchemin p = it.next();
			System.out.println(p+""+parchApprecies.get(p));
		}
	}

}
