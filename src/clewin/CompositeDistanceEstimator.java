package clewin;

import java.util.ArrayList;
import java.util.List;

/**
 * (c) Clewin Griffith 2013
 */
public class CompositeDistanceEstimator implements DistanceEstimator {

	private List<DistanceEstimator> deList = new ArrayList<DistanceEstimator>();
	
	public CompositeDistanceEstimator()
	{
		
	}
	
	public void addChild(DistanceEstimator de) {
		deList.add(de);
	}
	
	@Override
	public double distanceFrom(Point p) {
		double minDistance = Double.MAX_VALUE;
		for(DistanceEstimator de : deList)
		{
			double d = de.distanceFrom(p);
			minDistance = Math.min(d, minDistance);
		}
		return minDistance;
	}

}
