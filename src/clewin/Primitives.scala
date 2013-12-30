package clewin

import Vec3Implicits._
import Util._
/**
 * Created by ClewinGriffith on 29/12/13.
 */

class Primitives {

}

/**
 * (c) Clewin Griffith 2013
 */
class Sphere(c: Point, rad: Double) extends DistanceEstimator {

  val center:Point = c
  val radius:Double = rad

  def distanceFrom(p: Point): Double = {
    return (center - p).length - radius
  }

}

  class Box(b:Point) extends DistanceEstimator {
    val corner:Vec3 = pointToVec3(b)

    def distanceFrom(p: Point): Double = {
      return length(max(abs(p)-corner, 0.0))
    }
  }


class Repeated(glyph1: DistanceEstimator, spacer1: Vec3) extends DistanceEstimator {

  val glyph:DistanceEstimator = glyph1
  val spacer:Vec3 = spacer1

  def distanceFrom(p: Point): Double = {
    val q = (p mod this.spacer) - 0.5*this.spacer
    return glyph.distanceFrom(q)
  }

}

class Translate(glyph1:DistanceEstimator, t:Vec3) extends DistanceEstimator {
  val dist:Vec3 = t
  val glyph:DistanceEstimator = glyph1

  def distanceFrom(p: Point): Double = {
    val q = p - t
    return glyph.distanceFrom(q)
  }
}
