package xx.bbcc.generator;

import java.util.HashMap;
import java.util.Map;

public enum ClassificatorManager {
	INSTANCE;
	
	private Map<String, ClassificatorFactory<?>> classificators = new HashMap<String, ClassificatorFactory<?>>();
	
	public void putClassificator(String name, ClassificatorFactory<?> factory) {
		classificators.put(name, factory);
	}
	
	@SuppressWarnings("unchecked")
	public <T> ClassificatorFactory<T> getClassificatorFactory(String name) {
		return (ClassificatorFactory<T>) classificators.get(name);
	}
}
