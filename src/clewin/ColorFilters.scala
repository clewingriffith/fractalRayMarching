package clewin

/**
 * Created by ClewinGriffith on 30/12/13.
 */
class Gamma {
  def apply(c: Color):Color = {
    return new Color(c.red/2.2, c.green/2.2, c.blue/2.2)
  }
}
