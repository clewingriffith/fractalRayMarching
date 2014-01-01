package clewin

import org.junit.{Assert, Test}

/**
 * Created by ClewinGriffith on 31/12/13.
 */
class NormalCalculatorTest {
  @Test
  def testSphereNormal()
  {
    val sphere = new Sphere(new Point(0.0,0.0,0.0), 1.0)
    val normalCalculator = new NormalCalculator(sphere)
    //get the normal on the sphere surface on the positive z axis. This should face out in the direction of the z axis
    val n = normalCalculator.getNormalAt(new Point(0.0, 0.0, 1.0))
    System.out.println(n)
    Assert.assertEquals(0.0, n.x, 0.001)
    Assert.assertEquals(0.0, n.y, 0.001)
    Assert.assertEquals(1.0, n.z, 0.001)

    val n2 = normalCalculator.getNormalAt(new Point(1.0, 0.0, 0.0))
    System.out.println(n2)
    Assert.assertEquals(1.0, n2.x, 0.001)
    Assert.assertEquals(0.0, n2.y, 0.001)
    Assert.assertEquals(0.0, n2.z, 0.001)
  }
}
