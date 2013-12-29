package clewin

/**
 * 
 */



class Vec3(val x:Double, val y:Double, val z:Double) {

  implicit def doubleToVec3(scalar:Double) = new Vec3(scalar,scalar,scalar)
  def dot(o:Vec3):Double = (x*o.x + y*o.y + z*o.z)
  def cross(o:Vec3):Vec3 = new Vec3(y * o.z - z * o.y, z * o.x - x * o.z, x * o.y - y * o.x)

}