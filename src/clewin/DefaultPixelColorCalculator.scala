package clewin

/**
 * Created by ClewinGriffith on 30/12/13.
 */
class DefaultPixelColorCalculator(val rayMarcher:RayMarcher) extends PixelColorCalculator {
  def calculatePixelColor(ray: Ray): Color = {
    val distance = rayMarcher.march(ray)
    return new GrayscaleMapper().getColor(1.0-distance)
  }
}
