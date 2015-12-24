import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by developer on 23/12/2015.
 */
class QuicksortTest extends FlatSpec with Matchers {

  "Quicksort" should "return Nil with an empty List" in {
    Quicksort.sort[Int](List()) should === (Nil)
  }

  "Quicksort" should "sort a list of one element" in {
    Quicksort.sort(List(1)) should === (List(1))
  }

  "Quicksort" should "sort a list of two elements" in {
    Quicksort.sort(List(2,1)) should === (List(1,2))
    Quicksort.sort(List(1,2)) should === (List(1,2))
  }

  "Quicksort" should "sort a list of more than 2 elements" in {
    Quicksort.sort(List(1,2,3,4,5,6,7,8,9)) should === (List(1,2,3,4,5,6,7,8,9))
    Quicksort.sort(List(9,8,7,6,5,4,3,2,1)) should === (List(1,2,3,4,5,6,7,8,9))
    Quicksort.sort(List(1.0, 2.0, 0.0)) should === (List(0.0, 1.0, 2.0))
  }

}
