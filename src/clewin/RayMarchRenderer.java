package clewin;

import java.io.IOException;

/**
 * (c) Clewin Griffith 2013
 */
public class RayMarchRenderer {

	private RayMarcher rayMarcher;
	private RayGenerator rayGenerator;
	private Camera cam;
	private Image focalPlane;
	

	public RayMarchRenderer(RayMarcher rayMarcher, RayGenerator rayGenerator,
			Camera cam, Image focalPlane) {
		this.rayMarcher = rayMarcher;
		this.rayGenerator = rayGenerator;
		this.cam = cam;
		this.focalPlane = focalPlane;
	}
	
	public void render() throws IOException {
		Iterable<Ray> rays = rayGenerator.generateRays(cam, focalPlane);
		for(Ray ray : rays) {
			double val = rayMarcher.march(ray);
			focalPlane.write(ray.px, focalPlane.yres-ray.py-1, val);
		}
		focalPlane.save();
	}



	
}
