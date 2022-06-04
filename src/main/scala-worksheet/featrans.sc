case class Point(score: Double, label: String)
val data = Seq(Point(1.0, "a"), Point(2.0, "b"), Point(3.0, "c"))

val a = data
  .map(p => (p.score, p.score, Set(p.label)))
  .reduce((x, y) => (math.min(x._1, y._1), math.max(x._2, y._2), x._3 ++ y._3))

val features = data.map { p =>
  (p.score - a._1) / (a._2 - a._1) :: a._3.toList.sorted.map(s => if (s == p.label) 1.0 else 0.0)
}
