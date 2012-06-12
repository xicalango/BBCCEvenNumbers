package xx.bbcc.generator;

public class StringNumberSequenceGenerator implements SequenceGenerator<String> {

	public static class Factory implements SequenceGeneratorFactory<String> {

		@Override
		public SequenceGenerator<String> getSequenceGenerator() {
			return new StringNumberSequenceGenerator();
		}

		@Override
		public SequenceGenerator<String> getSequenceGenerator(String start) {
			StringNumberSequenceGenerator snsg = new StringNumberSequenceGenerator();
			snsg.old = start;
			return snsg;
		}
		
	}
	
	private String old = "-1";
	
	@Override
	public String next() 
	{
		Integer i = Integer.parseInt(old);
		i++;old=""+i;
		return old;
	}

	@Override
	public String current() {
		return old;
	}

}
