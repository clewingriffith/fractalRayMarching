package clewin

/**
 * Created by ClewinGriffith on 31/12/13.
 */
trait LightingCalculator {
  def getIncidentLight(at:Point, geometry:GeometryIntersector)
}
