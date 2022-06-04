/* 
A lazy evaluation can be defined as a kind of delayed evaluation. 
In this method, the evaluation of an expression is done when the value of that expression is actually used.
As opposed that, in the case of eager evaluation, expressions are evaluated at the time of program execution.
 */

// Example 1
val num1 = 10
var num2 = 20
/*
lazyTime is defined before eagerTime and also printed before eagerTime, but has high value. This means lazyTime was not evaluated the expression was executed
* */
import java.util.Calendar
lazy val lazyTime = Calendar.getInstance().getTime
val eagerTime = Calendar.getInstance().getTime

println(lazyTime)
println(eagerTime)

/*
We have smaller values to hold in the memory. But imagine thousands of records being evaluated. 
If we are not using those records then holding them in the computer's memory is wasteful.
In the case of even larger data, the computation can become infeasible.

*/
def myMethod(myArgs: () => Int): Unit =
  println(myArgs())


myMethod(() => 5)