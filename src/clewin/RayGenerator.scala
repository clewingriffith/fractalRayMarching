package clewin

import java.util.ArrayList
import java.util.List

import Vec3Implicits._
import Vec3._
import Point._
/**
 * (c) Clewin Griffith 2013
 */
class RayGenerator {
  def generateRays(cam: Camera, screen: Image): List[Ray] = {
    val rays: ArrayList[Ray] = new ArrayList[Ray]
    val vpHalf: Double = Math.tan(0.5 * cam.getFov)
  //  val camloc: Point = cam.getLocation
    val viewportCenter: Point = Util.pointOnLine(cam.getLocation, cam.getLookVector.norm, cam.getFocalLength)
    System.out.println("vp="+viewportCenter)
    val screenSpaceRightVector: Vec3 = (cam.getLookVector.norm x cam.getUpVector.norm)
    System.out.println("ux=" + screenSpaceRightVector)
    val screenSpaceUpVector: Vec3 = (screenSpaceRightVector x cam.getLookVector.norm)
    System.out.println("uy=" + screenSpaceUpVector)
    val pixwidth: Double = screen.width / screen.xres
    val pixheight: Double = screen.height / screen.yres

    var px:Int=0
    var py:Int=0

    for (py <- 0 until screen.yres) {
      val dy = - (0.5*screen.height) + pixheight*(0.5+py)
      for (px <- 0 until screen.xres) {

        val dx = - (0.5*screen.width) + pixwidth*(0.5+px)

        val ux:Vec3 = screenSpaceRightVector*dx
        val uy = screenSpaceUpVector*dy
        val p: Point = viewportCenter+ux+uy
        val r:Ray = new Ray(px,py,cam.getLocation, Util.direction(cam.getLocation, p).norm)
       rays.add(r)
      }
    }

   // return rays
    return rays
  }
}