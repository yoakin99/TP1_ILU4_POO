package tp1;

import java.util.function.Function;

@FunctionalInterface
public interface Power<T> extends Function<T, T> {
	static <T> Power<T> identity() {
		return x->x;
	}
	
	default Power<T> andThen(Power<T> after) {
		return x -> after.apply(this.apply(x));
	}
	
	static <T> Power<T> power(int val, Power<T> fun) {
		if (val==0) {
			return Power.identity();
		} else {
			return fun.andThen(power(val-1, fun));
		}
	};
}
