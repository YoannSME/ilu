package HashMap;

import java.util.*;

public class Bibliotheque {
	
	Map<Gaulois,Set<Parchemin>> map = new HashMap<>();
	
	
	public void ajouterGaulois(Gaulois g) {
		if(!map.containsKey(g)) {
			Set<Parchemin> ensParch = new TreeSet<>(new Comparator<Parchemin>() {
				@Override
				public int compare(Parchemin o1, Parchemin o2) {
					int x = o1.getAnnee()- o2.getAnnee();
					if(x==0) {
						return o1.getTitre().compareTo(o2.getTitre());
					}return x;}});
			map.put(g, ensParch);
		}
	}
	
	public void ajouterParchemin(Gaulois g,Parchemin p) {
		Set<Parchemin> setP;
		if(!map.containsKey(g)) {
			ajouterGaulois(g);
			setP = map.get(g);
		}
		else {
			setP = map.get(g);
		}
		setP.add(p);
	}
	
	public Map<Gaulois,Set<Parchemin>> getMap(){
		return map;
	}
	
	public void afficher() {
		Set<Gaulois> set = map.keySet();
		for(Iterator<Gaulois> it = set.iterator();it.hasNext();) {
			Gaulois g = it.next();
			System.out.println(g+""+map.get(g));
		}
	}
	
	
	
	

	
	public static void main(String[] args) {
		Bibliotheque b = new Bibliotheque();
		
		Gaulois cesar = new Gaulois("Caesar");
		Gaulois druide = new Gaulois("Panoramix");
		Gaulois asterix = new Gaulois("Asterix");

		Parchemin effetPot = new Parchemin("Lets effets secondaires de la potions magique", druide, 1970);
		Parchemin musique = new Parchemin("AMes plus grands succès", asterix, 1945);
		Parchemin guerreDesGaules = new Parchemin("Commentaire sur la guerre des gaules", cesar, 1950);

		b.ajouterParchemin(asterix, musique);
		b.ajouterParchemin(druide,effetPot);
		b.ajouterParchemin(cesar,  guerreDesGaules);
		
		b.ajouterParchemin(asterix, new Parchemin("AA",asterix,1580));
		b.afficher();
	}
}
