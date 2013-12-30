package clewin

/**
 * (c) Clewin Griffith 2013
 */
class Camera {
  def locatedAt(p: Point): Camera = {
    this.location = p
    return this
  }

  def withFieldOfView(fovDegrees: Double): Camera = {
    this.fov = Math.toRadians(fovDegrees)
    return this
  }

  def withFocalLength(len: Double): Camera = {
    this.focalLength = len
    return this
  }

  def pointingAt(p: Point): Camera = {
    this.target = p
    return this
  }

  def withUpVector(up: Vec3): Camera = {
    this.up = up
    return this
  }

  def getFov: Double = {
    return this.fov
  }

  def getLocation: Point = {
    return this.location
  }

  def getFocalLength: Double = {
    return this.focalLength
  }

  def getLookVector: Vec3 = {
    return Util.direction(location, target)
  }

  def getUpVector: Vec3 = {
    return up
  }

  private var location: Point = null
  private var fov: Double = .0
  private var target: Point = null
  private var focalLength: Double = .0
  private var up: Vec3 = new Vec3(0.0, 1.0, 0.0)
}