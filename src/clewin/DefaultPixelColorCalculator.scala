package clewin

import Vec3Implicits._
/**
 * Created by ClewinGriffith on 30/12/13.
 */
class DefaultPixelColorCalculator(val geometryIntersector:GeometryIntersector, val normalCalculator:NormalCalculator) extends PixelColorCalculator {

  def calculatePixelColor(ray: Ray): Color = {
    val intersection = geometryIntersector.findIntersection(ray)
    if(intersection.intersectionPoint eq null)
    {
      return new GrayscaleMapper().getColor(0.0)
    }
    else
    {
    val normal:Vec3 = normalCalculator.getNormalAt(intersection.intersectionPoint)
    val lightVector = new Vec3(-2.0,2.0,-0.5).norm
    val l = lightVector.length
    val reflectance = 0.2
    val lightStrength = 1.0
    val surfaceBrightness = reflectance*lightStrength * (normal dot lightVector)

    val lightRay:Ray = new Ray(0,0,intersection.intersectionPoint+(lightVector*0.1), lightVector)
    val lightOcclusion = geometryIntersector.findIntersection(lightRay)
    if(lightOcclusion.distance > 0.001)
    {
      return new GrayscaleMapper().getColor(surfaceBrightness)
    }
    else
    {
      return new GrayscaleMapper().getColor(0.0)
    }
    //val light = lightingCalculator.getIncidentLight(intersection.intersectionPoint, geometryIntersector)
    //val lightIntersection = lightIntersector.findIntersection
    //return new GrayscaleMapper().getColor(surfaceBrightness)
    //return new GrayscaleMapper().getColor(1.0-(intersection.distance/10))
    }
  }
}
