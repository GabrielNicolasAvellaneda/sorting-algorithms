/**
 * Created by developer on 23/12/2015.
 */
object Quicksort {

  def leftList[T](list: List[T], pivot: T)(implicit ev:Ordering[T]) = {
    list.filter((x) => ev.lteq(x, pivot))
  }

  def rightList[T](list: List[T], pivot: T)(implicit ev:Ordering[T]) = {
    list.filter((x) => ev.gt(x, pivot))
  }

  def sort[T](list: List[T])(implicit ev:Ordering[T]) : List[T] =
    list match {
      case Nil => Nil
      case _ :: Nil => list
      case pivot :: tail =>
        val left = leftList(tail, pivot)
        val right = rightList(tail, pivot)
        (sort(left) :+ pivot) ::: sort(right)
    }
}
