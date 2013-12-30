package clewin;

import java.io.IOException;

/**
 * (c) Clewin Griffith 2013
 */
public class Main {

	public static void main(String[] args) throws IOException
	{
		cameraTest();
	}
	
	public static void checkerBoard() throws IOException
	{
		System.out.println("Checkerboard");
		Image i = new Image(100, 100, 1.0, 1.0);
	    for(int h=0;h<100;h++)
	    	for(int w=0;w<100;w++)
	    	  if (((h/10)+(w/10)) % 2 == 0) i.write(w,h,0.0); // checkerboard pattern.
	    	  else i.write(w,h,0.5);
		i.save();
	}
	
	public static void cameraTest() throws IOException
	{
		Camera cam = new Camera()
			.locatedAt(new Point(0.0, 1.0, 5.0))
			.pointingAt(new Point(0.0,0.0,0.0))
			.withFieldOfView(20)
			.withFocalLength(0.2);

		Image focalPlane = new Image(640, 400, 0.16, 0.10);

		//DistanceEstimator de = new Repeated(
		//		new Sphere(new Point(0.0,0.0,0.0), 0.3),
		//		new Point(1.0, 0.0, 2.0));
		/*
		CompositeDistanceEstimator scene = new CompositeDistanceEstimator();
		de.addChild(new Sphere(new Point(0.0,0.0,0.0), 1.0));
		de.addChild(new Sphere(new Point(3.0,0.0,0.0), 1.0));
		de.addChild(new Sphere(new Point(1.0,-1.0,0.0), 1.0));
		*/

	//	CompositeDistanceEstimator scene = new CompositeDistanceEstimator();
	//	scene.addChild(new GroundPlane());
	//	scene.addChild(de);

	//	RayMarcher rayMarcher = new RayMarcher(scene);

	//	RayMarchRenderer renderer = new RayMarchRenderer(rayMarcher, new RayGenerator(), cam, focalPlane);

	//	renderer.render();
	}

}
