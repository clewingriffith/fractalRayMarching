package clewin

import Vec3Implicits._
/**
 * Created by ClewinGriffith on 30/12/13.
 */
class DefaultPixelColorCalculator(val geometryIntersector:GeometryIntersector, val normalCalculator:NormalCalculator) extends PixelColorCalculator {

  val softShadowHardness = 1.0

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
   // val reflectance = 0.2
   // val lightStrength = 1.0
   // val surfaceBrightness = reflectance*lightStrength * (normal dot lightVector)

    val sunDir = new Vec3(-2.0,2.0,-0.5).norm
    val indirectDir = (sunDir*new Vec3(-1.0, 0.0, -1.0)).norm

    val sun:Double = clamp( normal dot sunDir )
    val sky = clamp( 0.5 + 0.5*normal.y)
    val indirect = clamp( normal dot indirectDir )

    val shadow = calcShadow(intersection.intersectionPoint, sunDir)
    val occlusion = calcOcclusion(intersection.intersectionPoint, normal)

    val sunColor = new Color(1.64,1.27,0.99)
    val skyColor = new Color(0.16,0.20,0.28)
    val indColor = new Color(0.40,0.28,0.20)

    val combinedLight = sunColor*sun*shadow + skyColor*sky*occlusion + indColor*indirect*occlusion
    //val combinedLight = sunColor*sun*shadow

    val material = new Color(0.2,0.2,0.2)
    val surfaceColor = material*combinedLight
    return surfaceColor
      /*
      vec3 lin  = sun*vec3(1.64,1.27,0.99)*pow(vec3(sha),vec3(1.0,1.2,1.5));
      lin += sky*vec3(0.16,0.20,0.28)*occ;
      lin += ind*vec3(0.40,0.28,0.20)*occ;*/

   // val lightRay:Ray = new Ray(0,0,intersection.intersectionPoint+(lightVector*0.1), lightVector)
   // val lightOcclusion = geometryIntersector.findIntersection(lightRay)
   // if(lightOcclusion.distanceFromGeometry > 0.001)
   // {

   //   var shadowFactor = (lightOcclusion.minDistanceFactor)
     // if(shadowFactor>1.0)
     //   shadowFactor = 1.0
     // System.out.println(shadowFactor)
      //val shadowFactor = 1.0-Math.min(lightOcclusion.numSteps .distance, softShadowDistance)/softShadowDistance
    //if(shadowFactor > 0.9) System.out.println(shadowFactor)
  //    return new GrayscaleMapper().getColor(surfaceBrightness*shadowFactor)
  //  }
  //  else
  //  {
  //    return new GrayscaleMapper().getColor(0.0)
  //  }
    //val light = lightingCalculator.getIncidentLight(intersection.intersectionPoint, geometryIntersector)
    //val lightIntersection = lightIntersector.findIntersection
    //return new GrayscaleMapper().getColor(surfaceBrightness)
    //return new GrayscaleMapper().getColor(1.0-(intersection.distance/10))
    }
  }

  def calcOcclusion(pos:Point, normal:Vec3):Double = {
    val ray:Ray = new Ray(0,0,pos, normal)
    val lightOcclusion = geometryIntersector.findIntersection(ray)
    return lightOcclusion.minDistanceFactor
    //return 1.0
  }

  def calcShadow(pos:Point, lightDir:Vec3):Double = {
    val ray:Ray = new Ray(0,0,pos, lightDir)
    val lightOcclusion = geometryIntersector.findIntersection(ray)
    return lightOcclusion.minDistanceFactor
  }

  def clamp(x:Double) = Math.max(0.0,Math.min(1.0, x))

}
