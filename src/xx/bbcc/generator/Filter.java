package xx.bbcc.generator;

public class Filter<F,T> implements Generator<F, T>{

	private Generator<F, T> generator;
	private ClassificatorFactory<T> classificatorFactory;
	
	
	@Override
	public T generate(SequenceGenerator<F> si) {
		T t = generator.generate(si);
		
		Classificator<T> classificator = classificatorFactory.getClassificator(t);
		if(classificator.test())
			return t;

		return generate(si);
	}


	private Filter(Generator<F, T> generator, ClassificatorFactory<T> classificatorFactory) {
		this.generator = generator;
		this.classificatorFactory = classificatorFactory;
	}

	public static class Factory implements FilterFactory {

		@SuppressWarnings("unchecked")
		@Override
		public <F, T> Filter<F, T> getFilter(Generator<F, T> generator, String classificatorName) {
			return new Filter<F, T>(generator, (ClassificatorFactory<T>) ClassificatorManager.INSTANCE.getClassificatorFactory(classificatorName));
		}
		
	}
	
	
	
}
