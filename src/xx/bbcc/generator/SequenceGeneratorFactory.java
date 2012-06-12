package xx.bbcc.generator;

public interface SequenceGeneratorFactory<T> {
	SequenceGenerator<T> getSequenceGenerator();
	SequenceGenerator<T> getSequenceGenerator(T start);
}
