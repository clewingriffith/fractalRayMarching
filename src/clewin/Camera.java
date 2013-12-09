package clewin;

/**
 * (c) Clewin Griffith 2013
 */
public class Camera {

	private Point location;
	private double fov;
	private Point target;
	private double focalLength; //distance to screen
	private Direction up = new Direction(0.0, 1.0, 0.0);
	
	public Camera locatedAt(Point p) {
		this.location = p;
		return this;
	}
	
	public Camera withFieldOfView(double fovDegrees)
	{
		this.fov = Math.toRadians(fovDegrees);
		return this;
	}
	
	public Camera withFocalLength(double len) {
		this.focalLength = len;
		return this;
	}
	
	public Camera pointingAt(Point p) {
		this.target = p;
		return this;
	}
	
	public Camera withUpVector(Direction up) {
		this.up = up;
		return this;
	}
	
	public double getFov() {
		return this.fov;
	}
	
	public Point getLocation() {
		return this.location;
	}

	public double getFocalLength() {
		return this.focalLength;
	}
	
	public Direction getLookVector() {
		return Vector.direction(location, target);
	}
	
	public Direction getUpVector() {
		return up;
	}
	
}
