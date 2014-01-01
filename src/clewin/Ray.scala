package clewin

/**
 * (c) Clewin Griffith 2013
 */
case class Ray(px: Int, py: Int, start: Point, direction: Vec3)

case class RayIntersection(intersectionPoint:Point, distance:Double, ray:Ray)