package clewin;

/**
 * (c) Clewin Griffith 2013
 */
public class GroundPlane implements DistanceEstimator {

	@Override
	public double distanceFrom(Point p) {
		return p.y()+0.3;
	}
	
}
