package dev.functional.foundational.components

object MultipleTwoApp {
  def main(args: Array[String]): Unit = {
    val myNumbers = Array(0, 2, 4, 6, 8, 10)
    multipleBy2(myNumbers).foreach(println)
  }
  
  def multipleBy2(myArray: Array[Int]): Array[Int] = {
    val size = myArray.length
    val myTempArray = new Array[Int](size)
    var i = 0
    while (i < size) {
      myTempArray(i) = myArray(i) * 2
      i += 1
    }
    myTempArray
  }
}
