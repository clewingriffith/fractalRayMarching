package clewin

/**
 * (c) Clewin Griffith 2013
 */
class RayMarcher(val distanceEstimator: DistanceEstimator) extends GeometryIntersector {

  def findIntersection(ray: Ray): RayIntersection = {
    val eps: Double = 0.001
    val maxSteps: Int = 128
    var totalDistance: Double = 0.0
    var minDistance = 1000.0
      var step: Int = 0
      while (step < maxSteps) {

          val p: Point = Util.pointOnLine(ray.start, ray.direction, totalDistance)
          val d: Double = distanceEstimator.distanceFrom(p)
          minDistance = Math.min(minDistance, d)
          if (d < eps) {
            return RayIntersection(p,d,ray)// (step.asInstanceOf[Double] / maxSteps)
          }
          totalDistance += d
          step += 1

      }

    return RayIntersection(null, minDistance,ray)
  }

}