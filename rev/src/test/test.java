package test;
import revall.*;
import java.util.*;
public class test {
	
	private Tas<Casque> tas = new Tas<>(new Casque("Yoann","Helmet",10),
			new Casque("Igor","Chapeau",1),new Casque("Yoann","Haume",20));
	
	
	
//	public Casque prelever(int indice) {
//	
//		Casque casque = null;
//		for(int i = 0;i<indice && tas.hasNext();i++) {
//			casque = tas.next();
//		}
//		if(casque != null) {tas.remove();}
//		return casque;
//	}
	
	




	public static void main(String[] args) {
		test T = new test();
		
//		Casque c = T.prelever(1);
//		Casque c2 = T.prelever(1);
//		
//		Casque c3 = T.prelever(1);
//		Casque c4 = T.prelever(1);
		
		Bibliotheque b  = new Bibliotheque(20);
		Parchemin p = new Parchemin("A");
		Parchemin p1 = new Parchemin("B");
		Parchemin p2 = new Parchemin("C");
		Parchemin p3 = new Parchemin("D");
		
		b.ajouterParchemin(p);
		b.ajouterParchemin(p1);
		b.ajouterParchemin(p2);
		b.ajouterParchemin(p3);
		
		b.afficherBibliotheque();
		
		for(Iterator<Parchemin> it = b.iterator();it.hasNext();) {
			Parchemin elem = it.next();
			if(elem.getNom().equals("B")) {
				System.out.println("\nElement à sortir : "+elem);
				it.remove();
			}
		}
		
		
		
		NavigableSet<String> ens = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return(-o1.compareTo(o2));
			}
		});
		ens.add("a");
		ens.add("b");
		ens.add("c");
		ens.add("d");
		ens.add("aaz");
		ens.add("aab");
		
		System.out.println(ens);
		

		NavigableSet<Gaulois> ensGaulois = new TreeSet<>(new Comparator<Gaulois>() {

			@Override
			public int compare(Gaulois o1, Gaulois o2) {
				int age1 = o1.getAge();
				int age2 = o2.getAge();
				int dif = age1-age2;
				if(dif!=0) {
					return -dif;
				}
				else {
					return -(o1.getNom().compareTo(o2.getNom()));
					
					
				}
			}});
	
		ensGaulois.add(new Gaulois("Ordralfabetix", 10, 41));
		ensGaulois.add(new Gaulois("Cetautomatix", 10, 41));
		ensGaulois.add(new Gaulois("Panoramix", 10, 90));
		ensGaulois.add(new Gaulois("Asterix", 10, 35));
		
		for(Iterator<Gaulois> it = ensGaulois.descendingIterator();it.hasNext();) {
			Gaulois g = it.next();
			System.out.println(g);
		}
		
		String y = "a";
		System.out.println(y.hashCode());
		
	}
	
	
	

}
