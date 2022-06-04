import scala.annotation.tailrec

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val nextNode: ListNode => ListNode = node => Option(node).map(_.next).orNull

    val nodeVal: ListNode => Option[Int] = node => Option(node).map(_.x)

    def sumElements(e1: Option[Int], e2: Option[Int], remain: Int): Option[(Int, Int)] = (e1, e2) match {
      case (None, None) => None
      case _ =>
        val value = e1.getOrElse(0) + e2.getOrElse(0) + remain
        Some {
          if (value < 10)
            (value, 0)
          else
            (value - 10, 1)
        }
    }

    @tailrec
    def reverse(node: ListNode, acc: ListNode = null): ListNode = Option(node) match {
      case Some(node) => reverse(node.next, new ListNode(node.x, acc))
      case _ => acc
    }

    @tailrec
    def sum(n1: ListNode, n2: ListNode, acc: ListNode = null, rem: Int = 0): ListNode = {
      sumElements(nodeVal(n1), nodeVal(n2), rem) match {
        case Some((value, remain)) => sum(nextNode(n1), nextNode(n2), new ListNode(value, acc), remain)
        case None if rem > 0 => new ListNode(rem, acc)
        case _ => acc
      }

    }

    reverse(sum(l1, l2))
  }
}

val n1 = new ListNode(3)
val n2 = new ListNode(4, n1)
val n3 = new ListNode(2, n2)
val n4 = new ListNode(1, n3)

//Solution.addTwoNumbers()