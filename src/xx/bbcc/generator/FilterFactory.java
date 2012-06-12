package xx.bbcc.generator;

public interface FilterFactory {
	
	<F,T> Filter<F, T> getFilter(Generator<F, T> generator, String classificatorName);

}
