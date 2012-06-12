package xx.bbcc.generator;

public class EvenNumberClassificator implements Classificator<Integer> {
	
	public static class Factory implements ClassificatorFactory<Integer> {
		
		static {
			ClassificatorManager.INSTANCE.putClassificator("EvenNumber", new Factory());
		}
		
		@Override
		public Classificator<Integer> getClassificator(Integer value) {
			return new EvenNumberClassificator(value);
		}
	}
	
	private int t;
	
	private EvenNumberClassificator(int t) {
		this.t = t;
	}

	@Override
	public boolean test() {
		return t % 2 == 0;
	}
	
	
	public static void main(final String[] args) throws ClassNotFoundException {
		
		try {
			ClassificatorManager.INSTANCE.putClassificator("EvenNumberr", new EvenNumberClassificator.Factory());
			Class.forName("xx.bbcc.generator.StringToIntegerMapper");
		} catch (ClassNotFoundException e) {
			throw e;
		}
		
		FilterFactory ff = new Filter.Factory();
		
		Generator g = ff.getFilter(new NumberGenerator(), "EvenNumberr"); 
	
		BetweenTwoIterator<String> bti =  new GeneratorOutputBetweenTwo<String, Integer>(g, new StringNumberSequenceGenerator.Factory());
		
		bti.doSthBetween(new PointMarker.StartMarker<String>() {

			@Override
			public String getPoint() {
				return args[0];
			}
			
		}, new PointMarker.EndMarker<String>() {

			@Override
			public String getPoint() {
				return args[1];
			}
		});
		
	}
}
