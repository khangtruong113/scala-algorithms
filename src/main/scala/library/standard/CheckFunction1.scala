package library.standard

object CheckFunction1 extends App {

  val double = new (Int => Int) {
    override def apply(v1: Int): Int = v1 * 2
  }

  print(double(2))
}
