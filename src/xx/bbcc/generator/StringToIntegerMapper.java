package xx.bbcc.generator;

public class StringToIntegerMapper implements Mappable<String, Integer> {
	
	static {
		MappableFactory.INSTANCE.registerMapper(String.class, Integer.class, new StringToIntegerMapper());
	}
	
	@Override
	public Integer map(String from) {
		return Integer.parseInt(from);
	}
}
