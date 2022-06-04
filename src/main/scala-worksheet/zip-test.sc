val list = List("mario", "luigi", "toad", "yoshi")
val s = list.head
s.zipWithIndex.foreach {
  case (_, index) => println(s.substring(index))
}


//val l = s.length
//for (
//  i <- 0 to l;
//  j <- i to l
//) {
//  if (s.substring(i, j).toSet.sizeCompare(s.substring(i, j)) == 0 && s.substring(i, j).length > m)
//    s.substring(i, j).length
//}

//val flag = list.map(_.foldLeft())
"12354".toSet.sizeCompare("1234")