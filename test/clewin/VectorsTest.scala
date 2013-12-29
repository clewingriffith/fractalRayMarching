package clewin

import org.junit.{Assert, Test}

/**
 * 
 */

class VectorsTest {
  @Test
  def testDotProduct() {
    val a = new Vec3(1.0,2.0,3.0)
    val b = new Vec3(2.0,3.0,4.0)
    val c = a * b
    Assert.assertEquals(2.0,c.x, 0.01)
    Assert.assertEquals(2.0,c.y, 0.01)
    Assert.assertEquals(2.0,c.z, 0.01)
  }


}