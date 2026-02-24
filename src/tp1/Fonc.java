package tp1;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Fonc<A> implements T1, T2, T3<A>, Power<T>{
	
	@Override
	public int f1(int val) {
		return val+1;
	}
	
	@Override
	public int f2(T1 t1) {
		return t1.f1(t1.f1(0));
	}
	
	@Override 
	public A f3(Function<A,A> fun,A a) {
		return fun.apply(fun.apply(a));
	}
	
	public static <W,X,Y,Z> Function<W,Z> comp2(Function<W, X> fun1, Function<W,Y> fun2, BiFunction<X, Y, Z> biFun) {
		return x->biFun.apply(fun1.apply(x), fun2.apply(x));
	}
}
