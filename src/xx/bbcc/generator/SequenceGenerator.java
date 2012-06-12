package xx.bbcc.generator;

public interface SequenceGenerator<T> {
	T next();
	T current();
}
