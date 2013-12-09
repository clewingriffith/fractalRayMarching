package clewin;

import java.util.ArrayList;
import java.util.List;

/**
 * (c) Clewin Griffith 2013
 */
public class RayGenerator {

	Iterable<Ray> generateRays(Camera cam, Image screen)
	{
		List<Ray> rays = new ArrayList<Ray>();

		//got focal length.  1.0 = focal 
		
		//viewport halfwidth
		double vpHalf = Math.tan(0.5*cam.getFov());

		//map px to x:  
		
		Point camloc = cam.getLocation();
		
		Point viewportCenter = Vector.pointOnLine(cam.getLocation(), cam.getLookVector(), cam.getFocalLength());
		
		//Point viewportCenter = new Point(camloc.x, camloc.y, camloc.z - cam.getFocalLength());
		Direction screenSpaceRightVector = cam.getLookVector().cross(cam.getUpVector());
		System.out.println("ux="+screenSpaceRightVector);
		Direction screenSpaceUpVector = screenSpaceRightVector.cross(cam.getLookVector());
		System.out.println("uy="+screenSpaceUpVector);
		
		double pixwidth = screen.width / screen.xres;
		double pixheight = screen.height / screen.yres;
		
		
		for (int py = 0; py < screen.yres; py++) {
			double dy = - (0.5*screen.height) + pixheight*(0.5+py);
			for (int px=0; px< screen.xres; px++) {
				//map px to x;
			//	double dx = viewportCenter.x - (0.5*screen.width) + pixwidth*(0.5+px);
				double dx = - (0.5*screen.width) + pixwidth*(0.5+px);
				Point p = viewportCenter.plus(screenSpaceRightVector.times(dx)).plus(screenSpaceUpVector.times(dy)); // + dx*rightVector + dy*upVector
				//screenSpaceRightVector.times(dx)
 				//double z = viewportCenter.z;
				
				//System.out.println("px="+px+", py="+py+", "+new Point(x,y,z));
				rays.add(new Ray(px,py,cam.getLocation(), Vector.direction(cam.getLocation(), p)));
			}
		}
		return rays;

	}
	
}
