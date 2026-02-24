package tp1;

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
		
		
		
		System.out.println(Fonc.comp2(funAdd, funMul, Integer::max)).apply(3);
		
	}
}
