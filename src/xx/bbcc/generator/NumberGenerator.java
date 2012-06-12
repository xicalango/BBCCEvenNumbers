package xx.bbcc.generator;

public class NumberGenerator<F> implements Generator<F,Integer> {

	@Override
	public Integer generate(SequenceGenerator<F> si) {
		
		F f = si.next();
		
		@SuppressWarnings("unchecked")
		Mappable<F,Integer> m = (Mappable<F, Integer>) MappableFactory.INSTANCE.getMappable(f.getClass(), Integer.class);
		
		return m.map(f);
	}

}
