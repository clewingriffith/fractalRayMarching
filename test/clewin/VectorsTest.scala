package clewin

import org.junit.{Assert, Test}

/**
 * 
 */
import Vec3Implicits._

class VectorsTest {
  @Test
  def testVectorDotProduct() {
    val a = new Vec3(1.0,2.0,3.0)
    val b = new Vec3(2.0,3.0,4.0)
    val c = a dot b
    Assert.assertEquals(2.0+6.0+12.0,c, 0.01)
  }

  @Test
  def testProductWithScalarSecondArgument() {
    val a:Double = 2.0
    val b = new Vec3(2.0,3.0,4.0)
    val c = b * a
    Assert.assertEquals(new Vec3(4.0,6.0,8.0), c)
  }


  @Test
  def testProductWithScalarFirstArgument() {
    val a:Double = 2.0
    val b = new Vec3(2.0,3.0,4.0)
    val c = a * b
    Assert.assertEquals(new Vec3(4.0,6.0,8.0), c)
  }


}