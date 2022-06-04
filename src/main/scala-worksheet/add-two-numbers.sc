import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 */
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    @tailrec
    def go(l1: ListNode, l2: ListNode, carry: Int, agg: ListNode): ListNode = {
      (l1, l2) match {
        case (null, null) => if (carry > 0) new ListNode(1, agg) else agg
        case (l, null) => go(l.next, null, if (l.x + carry > 9) 1 else 0, new ListNode((l.x + carry) % 10, agg))
        case (null, l) => go(l.next, null, if (l.x + carry > 9) 1 else 0, new ListNode((l.x + carry) % 10, agg))
        case (l1, l2) =>
          go(l1.next,
            l2.next,
            if (l1.x + l2.x + carry > 9) 1 else 0,
            new ListNode((l1.x + l2.x + carry) % 10, agg)
          )
      }
    }

    var head = go(l1, l2, 0, null)
    var rl: ListNode = null
    while (head != null) {
      rl = new ListNode(head.x, rl)
      head = head.next
    }
    rl
  }
}