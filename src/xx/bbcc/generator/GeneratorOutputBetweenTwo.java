package xx.bbcc.generator;

import xx.bbcc.generator.PointMarker.EndMarker;
import xx.bbcc.generator.PointMarker.StartMarker;

public class GeneratorOutputBetweenTwo<F,T> implements BetweenTwoIterator<F>{

	private Generator<F, T> generator;
	private SequenceGeneratorFactory<F> sequenceGeneratorFactory;

	
	public GeneratorOutputBetweenTwo(Generator<F, T> generator, SequenceGeneratorFactory<F> sequenceGeneratorFactory) {
		this.generator = generator;
		this.sequenceGeneratorFactory = sequenceGeneratorFactory;
	}


	@Override
	public void doSthBetween(StartMarker<F> start, EndMarker<F> end) {
		
		F startF = start.getPoint();
		F endF = end.getPoint();
		
		SequenceGenerator<F> sg = sequenceGeneratorFactory.getSequenceGenerator(startF);
		
		for( ; !sg.current().equals(endF) ; ) {
			T t = generator.generate(sg);
			System.out.println(t.toString());
		}
		
	}
	
	

}
