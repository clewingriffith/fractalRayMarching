package clewin

/**
 * Created by ClewinGriffith on 30/12/13.
 */
class Gamma {
  def apply(c: Color):Color = {
    return new Color(Math.pow(c.red, 0.45), Math.pow(c.green,0.45), Math.pow(c.blue, 0.45))
  }
}
