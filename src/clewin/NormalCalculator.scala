package clewin

import Vec3Implicits._

/**
 * Created by ClewinGriffith on 31/12/13.
 * Uses finite differencing of a distance estimator to get the normal at a point
 */
class NormalCalculator(val distanceEstimator:DistanceEstimator) {

  private val delta:Double = 0.001
  private val dx = new Vec3(delta, 0.0,0.0)
  private val dy = new Vec3(0.0, delta, 0.0)
  private val dz = new Vec3(0.0, 0.0, delta)

  def getNormalAt(p:Point):Vec3 = {
    val c:Double = distanceEstimator.distanceFrom(p);
    val cx:Double = distanceEstimator.distanceFrom(p+dx)
    val cy:Double = distanceEstimator.distanceFrom(p+dy)
    val cz:Double = distanceEstimator.distanceFrom(p+dz)
    val n:Vec3 = new Vec3(cx-c,cy-c,cz-c).norm
    return n
  }

}
