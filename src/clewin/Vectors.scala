package clewin

/**
 * 
 */
import Vec3Implicits._

case class Point(val x:Double, val y:Double, val z:Double) {
  def +(o:Vec3) = new Point(x+o.x, y+o.y, z+o.z)
  def -(o:Vec3) = new Point(x-o.x, y-o.y, z-o.z)
  def -(o:Point) = new Vec3(x-o.x, y-o.y, z-o.z)

  def mod(c:Vec3):Point = {
    val qx: Double = if (c.x == 0.0) x else x - c.x * Math.floor(x / c.x)
    val qy: Double = if (c.y == 0.0) y else y - c.y * Math.floor(y / c.y)
    val qz: Double = if (c.z == 0.0) z else z - c.z * Math.floor(z / c.z)
    return new Point(qx, qy, qz)
  }
}
case class Direction(val x:Double, val y:Double, val z:Double)

case class Vec3(val x:Double, val y:Double, val z:Double) {

  def *(o:Vec3):Vec3 = new Vec3(x*o.x, y*o.y, z*o.z)
  def dot(o:Vec3):Double = (x*o.x + y*o.y + z*o.z)
  def x(o:Vec3):Vec3 = new Vec3(y * o.z - z * o.y, z * o.x - x * o.z, x * o.y - y * o.x)
  def -(o:Vec3):Vec3 = new Vec3(x-o.x,y-o.y, z-o.z)
  def +(o:Vec3):Vec3 = new Vec3(x+o.x,y+o.y, z+o.z)
  def length:Double = Math.sqrt(x*x+y*y+z*z)
  def norm:Vec3 = this * (doubleToVec3(1.0/this.length))
  def abs:Vec3 = new Vec3(Math.abs(x), Math.abs(y), Math.abs(z))
 // def clamp:Vec3 = new Vec3(Math.max(0.0,Math.min(1.0, x)), Math.max(0.0,Math.min(1.0, y)), Math.max(0.0,Math.min(1.0, z)))
}

object Vec3Implicits {

  implicit def doubleToVec3(scalar:Double) = new Vec3(scalar,scalar,scalar)
  implicit def pointToVec3(point:Point) = new Vec3(point.x, point.y, point.z)
  implicit def directionToVec3(point:Point) = new Vec3(point.x, point.y, point.z)
  implicit def vec3ToColor(v:Vec3) = new Color(v.x, v.y, v.z)
  implicit def colorToVec3(c:Color) = new Vec3(c.red, c.green, c.blue)

}

object Util {
  def direction(p:Point, p2:Point):Vec3 = p2 - p //new Vec3(p2.x-p.x, p2.y-p.y, p2.z-p.z)

  def pointOnLine(p: Point, d: Vec3, t: Double): Point = p + d*t
  def max(v1:Vec3, v2:Vec3) = new Vec3(Math.max(v1.x,v2.x), Math.max(v1.y,v2.y), Math.max(v1.z,v2.z))
  def length(v:Vec3) = v.length
  def abs(v:Vec3) = v.abs
  def abs(p:Point) = pointToVec3(p).abs
}