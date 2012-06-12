package xx.bbcc.generator;

public interface Mappable<F, T> {
	T map(F from);
}
