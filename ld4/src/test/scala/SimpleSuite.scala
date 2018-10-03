import org.scalatest.FunSuite

class SimpleSuite extends FunSuite {

  test("Set contains a given element") {
    val s:RTUSet.Set = (x: Int) => x == 1
    assert(RTUSet.contains(s, 1))
  }

  test("Singleton set contains a given element") {
    val s:RTUSet.Set = RTUSet.singletonSet(2)
    assert(RTUSet.contains(s, 2))
  }

  test("Union set contains both elements") {
    val s = RTUSet.union(RTUSet.singletonSet(1),RTUSet.singletonSet(2))
    assert(RTUSet.contains(s, 1))
    assert(RTUSet.contains(s, 2))
  }

  test("Intersect set works correctly") {
    val s = RTUSet.intersect(RTUSet.union(RTUSet.singletonSet(1),RTUSet.singletonSet(2)),RTUSet.singletonSet(1))
    assert(RTUSet.contains(s, 1))
    assert(!RTUSet.contains(s, 2))
  }

  test("Filter set works correctly") {
    val s = RTUSet.filter(RTUSet.union(RTUSet.singletonSet(1),RTUSet.singletonSet(2)), (x: Int) => x == 1)
    assert(RTUSet.contains(s, 1))
    assert(!RTUSet.contains(s, 2))
  }

  test("Exists set works correctly") {
    val s = RTUSet.union(RTUSet.singletonSet(1),RTUSet.singletonSet(2))
    val s1 = RTUSet.exists(s, (x: Int) => x == 1)
    val s2 = RTUSet.exists(s, (x: Int) => x == 2)
    assert(s1)
    assert(s2)
  }

  test("Map set works correctly") {
    val s1 = RTUSet.map(RTUSet.singletonSet(1), (x: Int) => x * -1)
    assert(RTUSet.contains(s1,-1))
  }

  test("To String works correctly") {
    val s = RTUSet.union(RTUSet.singletonSet(1),RTUSet.singletonSet(2))
    assert(RTUSet.toString(s) == "{1,2}")
  }
}

