package tp1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class FIter {
	public <T> ListIterator<T> map(Function<T, T> fun, ListIterator<T> iter) {
		List<T> resultat = new ArrayList<>();
		for (;iter.hasNext();) {
			T valeur = iter.next();
			resultat.add(fun.apply(valeur));
		}
		ListIterator<T> iterRes = resultat.listIterator();
		return iterRes;
	}
	
	public <T> ListIterator<T> filter(Predicate<T> funPred, ListIterator<T> iter) {
		List<T> resultat = new ArrayList<>();
		while (iter.hasNext()) {
			T valeur = iter.next();
			if (funPred.test(valeur)) {
				resultat.add(valeur);
			}
		}
		ListIterator<T> iterRes = resultat.listIterator();
		return iterRes;
	}
	
	public <T> String afficherIter(ListIterator<T> liste) {
		StringBuilder s = new StringBuilder();
		while (liste.hasNext()) {
			s.append(liste.next());
			if (liste.hasNext())
				s.append(", ");
		}
		return (s.toString());
	}
}
