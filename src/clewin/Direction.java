package clewin;

/**
 * (c) Clewin Griffith 2013
 */
public class Direction {
	
	
	
	public Direction(double dx, double dy, double dz) {
		double len = Math.sqrt(dx*dx+dy*dy+dz*dz);
		this.x = dx/len;
		this.y = dy/len;
		this.z = dz/len;
	}
	public double x;
	public double y;
	public double z;
	@Override
	public String toString() {
		return "Direction [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	public Direction cross(Direction o) {
		return new Direction(
				y*o.z - z*o.y,
				z*o.x - x*o.z,
				x*o.y - y*o.x
				);
	}
	
	public Point times(double dist) {
		return new Point(x*dist, y*dist, z*dist);
	}
	
}
