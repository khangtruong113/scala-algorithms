package dev.functional.foundational.components

case class Selection(perimiter: Int, gardenNets: List[Int])

object GreedyAlgorithms {
  def main(args: Array[String]): Unit = {
    val gardenNetLengths = Array(15, 10, 3, 2, 1)
    val perimeter = 50
    println(selectNets(perimeter, gardenNetLengths))
  }
  
  def selectNets(perimeter: Int, netLengths: Array[Int]): List[Int] = {
    val finalSelection = netLengths.foldLeft(Selection (perimeter, List())) {
      (selection, length) => {
        val numbers = selection.perimiter / length
        val netsToBuy = List.fill(numbers) (length)
        Selection(selection.perimiter - numbers * length, selection.gardenNets ::: netsToBuy)
      }
    }
    finalSelection.gardenNets
  }
}
