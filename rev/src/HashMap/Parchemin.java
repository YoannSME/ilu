package HashMap;

import java.util.*;

public class Parchemin implements Comparable<Parchemin>{
	private String titre;
	private Gaulois auteur;
	private int annee;

	public Parchemin(String titre, Gaulois auteur, int annee) {
		this.titre = titre;
		this.auteur = auteur;
		this.annee = annee;
	}

	public String toString() {
		return titre + " " + auteur + " " + annee;
	}
	


	public String getTitre() {
		return titre;
	}

	public Gaulois getAuteur() {
		return auteur;
	}

	public int getAnnee() {
		return annee;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Parchemin) {
			Parchemin p = (Parchemin) obj;
			return titre.equals(p.titre) && auteur.equals(p.auteur);
		}
		return false;
	}

	public int hashCode() {
		return 31 * titre.hashCode() + 17 * auteur.hashCode() + 11 * annee;
	}
	
	@Override
	public int compareTo(Parchemin o) {
		int cmp = titre.compareTo(o.titre);
		if(cmp==0) {
			return annee-o.annee;
		}
		else {
			return cmp;
		}
	}
	
	public enum Appreciation{
		EXCELLENT,BIEN,MOYEN,PASSABLE,NUL;
	}
	
	

	public static void main(String[] args) {

		Gaulois g1 = new Gaulois("G2");
		Gaulois g2 = new Gaulois("G3");
		Gaulois g3 = new Gaulois("G2");

		Parchemin p1 = new Parchemin("L1", g1, 2002);
		Parchemin p2 = new Parchemin("L1", g2, 2002);
		Parchemin p3 = new Parchemin("L1", g3, 2002);

		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));

		Gaulois cesar = new Gaulois("Caesar");
		Gaulois druide = new Gaulois("Panoramix");
		Gaulois asterix = new Gaulois("Asterix");

		Parchemin effetPot = new Parchemin("Lets effets secondaires de la potions magique", druide, 1970);
		Parchemin musique = new Parchemin("AMes plus grands succès", asterix, 1945);
		Parchemin guerreDesGaules = new Parchemin("Commentaire sur la guerre des gaules", cesar, 1950);

		Set<Parchemin> set = new HashSet<>();

		Collections.addAll(set, guerreDesGaules, musique, effetPot);
		System.out.println(set);

		Set<Parchemin> parchPret = new HashSet<>(set);

		Set<Parchemin> parcheminsApreter = new HashSet<>();

		parchPret.remove(guerreDesGaules);
		parchPret.remove(musique);

		parcheminsApreter.addAll(set);
		parcheminsApreter.removeAll(parchPret);

		System.out.println(parcheminsApreter);
		
		NavigableSet<Parchemin> ensTrie = new TreeSet<>(set);

		
		System.out.println(ensTrie);
		
		Set<Parchemin> ensembleLie = new LinkedHashSet<>(ensTrie);
		ensembleLie.add(new Parchemin("L'art de diriger",asterix,1948));
		System.out.println("\n"+ensembleLie);
		
		
		Map<Parchemin,List<Appreciation>> parchApprecie = new HashMap<>();
	
		
		Musee m = new Musee();
		
		m.ajouterParchemin("P1", asterix, 1950);
		m.ajouterAppreciation(effetPot, Appreciation.BIEN);
		m.ajouterAppreciation(effetPot, Appreciation.BIEN);
		m.ajouterAppreciation(effetPot, Appreciation.BIEN);
		
		m.ajouterAppreciation(guerreDesGaules, Appreciation.EXCELLENT);
		
		m.getAll();
		

	}

	

}
