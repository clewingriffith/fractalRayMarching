package clewin;

/**
 * (c) Clewin Griffith 2013
 */
public class Repeated implements DistanceEstimator {

	private final DistanceEstimator glyph;
	private final Point spacer;
	
	public Repeated(DistanceEstimator glyph, Point spacer)
	{
		this.glyph = glyph;
		this.spacer = spacer;
	}

	@Override
	public double distanceFrom(Point p) {
		Point q = Vector.mod(p, spacer);
		Point q1 = new Point(q.x-0.5*spacer.x, q.y-0.5*spacer.y, q.z-0.5*spacer.z);
		return glyph.distanceFrom(q1);
	}
	
}
