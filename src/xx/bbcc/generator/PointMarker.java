package xx.bbcc.generator;

public interface PointMarker<F> {
	
	public static interface StartMarker<F> extends PointMarker<F> {}
	public static interface EndMarker<F> extends PointMarker<F> {}
	
	F getPoint();
}
