package clewin

/**
 * (c) Clewin Griffith 2013
 */
class RayMarcher {
  def this(distanceEstimator: DistanceEstimator) {
    this()
    this.distanceEstimator = distanceEstimator
  }

  def march(ray: Ray): Double = {
    val delt: Double = 0.01
    val eps: Double = 0.001
    val mint: Double = 0.0
    val maxt: Double = 10.0
    val maxSteps: Int = 64
    var totalDistance: Double = 0.0

      var step: Int = 0
      while (step < maxSteps) {

          val p: Point = Util.pointOnLine(ray.start, ray.direction, totalDistance)
          val d: Double = distanceEstimator.distanceFrom(p)
          if (d < eps) {
            return 1.0 - (step.asInstanceOf[Double] / maxSteps)
          }
          totalDistance += d
          step += 1

      }

    return 0.0
  }

  private var distanceEstimator: DistanceEstimator = null
}