package clewin

import java.io.IOException

/**
 * (c) Clewin Griffith 2013
 */
class RayMarchRenderer(pixelColorCalculator: PixelColorCalculator, rayGenerator: RayGenerator, val cam: Camera, focalPlane: Image) {

  private val colorFilter = new Gamma()


  def render {
    val rays = rayGenerator.generateRays(cam, focalPlane)
    import scala.collection.JavaConversions._
    for (ray <- rays) {
      val pixelColor = pixelColorCalculator.calculatePixelColor(ray)
      val filteredColor = colorFilter.apply(pixelColor)
      //val `val`: Double = rayMarcher.march(ray)
      focalPlane.write(ray.px, focalPlane.yres - ray.py - 1, filteredColor)
    }
    focalPlane.save
  }



}