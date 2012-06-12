package xx.bbcc.generator;

public interface ClassificatorFactory<T> {
	Classificator<T> getClassificator(T value);
}
