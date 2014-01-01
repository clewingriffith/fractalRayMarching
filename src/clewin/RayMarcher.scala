package clewin

/**
 * (c) Clewin Griffith 2013
 */
class RayMarcher(val distanceEstimator: DistanceEstimator) extends GeometryIntersector {

  def findIntersection(ray: Ray): RayIntersection = {
    val eps: Double = 0.001
    val maxSteps: Int = 128
    var totalDistance: Double = 0.0
    var mint = 0.01
    var maxt = 100.0
    var minDistanceFactor = 1.0
    var minDistance = 1000.0
      var t: Double = mint
      while (t < maxt) {

          val p: Point = Util.pointOnLine(ray.start, ray.direction, t)
          val d: Double = distanceEstimator.distanceFrom(p)
          minDistance = Math.min(minDistance, d)
          minDistanceFactor = Math.min(minDistanceFactor, d/t)
          if (d < eps) {
            return RayIntersection(p,d,ray, minDistanceFactor)// (step.asInstanceOf[Double] / maxSteps)
          }
         // totalDistance += d
          t += d
          //step += 1

      }

    return RayIntersection(null, minDistance,ray, minDistanceFactor)
  }

}