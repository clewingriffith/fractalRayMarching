package clewin

/**
 * Created by ClewinGriffith on 29/12/13.
 */
object SpherePic extends App {

  val cam: Camera = new Camera().locatedAt(new Point(0.0, 1.0, 5.0)).pointingAt(new Point(0.0, 0.0, 0.0)).withFieldOfView(20).withFocalLength(0.2)
  val focalPlane: Image = new Image(640, 400, 0.16, 0.10)

  val de: DistanceEstimator = new Sphere(new Point(0.0, 0.0, 0.0), 0.3)

  val scene: CompositeDistanceEstimator = new CompositeDistanceEstimator
  scene.addChild(new GroundPlane)
  scene.addChild(de)

  val rayMarcher: RayMarcher = new RayMarcher(scene)
  val normalCalculator = new NormalCalculator(scene)
  val pixelCalculator = new DefaultPixelColorCalculator(rayMarcher, normalCalculator)
  val renderer: RayMarchRenderer = new RayMarchRenderer(pixelCalculator, new RayGenerator, cam, focalPlane)
  renderer.render
}

object BoxPic extends App {

  val cam: Camera = new Camera().locatedAt(new Point(0.0, 1.0, 5.0)).pointingAt(new Point(0.0, 0.0, 0.0)).withFieldOfView(20).withFocalLength(0.2)
  val focalPlane: Image = new Image(640, 400, 0.16, 0.10)

  val de: DistanceEstimator = new Box(new Point(0.4, 0.4, 0.4), 0.05)
  //val deMoved: DistanceEstimator = new Translate(de, new Vec3(1.0, 0.5, 0.0))

  val scene: CompositeDistanceEstimator = new CompositeDistanceEstimator
  scene.addChild(new GroundPlane)
  scene.addChild(de)

  val rayMarcher: RayMarcher = new RayMarcher(scene)
  val normalCalculator = new NormalCalculator(scene)
  val pixelCalculator = new DefaultPixelColorCalculator(rayMarcher, normalCalculator)
  val renderer: RayMarchRenderer = new RayMarchRenderer(pixelCalculator, new RayGenerator, cam, focalPlane)
  renderer.render
}

object SphereArray extends App {

  val cam: Camera = new Camera().locatedAt(new Point(0.0, 1.0, 5.0)).pointingAt(new Point(0.0, 0.0, 0.0)).withFieldOfView(20).withFocalLength(0.2)
  val focalPlane: Image = new Image(640, 400, 0.16, 0.10)

  val glyph = new Sphere(new Point(0.0, 0.0, 0.0), 0.3)
  val de: DistanceEstimator = new Repeated(glyph, new Vec3(1.0, 0.0, 1.0))

  val scene: CompositeDistanceEstimator = new CompositeDistanceEstimator
  scene.addChild(new GroundPlane)
  scene.addChild(de)

  val rayMarcher: RayMarcher = new RayMarcher(scene)
  val normalCalculator = new NormalCalculator(scene)
  val pixelCalculator = new DefaultPixelColorCalculator(rayMarcher, normalCalculator)
  val renderer: RayMarchRenderer = new RayMarchRenderer(pixelCalculator, new RayGenerator, cam, focalPlane)
  renderer.render
}

object CubeArray extends App {

  val cam: Camera = new Camera().locatedAt(new Point(0.0, 1.0, 5.0)).pointingAt(new Point(0.0, 0.0, 0.0)).withFieldOfView(20).withFocalLength(0.2)
  val focalPlane: Image = new Image(640, 400, 0.16, 0.10)

  val glyph = new Box(new Point(0.4, 0.4, 0.4))
  val de: DistanceEstimator = new Repeated(glyph, new Vec3(1.0, 0.0, 2.0))

  val scene: CompositeDistanceEstimator = new CompositeDistanceEstimator
  scene.addChild(new GroundPlane)
  scene.addChild(de)

  val rayMarcher: RayMarcher = new RayMarcher(scene)
  val normalCalculator = new NormalCalculator(scene)
  val pixelCalculator = new DefaultPixelColorCalculator(rayMarcher, normalCalculator)
  val renderer: RayMarchRenderer = new RayMarchRenderer(pixelCalculator, new RayGenerator, cam, focalPlane)
  renderer.render
}
