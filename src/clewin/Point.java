package clewin;

/**
 * (c) Clewin Griffith 2013
 */
public class Point {
	
	
	
	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double x;
	public double y;
	public double z;
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	public Point minus(Point o) {
		return new Point(x-o.x,y-o.y,z-o.z);
	}
	
	public Point plus(Point o) {
		return new Point(x+o.x, y+o.y, z+o.z);
	}
}
