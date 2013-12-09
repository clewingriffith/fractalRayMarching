package clewin;

/**
 * (c) Clewin Griffith 2013
 */
public class RayMarcher {

	private DistanceEstimator distanceEstimator;
	
	public RayMarcher(DistanceEstimator distanceEstimator) {
		this.distanceEstimator = distanceEstimator;
	}
	
	public double march(Ray ray) {
		
		double delt = 0.01;
		double eps = 0.001;
		double mint = 0.0;
		double maxt = 10.0;
		
		int maxSteps = 64;
		double totalDistance = 0.0;
		
		for(int step=0; step<maxSteps; step++)
		{
			Point p = Vector.pointOnLine(ray.start, ray.direction, totalDistance);
			double d = distanceEstimator.distanceFrom(p);
			if(d<eps)
			{
				//System.out.println("hit");
				//return 1.0;
				//double depth=Vector.length(ray.start, p);
				//System.out.println(depth);
				//return 0.5; //(10.0-totalDistance)/5;
				return 1.0-((double)step/maxSteps);
			}
			totalDistance+=d;
		}
		//System.out.println("miss");
		return 0.0;
	}
			
	
}
