package clewin

/**
 * Created by ClewinGriffith on 30/12/13.
 */
case class Color(red:Double, green:Double, blue:Double) {
  def getRGB():Int = {
    val r = (red*255).toInt
    val g = (green*255).toInt
    val b = (blue*255).toInt
    val col:Int = (r << 16) | (g << 8) | b;
    return col
  }

  def getDoubleArray():Array[Double] = Array(red*255,green*255,blue*255)


}
