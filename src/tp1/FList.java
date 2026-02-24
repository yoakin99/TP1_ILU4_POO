package tp1;

import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class FList {
	
	public <T> List<T> map(Function<T, T> fun, List<T> liste) {
		int indice = 0;
		while (indice < liste.size()) {
			liste.set(indice, fun.apply(liste.get(indice)));
			indice++;
		}
		return liste;
	}
	
	public <T> List<T> filter(Predicate<T> funPred, List<T> liste) {
		ListIterator<T> iter;
		for (iter = liste.listIterator();iter.hasNext();) {
			T valeur = iter.next();
			if (!funPred.test(valeur)) {
				iter.remove();
			}
		}
		return liste;
	}
	
	public <T> boolean forAll(Predicate<T> funPred, List<T> liste) {
		ListIterator<T> iter;
		for (iter = liste.listIterator();iter.hasNext();) {
			T valeur = iter.next();
			if (!funPred.test(valeur)) {
				return false;
			}
		}
		return true;
	}
	
	public <T> boolean exists(Predicate<T> funPred, List<T> liste) {
		ListIterator<T> iter;
		for (iter = liste.listIterator();iter.hasNext();) {
			T valeur = iter.next();
			if (funPred.test(valeur)) {
				return true;
			}
		}
		return false;
	}
}
