package clewin;

/**
 * (c) Clewin Griffith 2013
 */
public class Sphere implements DistanceEstimator {
	public final double radius;
	private final Point center;
	
	public Sphere(Point center, double radius)
	{
		this.radius = radius;
		this.center = center;
	}

	@Override
	public double distanceFrom(Point p) {
		return Vector.length(this.center, p) - this.radius;
	}
	
	
}
