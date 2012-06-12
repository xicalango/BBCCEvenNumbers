package xx.bbcc.generator;

public interface Generator<F,T> {
	T generate(SequenceGenerator<F> si);
}
