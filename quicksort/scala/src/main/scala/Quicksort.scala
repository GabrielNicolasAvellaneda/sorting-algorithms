/**
 * Created by developer on 23/12/2015.
 */
object Quicksort {

  trait NumberLike[T] {
    def <= (x:T, y:T) : Boolean
    def > (x:T, y:T) : Boolean
  }

  object NumberLike {
    implicit object NumberLikeDouble extends NumberLike[Double] {
      override def <=(x: Double, y: Double): Boolean = x <= y
      override def >(x: Double, y: Double): Boolean = x > y
    }

    implicit object NumberLikeInt extends NumberLike[Int] {
      override def <=(x: Int, y: Int): Boolean = x <= y
      override def >(x: Int, y: Int): Boolean = x > y
    }
  }

  def leftList[T](list: List[T], pivot: T)(implicit ev:NumberLike[T]) = {
    list.filter((x) => ev.<=(x, pivot))
  }

  def rightList[T](list: List[T], pivot: T)(implicit ev:NumberLike[T]) = {
    list.filter((x) => ev.>(x, pivot))
  }

  def sort[T](list: List[T])(implicit ev:NumberLike[T]) : List[T] =
    list match {
      case Nil => Nil
      case _ :: Nil => list
      case pivot :: tail =>
        val left = leftList(tail, pivot)
        val right = rightList(tail, pivot)
        (sort(left) :+ pivot) ::: sort(right)
    }
}
