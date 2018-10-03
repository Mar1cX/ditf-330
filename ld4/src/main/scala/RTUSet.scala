

object RTUSet {
  val bound = 1000
  type Set = Int => Boolean

  def contains(s: Set, elem: Int): Boolean = s(elem)
  def singletonSet(elem: Int): Set = set => set == elem
  def union(s: Set, t: Set): Set = (x : Int) => contains(s, x) || contains(t, x)
  def intersect(s: Set, t: Set): Set = (x : Int) => contains(s, x) && contains(t, x)
  def diff(s: Set, t: Set): Set = (x : Int) => contains(s, x) != contains(t, x)
  def filter(s: Set, p: Int => Boolean): Set = (x: Int) => contains(s, x) && contains(p, x)

  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (s(a) && !p(a)) false
      else iter(a + 1)
    }
    iter(-bound)
  }

  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, i => !p(i))
  def map(s: Set, f: Int => Int): Set = (x: Int) => exists(s, (z => x == f(z)))

  def toString(s: Set): String = {
    (0 to bound).withFilter(x => s(x)).map(x => { x }).mkString("{", ",", "}")
  }
}
