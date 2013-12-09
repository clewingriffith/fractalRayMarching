package clewin;

/**
 * (c) Clewin Griffith 2013
 */
public class Ray {

	public final Point start;
	public final Direction direction;
	public final int px;
	public final int py;
	
	public Ray(int px, int py, Point start, Direction direction) {
		this.px = px;
		this.py = py;
		this.start = start;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Ray [px=" + px + ", py=" + py + ", direction=" + direction
				+ "]";
	}


	
}
