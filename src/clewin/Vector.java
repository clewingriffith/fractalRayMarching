package clewin;

/**
 * (c) Clewin Griffith 2013
 */
public class Vector {

	public static double length(Point p1, Point p2)
	{
		double dx = p2.x - p1.x;
		double dy = p2.y - p1.y;
		double dz = p2.z - p1.z;
		return Math.sqrt(dx*dx+dy*dy+dz*dz);
	}
	
	public static Direction direction(Point from, Point to)
	{
		return new Direction(to.x-from.x, to.y-from.y, to.z-from.z);
	}
	
	public static Point pointOnLine(Point p, Direction d, double t)
	{
		return new Point(p.x+d.x*t, p.y+d.y*t, p.z+d.z*t);
	}

	public static Point mod(Point p, Point c) {
		
		double qx = (c.x==0.0) ? p.x : p.x - c.x*Math.floor(p.x/c.x);
		double qy = (c.y==0.0) ? p.y : p.y - c.y*Math.floor(p.y/c.y);
		double qz = (c.z==0.0) ? p.z : p.z - c.z*Math.floor(p.z/c.z);
		return new Point(qx,qy,qz);
	}

}
