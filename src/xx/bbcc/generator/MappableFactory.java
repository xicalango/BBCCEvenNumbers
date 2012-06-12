package xx.bbcc.generator;

import java.util.HashMap;
import java.util.Map;

public enum MappableFactory {
	INSTANCE;
	
	private Map<Pair<Class<?>, Class<?>>, Mappable<?, ?>> mappers = new HashMap<Pair<Class<?>,Class<?>>, Mappable<?,?>>();
	
	public <F,T> void registerMapper(Class<F> fromClass, Class<T> toClass, Mappable<F, T> mapper) {
		mappers.put(new Pair<Class<?>, Class<?>>(fromClass, toClass), mapper);
	}
	
	@SuppressWarnings("unchecked")
	public <F,T> Mappable<F, T> getMappable(Class<F> fromClass, Class<T> toClass) {
		return (Mappable<F, T>) mappers.get(new Pair<Class<F>, Class<T>>(fromClass,toClass));
	}
}
