package tp1;

import java.util.function.Function;

@FunctionalInterface
public interface T3<A> {
	A f3(Function<A,A> fun,A a);
}
