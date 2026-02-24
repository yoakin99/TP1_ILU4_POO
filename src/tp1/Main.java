package tp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

public class Main {
	public static void main(String[] args) {
		
		
		//Exercice 1
		
		T1 t1 = new Fonc<>();
		int resultat1 = t1.f1(3);
		System.out.println(resultat1);
		
		T2 t2 = new Fonc<>();
		int resultat2 = t2.f2(t1);
		System.out.println(resultat2);
		
		T3<String> t3 = new Fonc<>();
		String resultat = t3.f3((s1-> s1 + "x"), "a");
		System.out.println(resultat);

		
		
		//Exercice 2
		
		Function<Integer, Integer> funAdd = elem -> elem+1;
		Function<Integer, Integer> funMul = elem -> elem*2;
		Function<Integer, Integer> compose = funAdd.andThen(funMul);
		int result1 = compose.apply(3);
		System.out.println(result1);
		
		
		Function<Integer, Integer> testIntComp2 = Fonc.comp2(funAdd, funMul, Integer::max);
		System.out.println(testIntComp2.apply(3));
		
		
		Function<String, Integer> strToInt = Integer::parseInt;		
		Function<String, Integer> composeStrToInt = strToInt.andThen(testIntComp2);
		System.out.println(composeStrToInt.apply("3"));
		
		
		
		//Exercice 3.1
		List<Integer> liste = new ArrayList<>();
		for (int i=0; i<10; i++) {
			liste.add(i);
		}
		
		FList fonctionListe = new FList();
		System.out.println("Test map : " + fonctionListe.map(element -> 2*(element+1), liste));
		System.out.println("Test filter : " + fonctionListe.filter(element -> element >= 10, liste));
		System.out.println("Test forAll 1 : " + fonctionListe.forAll(element -> element < 20, liste));
		System.out.println("Test forAll 2 : " + fonctionListe.forAll(element -> element <= 20, liste));
		System.out.println("Test exists : " + fonctionListe.exists(element -> element== 10, liste));

		
		//Exercice 3.2
		FIter fonctionIter = new FIter();
		ListIterator<Integer> listeIter= liste.listIterator();
		System.out.println("\n" + fonctionIter.afficherIter(listeIter));
		System.out.println("\n" + fonctionIter.afficherIter(listeIter));
		
		listeIter = liste.listIterator();
		listeIter = (fonctionIter.map(element->element/2, listeIter));
		System.out.println("Test map :"+ fonctionIter.afficherIter(listeIter));
		

		listeIter = liste.listIterator();
		System.out.println("Test filtrer :"+ fonctionIter.afficherIter(fonctionIter.filter(element -> element>=8, listeIter)));
	}
}
