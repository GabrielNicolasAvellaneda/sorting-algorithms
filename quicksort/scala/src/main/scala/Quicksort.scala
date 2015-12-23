/**
 * Created by developer on 23/12/2015.
 */
object Quicksort {

  def leftList(list: List[Int], pivot: Int) = {
    list.filter((x) => x <= pivot )
  }

  def rightList(list: List[Int], pivot: Int) = {
    list.filter((x) => x > pivot)
  }

  def sort(list: List[Int]) : List[Int] = {
    list match {
      case Nil => Nil
      case _ :: Nil => list
      case pivot :: tail =>
        val left = leftList(tail, pivot)
        val right = rightList(tail, pivot)
        (sort(left) :+ pivot) ::: sort(right)
    }
  }
}
